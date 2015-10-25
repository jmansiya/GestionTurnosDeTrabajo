/*
 * Created on 17 oct 2015 ( Time 10:46:15 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.sun.resorts.holidays.data.model;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "dias_festivos_pendientes"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="dias_festivos_pendientes" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="DiasFestivosPendientesEntity.countAll", query="SELECT COUNT(x) FROM DiasFestivosPendientesEntity x" )
} )
public class DiasFestivosPendientesEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idDIAS_FESTIVOS_PENDIENTES", nullable=false)
    private Integer    iddiasFestivosPendientes ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="DESCRIPCION", nullable=false, length=65)
    private String     descripcion  ;

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_SOLICITUD", nullable=false)
    private Date       fechaSolicitud ;

	// "idEstadoSolicitud" (column "ID_ESTADO_SOLICITUD") is not defined by itself because used as FK in a link 
	// "idEmpleado" (column "ID_EMPLEADO") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="ID_EMPLEADO", referencedColumnName="idEMPLEADOS")
    private EmpleadosEntity empleados   ;

    @ManyToOne
    @JoinColumn(name="ID_ESTADO_SOLICITUD", referencedColumnName="idESTADOS")
    private EstadosEntity estados     ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public DiasFestivosPendientesEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIddiasFestivosPendientes( Integer iddiasFestivosPendientes ) {
        this.iddiasFestivosPendientes = iddiasFestivosPendientes ;
    }
    public Integer getIddiasFestivosPendientes() {
        return this.iddiasFestivosPendientes;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : DESCRIPCION ( VARCHAR ) 
    public void setDescripcion( String descripcion ) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return this.descripcion;
    }

    //--- DATABASE MAPPING : FECHA_SOLICITUD ( DATE ) 
    public void setFechaSolicitud( Date fechaSolicitud ) {
        this.fechaSolicitud = fechaSolicitud;
    }
    public Date getFechaSolicitud() {
        return this.fechaSolicitud;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setEmpleados( EmpleadosEntity empleados ) {
        this.empleados = empleados;
    }
    public EmpleadosEntity getEmpleados() {
        return this.empleados;
    }

    public void setEstados( EstadosEntity estados ) {
        this.estados = estados;
    }
    public EstadosEntity getEstados() {
        return this.estados;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(iddiasFestivosPendientes);
        sb.append("]:"); 
        sb.append(descripcion);
        sb.append("|");
        sb.append(fechaSolicitud);
        return sb.toString(); 
    } 

}