package gestion.turnos.servicios.distribuidos.controlAcceso;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gestion.turnos.transversal.excepciones.CustomExceptions.RestAPIGeneralException;
import gestion.turnos.transversal.excepciones.Error.RestError;

/**
 * 
 * @author JoseMansilla
 * Clase que nos serviró para controlar las peticiones de acceso a nuestra aplicación de
 * gestión de turnos de trabajo de la cadena hotelera.
 * 
 */

@RestController
@RequestMapping(value="/SunHolidaysAPI")
public class LoginController {
	
	@RequestMapping(value = "/login")
	@ResponseBody
	public String login(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String metodo = request.getMethod();
        throw new RestAPIGeneralException(HttpServletResponse.SC_METHOD_NOT_ALLOWED , "El recurso solicitado [" + uri  + "]  mediante el método [" +  metodo + "] no está permitido.", null, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String metodo = request.getMethod();
        throw new RestAPIGeneralException(HttpServletResponse.SC_METHOD_NOT_ALLOWED , "El recurso solicitado [" + uri  + "]  mediante el método [" +  metodo + "] no está permitido.", null, HttpStatus.METHOD_NOT_ALLOWED);	}
	
    @RequestMapping("/**")
    public void unmappedRequest(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String metodo = request.getMethod();
        throw new RestAPIGeneralException(HttpServletResponse.SC_NOT_FOUND , "El recurso solicitado [" + uri  + "]  mediante el método [" +  metodo + "] no existe.", null, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ResponseBody
    public RestError methodNotSupportErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    	throw new HttpRequestMethodNotSupportedException(req.getMethod(), "Excepcion capturada por fin!!");
    }	
}
