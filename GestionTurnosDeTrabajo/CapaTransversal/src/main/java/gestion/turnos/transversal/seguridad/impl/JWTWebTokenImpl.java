package gestion.turnos.transversal.seguridad.impl;

import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.sun.resorts.holidays.model.Perfiles;

import gestion.turnos.transversal.seguridad.IJWTwebTokens;
import gestion.turnos.transversal.seguridad.dto.UsuarioDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTWebTokenImpl implements IJWTwebTokens {
	
	private final String CLAVE_CODIFICADORA = "GESTION_TURNOS_TRABAJO";
	
	private static final Logger log = Logger.getLogger(JWTWebTokenImpl.class);
	
	public String createJWT(UsuarioDTO usuario, long ttlMillis) {
		// The JWT signature algorithm we will be using to sign the token
		if (usuario == null) {
			log.info("Usuario NULO, no se puede crear el token!");
			return null;
		} else {
			log.info(usuario.toString());
		}

		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(CLAVE_CODIFICADORA);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		/*
		 * String autoritiys
		 */
		String autorities = "";
		if (usuario.getAuthorities() != null){
			Iterator<? extends GrantedAuthority> iter = usuario.getAuthorities().iterator();
			while(iter.hasNext()){
				if (autorities.equals("")){
					autorities = autorities + iter.next().getAuthority();	
				} else {
					autorities = autorities + "," + iter.next().getAuthority();
				}
			}
		}
		
		JwtBuilder builder = Jwts.builder().setId("" + (usuario.getIdPersona()))
		                                .setIssuedAt(now)
		                                .setSubject(usuario.getUsername())
		                                .claim("idPersona", usuario.getIdPersona())
		                                .claim("nombre", usuario.getNombre())
		                                .claim("apellido1", usuario.getApellido1())
		                                .claim("apellido2", usuario.getApellido2())
		                                .claim("roles", usuario.getIdPerfil())
		                                .claim("authorities", autorities)
		                                .claim("credenciales", usuario.getCredenciales())
		                                .signWith(signatureAlgorithm, signingKey);

		// if it has been specified, let's add the expiration
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		
		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	@SuppressWarnings("unchecked")
	public UsuarioDTO parseJWT(String jwt) {
		// TODO Auto-generated method stub
		UsuarioDTO usuario = new UsuarioDTO();

		try {
			Claims claims = Jwts.parser()         
					   .setSigningKey(DatatypeConverter.parseBase64Binary(CLAVE_CODIFICADORA))
					   .parseClaimsJws(jwt).getBody();
            
			usuario.setNombre((String) claims.get("nombre"));
			usuario.setIdPerfil(claims.get("roles") == null ? -1 : ((Integer) claims.get("roles")).intValue());
			usuario.setApellido1((String) claims.get("apellido1"));
			usuario.setApellido2((String) claims.get("apellido2"));
			usuario.setIdPersona(claims.get("idPersona") == null ? -1 : ((Integer) claims.get("idPersona")).intValue());
			usuario.setFechaAutenticacion(claims.getIssuedAt());
			usuario.setFechaExpiracion(claims.getExpiration());
			
			String autorities = (String) claims.get("authorities");
			List<GrantedAuthority> authoroties = new ArrayList<GrantedAuthority>();
			
			if(autorities != null){
				String[] arrAutoridades = null;
				if (autorities.indexOf(",") != -1){
					arrAutoridades = autorities.split(",");					
				} else {
					arrAutoridades = new String[1];
					arrAutoridades[0] = autorities;
				}
				
				for(String roleStr : arrAutoridades){
					GrantedAuthority role = new SimpleGrantedAuthority(roleStr);
					authoroties.add(role);	
				}				
			}
			
			usuario.setAuthorities(authoroties);
			usuario.setCredenciales((String) claims.get("credenciales"));
			log.info("ROLE obtenido :: " + usuario.getIdPerfil());

			log.info("USUARIO logado : " + usuario.toString());
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
