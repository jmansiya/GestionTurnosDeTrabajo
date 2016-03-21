package gestion.turnos.aplicacion.dataTransferObjects;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class TrabajadorDTO implements Serializable{
	private String     nombre       ;
 	private String     apellido1    ;
    private String     apellido2    ;
    private String     telefonoMovil ;
    private String     telefonoFijo ;
    private Date       fechaNacimiento ;
    private Date       fechaIncorporacion ;
    private DireccionDTO direccion;
    private String     dni          ;
    private Integer    numDiasVacaciones ;
    private String     email        ;
    private String 	descripcionTurnoTrabajo;
    private Integer    numDiasFestivosPendientes ;
	
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
	public String getTelefonoMovil() {
		return telefonoMovil;
	}
	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}
	public String getTelefonoFijo() {
		return telefonoFijo;
	}
	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Date getFechaIncorporacion() {
		return fechaIncorporacion;
	}
	public void setFechaIncorporacion(Date fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Integer getNumDiasVacaciones() {
		return numDiasVacaciones;
	}
	public void setNumDiasVacaciones(Integer numDiasVacaciones) {
		this.numDiasVacaciones = numDiasVacaciones;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getNumDiasFestivosPendientes() {
		return numDiasFestivosPendientes;
	}
	public void setNumDiasFestivosPendientes(Integer numDiasFestivosPendientes) {
		this.numDiasFestivosPendientes = numDiasFestivosPendientes;
	}
	public TrabajadorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DireccionDTO getDireccion() {
		return direccion;
	}
	public void setDireccion(DireccionDTO direccion) {
		this.direccion = direccion;
	}
	public String getDescripcionTurnoTrabajo() {
		return descripcionTurnoTrabajo;
	}
	public void setDescripcionTurnoTrabajo(String descripcionTurnoTrabajo) {
		this.descripcionTurnoTrabajo = descripcionTurnoTrabajo;
	}


}
