package gestion.turnos.transversal.seguridad.Impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.StringTokenizer;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.filter.GenericFilterBean;

import gestion.turnos.transversal.excepciones.CustomExceptions.RestAPIGeneralException;
import gestion.turnos.transversal.seguridad.AuthenticationService;
import gestion.turnos.transversal.seguridad.dto.UsuarioDTO;

/**
 * Takes care of HTTP request/response pre-processing for login/logout and token check.
 * Login can be performed on any URL, logout only on specified {@link #logoutLink}.
 * All the interaction with Spring Security should be performed via {@link AuthenticationService}.
 * <p>
 * {@link SecurityContextHolder} is used here only for debug outputs. While this class
 * is configured to be used by Spring Security (configured filter on FORM_LOGIN_FILTER position),
 * but it doesn't really depend on it at all.
 */
public final class TokenAuthenticationFilter extends GenericFilterBean {
	private static final String HEADER_TOKEN = "X-Auth-Token";
	private static final String HEADER_USERNAME = "X-Username";
	private static final String HEADER_PASSWORD = "X-Password";

	/** Request attribute that indicates that this filter will not continue with the chain. Handy after login/logout, etc. */
	private static final String REQUEST_ATTR_DO_NOT_CONTINUE = "MyAuthenticationFilter-doNotContinue";

	private final String logoutLink;
	private final String loginLink;
	private final AuthenticationService authenticationService;
	private final UnauthorizedEntryPoint restAuthenticationEntryPoint;

	private static final Logger log = Logger.getLogger(TokenAuthenticationFilter.class);	


	public TokenAuthenticationFilter(AuthenticationService authenticationService, String logoutLink, String loginLink, UnauthorizedEntryPoint restAuthenticationEntryPoint) {
		this.authenticationService = authenticationService;
		this.logoutLink = logoutLink;
		this.loginLink = loginLink;
		this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		log.info(" *** TokenAuthenticationFilter.doFilter");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		try{
			boolean authenticated = checkToken(httpRequest, httpResponse);
	
			if (canRequestProcessingContinue(httpRequest) && (httpRequest.getMethod().equals("POST") && (currentLink(httpRequest).equals(logoutLink) || currentLink(httpRequest).equals(loginLink)))) {
				// If we're not authenticated, we don't bother with logout at all.
				// Logout does not work in the same request with login - this does not make sense, because logout works with token and login returns it.
				if (authenticated) {
					checkLogout(httpRequest);
				} else {
					checkLogin(httpRequest, httpResponse);
				}
			}
	
			if (canRequestProcessingContinue(httpRequest)) {
				chain.doFilter(request, response);
			}
			
		}catch(AuthenticationException exception){
            SecurityContextHolder.clearContext();
            restAuthenticationEntryPoint.commence(httpRequest, httpResponse, exception);
        }
		log.info(" === AUTHENTICATION: " + SecurityContextHolder.getContext().getAuthentication());
	}

	private String checkLogin(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws AuthenticationException {
		String password = httpRequest.getHeader(HEADER_PASSWORD);
		String nUsuario = httpRequest.getHeader(HEADER_USERNAME);
		String token = "";
		
		if (nUsuario != null && password != null) {
			token = checkIdUsuarioAndInstitucion(nUsuario, password, httpResponse, httpRequest);
			doNotContinueWithRequestProcessing(httpRequest);
		} else {
			throw new BadCredentialsException("Error Autenticaci�n, par�metros recibidos incorrectos.");
		}
		
		return token;
	}

	private String checkIdUsuarioAndInstitucion(String nUsuario, String password, HttpServletResponse httpResponse, HttpServletRequest request) throws AuthenticationException {
		String tokenInfo = authenticationService.authenticate(nUsuario, password);
		if (tokenInfo != null) {
			 httpResponse.setHeader(HEADER_TOKEN, tokenInfo);
			 return tokenInfo;
		} else {
			throw new BadCredentialsException("Error en la autenticación usuario.");
		}
	}
	

	/** Returns true, if request contains valid authentication token. */
	private boolean checkToken(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws AuthenticationException {
		String token = httpRequest.getHeader(HEADER_TOKEN);
		try {
			if (token == null) {
				return false;
			}

			if (authenticationService.checkToken(token)) {
				log.info(" *** " + HEADER_TOKEN + " valid for: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
				return true;
			} else {
				log.info(" *** Invalid " + HEADER_TOKEN + ' ' + token);
				throw new BadCredentialsException("Token no válido");
			}
		} catch (RestAPIGeneralException e) {
			throw new BadCredentialsException("Error validando el token de acceso", e);
		}
	}

	private void checkLogout(HttpServletRequest httpRequest) {
		if (currentLink(httpRequest).equals(logoutLink)) {
			String token = httpRequest.getHeader(HEADER_TOKEN);
			/** We go here only authenticated, token must not be null **/
			authenticationService.logout(token);
			doNotContinueWithRequestProcessing(httpRequest);
		}
	}

	private String currentLink(HttpServletRequest httpRequest) {
		if (httpRequest.getPathInfo() == null) {
			return httpRequest.getServletPath();
		}
		return httpRequest.getServletPath() + httpRequest.getPathInfo();
	}

	/**
	 * This is set in cases when we don't want to continue down the filter chain. This occurs
	 * for any {@link HttpServletResponse#SC_UNAUTHORIZED} and also for login or logout.
	 */
	private void doNotContinueWithRequestProcessing(HttpServletRequest httpRequest) {
		httpRequest.setAttribute(REQUEST_ATTR_DO_NOT_CONTINUE, "1");
	}

	private boolean canRequestProcessingContinue(HttpServletRequest httpRequest) {
		return httpRequest.getAttribute(REQUEST_ATTR_DO_NOT_CONTINUE) == null;
	}
}
	