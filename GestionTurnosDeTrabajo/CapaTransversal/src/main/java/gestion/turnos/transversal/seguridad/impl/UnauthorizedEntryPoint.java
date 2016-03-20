package gestion.turnos.transversal.seguridad.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import gestion.turnos.transversal.excepciones.CustomExceptions.RestAPIGeneralException;
import gestion.turnos.transversal.excepciones.Error.RestError;

/**
 * {@link AuthenticationEntryPoint} that rejects all requests. Login-like function is featured
 * in {@link TokenAuthenticationFilter} and this does not perform or suggests any redirection.
 * This object is hit whenever user is not authorized (anonymous) and secured resource is requested.
 */


public final class UnauthorizedEntryPoint implements AuthenticationEntryPoint {

	@Autowired
	private AbstractHttpMessageConverter<RestError> converterJSON;
	
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
		HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		//DefaultJacksonHttpMessageConverter converterJSON = new DefaultJacksonHttpMessageConverter();
		RestError errorRestAPI = null;

		if (authException.getCause() != null && authException.getCause() instanceof RestAPIGeneralException) {
			RestAPIGeneralException excAcceso = (RestAPIGeneralException) authException.getCause();
			errorRestAPI = new RestError(HttpStatus.UNAUTHORIZED, excAcceso.getCodigo(), excAcceso.getMessage(), excAcceso.toString(), "...", excAcceso);
		} else if (authException instanceof InsufficientAuthenticationException) {
			/** El mensaje nos viene del Spring-security en ingles, lo traducimos. **/
			errorRestAPI = new RestError(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(), "El usuario no dispone de privilegios suficientes para realizar la operaci�n solicitada", authException.toString(), "...", authException);
		} else {
			errorRestAPI = new RestError(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(), authException.getMessage(), authException.toString(), "...", authException);
		}

		converterJSON.write(errorRestAPI, MediaType.APPLICATION_JSON, outputMessage);
	}
}