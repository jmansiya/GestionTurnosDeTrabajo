package gestion.turnos.servicios.distribuidos;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import gestion.turnos.transversal.excepciones.CustomExceptions.RestAPIGeneralException;
import gestion.turnos.transversal.excepciones.Error.RestError;

@ControllerAdvice
public class ApiExceptionHandlerControllerAdvice {
	
    /**
     * Handle exceptions thrown by Access Denied
     */
    @ExceptionHandler(value = RestAPIGeneralException.class)
    @ResponseBody
    public ResponseEntity<RestError> exceptionNoAutorizado(HttpServletResponse httpRes, RestAPIGeneralException exception) throws Exception{
    	httpRes.setStatus(exception.getEstado().value());
    	
    	RestError error = createRestError(exception, exception.getEstado(), "...");
        return new ResponseEntity<RestError>(error, error.getEstado());
    }
    
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ResponseEntity<RestError> handle(HttpRequestMethodNotSupportedException o_O)  throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.setAllow(o_O.getSupportedHttpMethods());

    	RestError error = createRestError(o_O, HttpStatus.METHOD_NOT_ALLOWED, "...");
    	return new ResponseEntity<RestError>(error, error.getEstado());
    }
    
    /**
     * Handle exceptions thrown by handlers.
     */
    @ExceptionHandler(value = NotImplementedException.class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @ResponseBody
    public ResponseEntity<RestError> exceptionNotImplementedException(NotImplementedException exception) throws Exception {
    	RestError error = createRestError(exception, HttpStatus.NOT_IMPLEMENTED, "..."); 
        return new ResponseEntity<RestError>(error, error.getEstado());
    }
    
    /**
     * Handle exceptions thrown by handlers.
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<RestError> exception(Exception exception) throws Exception {
    	try{
    		RestError error = createRestError(exception, HttpStatus.INTERNAL_SERVER_ERROR, "..."); 
    		return new ResponseEntity<RestError>(error, error.getEstado());
    	}catch (Exception e) {
    		RestError error = createRestError(e, HttpStatus.INTERNAL_SERVER_ERROR, "..."); 
    		return new ResponseEntity<RestError>(error, error.getEstado());
		}
    }
    
    private RestError createRestError(Exception e, HttpStatus estado, String masInformacion){
    	RestError error = null;
    	if (HttpStatus.METHOD_NOT_ALLOWED == estado){
    		error = new RestError(estado, estado.value(), "El método solicitado para el recurso no está permitido.", "El método solicitado para el recurso no está permitido.", masInformacion, e);	
    	} else {
    		error = new RestError(estado, estado.value(), e.getMessage(), e.toString(), masInformacion, e);	
    	}
    	
    	return error;
    }
  
}