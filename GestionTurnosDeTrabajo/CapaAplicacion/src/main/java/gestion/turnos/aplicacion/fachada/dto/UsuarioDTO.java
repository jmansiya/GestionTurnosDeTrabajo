package gestion.turnos.aplicacion.fachada.dto;

import java.io.Serializable;

/**
 * 
 * @author JoseMansilla
 *  DTO para enviar a la capa de presentación la información acerca del usuario que se ha logado 
 *  en la aplicación.
 */
public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idPersona;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int idPerfil;
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsuarioDTO(int idPersona, String nombre, String apellido1, String apellido2, int idPerfil) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.idPerfil = idPerfil;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public int getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UsuarioDTO "
				+ " [idPersona=" + idPersona + ", "
					+ "nombre=" + nombre  
					+ ", apellido1=" + apellido1 
					+ ", apellido2=" + apellido2 
					+ ", idPerfil=" + idPerfil + "]";
	}
}
