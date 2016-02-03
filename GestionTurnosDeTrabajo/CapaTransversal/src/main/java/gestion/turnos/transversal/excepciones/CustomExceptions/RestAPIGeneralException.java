package gestion.turnos.transversal.excepciones.CustomExceptions;

import org.springframework.http.HttpStatus;

import gestion.turnos.transversal.excepciones.utils.ErrorMessagesUtils.ErrorsRestServicesFichaColegial;

/**
 * Simulated business-logic exception indicating a desired business entity or record cannot be found.
 */
public class RestAPIGeneralException extends RuntimeException {
	private int codigo; // Prueba para generar subcodigos para identificar los distintos errores que probacan esta excepcion.
	private Throwable exception;
	private HttpStatus estado;
	
	public RestAPIGeneralException(ErrorsRestServicesFichaColegial ErrorRSFichaColegial) {
		super(ErrorRSFichaColegial.getMensajeError());
		this.codigo = ErrorRSFichaColegial.getCodigo();
		this.estado = ErrorRSFichaColegial.getEstado();
	}	
	
	public RestAPIGeneralException(int codigo, String mensaje) {
		super(mensaje);
		this.codigo = codigo;
	}

	public RestAPIGeneralException(ErrorsRestServicesFichaColegial ErrorRSFichaColegial, Throwable exception) {
		super(ErrorRSFichaColegial.getMensajeError(), exception);
		this.codigo = ErrorRSFichaColegial.getCodigo();
		this.exception = exception;
		this.estado = ErrorRSFichaColegial.getEstado();
	}	
	
	public RestAPIGeneralException(int codigo, String mensaje, Throwable exception) {
		super(mensaje, exception);
		this.codigo = codigo;
		this.exception = exception;
	}

	public RestAPIGeneralException(int codigo, String mensaje, Throwable exception, HttpStatus estado) {
		super(mensaje, exception);
		this.codigo = codigo;
		this.exception = exception;
		this.estado = estado;
	}

	public Throwable getException() {
		return exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public HttpStatus getEstado() {
		return estado;
	}

	public void setEstado(HttpStatus estado) {
		this.estado = estado;
	}

}