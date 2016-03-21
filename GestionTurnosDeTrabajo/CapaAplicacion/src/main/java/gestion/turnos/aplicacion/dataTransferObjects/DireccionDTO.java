package gestion.turnos.aplicacion.dataTransferObjects;

public class DireccionDTO {
    private Integer    iddireccion  ; // Primary Key

    private String     direccion    ;
    private String     codigoPostal ;
    private String     localidad    ;
    private String     provincia    ;
    private String     pais         ;
	public DireccionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIddireccion() {
		return iddireccion;
	}
	public void setIddireccion(Integer iddireccion) {
		this.iddireccion = iddireccion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
    
}
