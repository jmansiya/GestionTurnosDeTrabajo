package gestion.turnos.transversal.seguridad.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * @author JoseMansilla
 *  DTO para enviar a la capa de presentaci�n la informaci�n acerca del usuario que se ha logado 
 *  en la aplicaci�n.
 */
public class UsuarioDTO implements Serializable, UserDetails {
	private static final long serialVersionUID = 1L;
	private int idPersona;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int idPerfil;
	private Date fechaAutenticacion;
	private Date fechaExpiracion;
	private String nombreCompleto;
	
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
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		if (fechaExpiracion.after(new Date())){
			return true;
		} else {
			return false;
		}
	}
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	public Date getFechaAutenticacion() {
		return fechaAutenticacion;
	}
	public void setFechaAutenticacion(Date fechaAutenticacion) {
		this.fechaAutenticacion = fechaAutenticacion;
	}
	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}
	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}
	public String getNombreCompleto() {
		return getNombre() + " " + getApellido1() + " " + getApellido2();
	}
	public String getUsername() {
		// TODO Auto-generated method stub
		return getNombre();
	}
}
