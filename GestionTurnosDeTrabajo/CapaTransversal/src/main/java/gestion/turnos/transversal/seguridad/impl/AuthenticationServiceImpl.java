package gestion.turnos.transversal.seguridad.impl;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import gestion.turnos.transversal.excepciones.CustomExceptions.RestAPIGeneralException;
import gestion.turnos.transversal.excepciones.utils.ErrorMessagesUtils.ErrorsRestServicesFichaColegial;
import gestion.turnos.transversal.seguridad.AuthenticationService;
import gestion.turnos.transversal.seguridad.IJWTwebTokens;
import gestion.turnos.transversal.seguridad.dto.UsuarioDTO;



/**
 * Service responsible for all around authentication, token checks, etc.
 * This class does not care about HTTP protocol at all.
 */

public class AuthenticationServiceImpl implements AuthenticationService {
	private final AuthenticationManager authenticationManager;
	private final IJWTwebTokens tokenManager;
	
	//De momento lo dejamos en 1 hora
	private final long tiempoExpiracion = 3600000l;//0000l;
	
	private static final Logger log = Logger.getLogger(AuthenticationServiceImpl.class);

	public AuthenticationServiceImpl(AuthenticationManager authenticationManager, IJWTwebTokens tokenManager) {
		this.authenticationManager = authenticationManager;
		this.tokenManager = tokenManager;
	}

	public String authenticate(String nUsuario, String password) throws RestAPIGeneralException, AuthenticationException {
		log.info(" *** AuthenticationServiceImpl.authenticate");

		Authentication authentication = new UsernamePasswordAuthenticationToken(nUsuario, password);
		try {
			authentication = authenticationManager.authenticate(authentication);
			// Here principal=UserDetails (UserContext in our case), credentials=null (security reasons)
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			if (authentication.getPrincipal() != null) {
				UsuarioDTO userContext = (UsuarioDTO) authentication.getPrincipal();
				userContext.setCredenciales(password);
				String newToken = tokenManager.createJWT(userContext, tiempoExpiracion);
				
				log.info("Nuevo TOKEN generado: " + newToken);
				if (newToken == null) {
					throw new RestAPIGeneralException(ErrorsRestServicesFichaColegial.ERSFC_401_004);
				}
				return newToken;
			}
		} catch (AuthenticationException e) {
			log.info(" *** AuthenticationServiceImpl.authenticate - FAILED: " + e.toString());
			throw e;
		}
		
		throw new RestAPIGeneralException(ErrorsRestServicesFichaColegial.ERSFC_401_003);
	}
	
	public boolean checkToken(String token) throws RestAPIGeneralException {
		log.info(" *** AuthenticationServiceImpl.checkToken");
		
		UsuarioDTO userDetails = tokenManager.parseJWT(token);
		if (userDetails == null){
			throw new RestAPIGeneralException(ErrorsRestServicesFichaColegial.ERSFC_401_001);
		}
		
		if (!userDetails.isAccountNonExpired()){
			throw new RestAPIGeneralException(ErrorsRestServicesFichaColegial.ERSFC_401_002);
		}
		
		UsernamePasswordAuthenticationToken securityToken = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getCredenciales(), (Collection<? extends GrantedAuthority>) userDetails.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(securityToken);
		return true;
	}

	public void logout(String token) {
		SecurityContextHolder.clearContext();
	}

	public UserDetails currentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return null;
		}
		
		return (UserDetails) authentication.getPrincipal();
	}

	

}
