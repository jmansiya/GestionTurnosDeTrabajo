/*
 * Created on 28 oct 2015 ( Time 21:33:28 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.sun.resorts.holidays.model.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "vacaciones"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="vacaciones", catalog="sunholidayresortsbbdd" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="VacacionesEntity.countAll", query="SELECT COUNT(x) FROM VacacionesEntity x" )
} )
public class VacacionesEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idVACACIONES", nullable=false)
    private Integer    idvacaciones ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="OBSERVACIONES", nullable=false, length=45)
    private String     observaciones ;

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_VACACIONES", nullable=false)
    private Date       fechaVacaciones ;

    @Column(name="FESTIVO_PENDIENTE", nullable=false)
    private Boolean    festivoPendiente ;

	// "empleadosIdempleados" (column "EMPLEADOS_idEMPLEADOS") is not defined by itself because used as FK in a link 
	// "estado" (column "ESTADO") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="ESTADO", referencedColumnName="idESTADOS")
    private EstadosEntity estados     ;

    @ManyToOne
    @JoinColumn(name="EMPLEADOS_idEMPLEADOS", referencedColumnName="idEMPLEADOS")
    private EmpleadosEntity empleados   ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public VacacionesEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIdvacaciones( Integer idvacaciones ) {
        this.idvacaciones = idvacaciones ;
    }
    public Integer getIdvacaciones() {
        return this.idvacaciones;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : OBSERVACIONES ( VARCHAR ) 
    public void setObservaciones( String observaciones ) {
        this.observaciones = observaciones;
    }
    public String getObservaciones() {
        return this.observaciones;
    }

    //--- DATABASE MAPPING : FECHA_VACACIONES ( DATE ) 
    public void setFechaVacaciones( Date fechaVacaciones ) {
        this.fechaVacaciones = fechaVacaciones;
    }
    public Date getFechaVacaciones() {
        return this.fechaVacaciones;
    }

    //--- DATABASE MAPPING : FESTIVO_PENDIENTE ( BIT ) 
    public void setFestivoPendiente( Boolean festivoPendiente ) {
        this.festivoPendiente = festivoPendiente;
    }
    public Boolean getFestivoPendiente() {
        return this.festivoPendiente;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setEstados( EstadosEntity estados ) {
        this.estados = estados;
    }
    public EstadosEntity getEstados() {
        return this.estados;
    }

    public void setEmpleados( EmpleadosEntity empleados ) {
        this.empleados = empleados;
    }
    public EmpleadosEntity getEmpleados() {
        return this.empleados;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(idvacaciones);
        sb.append("]:"); 
        sb.append(observaciones);
        sb.append("|");
        sb.append(fechaVacaciones);
        sb.append("|");
        sb.append(festivoPendiente);
        return sb.toString(); 
    } 

}
