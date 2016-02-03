package gestion.turnos.transversal.excepciones.Error;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

public class RestError {

	@JsonProperty
	private final HttpStatus estado;
	@JsonProperty
	private final int codigo;
	@JsonProperty
	private final String mensaje;
	@JsonProperty
	private final String mensajeDesarrollo;
	@JsonProperty
	private final String masInformacion;
	@JsonProperty
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private StackTraceElement[] traza = new StackTraceElement[5];

	public RestError(HttpStatus status, int code, String message, String developerMessage, String moreInfoUrl, Throwable throwable) {
		if (status == null) {
			throw new NullPointerException("HttpStatus argument no puede ser null.");
		}
		this.estado = status;
		this.codigo = code;
		this.mensaje = message;
		this.mensajeDesarrollo = developerMessage;
		this.masInformacion = moreInfoUrl;

		if (throwable != null) {
			if (throwable.getStackTrace().length > 5){
				//Consideramos que con un array de 5  valores tenemos bastante 
				System.arraycopy(throwable.getStackTrace(), 0, traza, 0, 5);
			} else {
				this.traza = throwable.getStackTrace();
			}
			
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
        if (o instanceof RestError) {
            RestError re = (RestError) o;
            return ObjectUtils.nullSafeEquals(getEstado(), re.getEstado()) &&
                    getCodigo() == re.getCodigo() &&
                    ObjectUtils.nullSafeEquals(getMensaje(), re.getMensaje()) &&
                    ObjectUtils.nullSafeEquals(getMensajeDesarrollo(), re.getMensajeDesarrollo()) &&
                    ObjectUtils.nullSafeEquals(getMasInformacion(), re.getMasInformacion());
		}

		return false;
	}

	@Override
	public int hashCode() {
		return ObjectUtils.nullSafeHashCode(new Object[] { getEstado(), getCodigo(), getMensaje(), getMensajeDesarrollo(), getMasInformacion() });
    }

    @Override
	public String toString() {
		return "RestError [estado=" + estado + ", codigo=" + codigo
				+ ", mensaje=" + mensaje + ", mensajeDesarrollo="
				+ mensajeDesarrollo + ", masInformacion=" + masInformacion
				+ "]";
	}

	public HttpStatus getEstado() {
		return estado;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getMensajeDesarrollo() {
		return mensajeDesarrollo;
	}

	public String getMasInformacion() {
		return masInformacion;
	}

	public StackTraceElement[] getTraza() {
		return traza;
	}

	public void setTraza(StackTraceElement[] traza) {
		this.traza = traza;
	}
	
}