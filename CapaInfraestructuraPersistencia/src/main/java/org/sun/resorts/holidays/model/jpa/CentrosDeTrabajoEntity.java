/*
 * Created on 17 oct 2015 ( Time 10:46:15 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.sun.resorts.holidays.model.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "centros_de_trabajo"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="centros_de_trabajo" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="CentrosDeTrabajoEntity.countAll", query="SELECT COUNT(x) FROM CentrosDeTrabajoEntity x" )
} )
public class CentrosDeTrabajoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idCENTROS_DE_TRABAJO", nullable=false)
    private Integer    idcentrosDeTrabajo ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="NOMBRE", length=45)
    private String     nombre       ;

    @Column(name="DESCRIPCION", length=100)
    private String     descripcion  ;

    @Column(name="PARKING", nullable=false)
    private Boolean    parking      ;

    @Column(name="PISCINA", nullable=false)
    private Boolean    piscina      ;

    @Column(name="NUM_HABITACIONES", nullable=false)
    private Integer    numHabitaciones ;

    @Column(name="NUM_ESTRELLAS", nullable=false)
    private Integer    numEstrellas ;

	// "idAdministrador" (column "ID_ADMINISTRADOR") is not defined by itself because used as FK in a link 
	// "idDireccion" (column "ID_DIRECCION") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToOne
    @JoinColumn(name="ID_DIRECCION", referencedColumnName="idDIRECCION")
    private DireccionEntity direccion   ;

    @OneToMany(mappedBy="centrosDeTrabajo", targetEntity=PuestoDeTrabajoEntity.class)
    private List<PuestoDeTrabajoEntity> listOfPuestoDeTrabajo;

    @OneToOne
    @JoinColumn(name="ID_ADMINISTRADOR", referencedColumnName="idEMPLEADOS")
    private EmpleadosEntity empleados   ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public CentrosDeTrabajoEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIdcentrosDeTrabajo( Integer idcentrosDeTrabajo ) {
        this.idcentrosDeTrabajo = idcentrosDeTrabajo ;
    }
    public Integer getIdcentrosDeTrabajo() {
        return this.idcentrosDeTrabajo;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : NOMBRE ( VARCHAR ) 
    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return this.nombre;
    }

    //--- DATABASE MAPPING : DESCRIPCION ( VARCHAR ) 
    public void setDescripcion( String descripcion ) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return this.descripcion;
    }

    //--- DATABASE MAPPING : PARKING ( BIT ) 
    public void setParking( Boolean parking ) {
        this.parking = parking;
    }
    public Boolean getParking() {
        return this.parking;
    }

    //--- DATABASE MAPPING : PISCINA ( BIT ) 
    public void setPiscina( Boolean piscina ) {
        this.piscina = piscina;
    }
    public Boolean getPiscina() {
        return this.piscina;
    }

    //--- DATABASE MAPPING : NUM_HABITACIONES ( INT ) 
    public void setNumHabitaciones( Integer numHabitaciones ) {
        this.numHabitaciones = numHabitaciones;
    }
    public Integer getNumHabitaciones() {
        return this.numHabitaciones;
    }

    //--- DATABASE MAPPING : NUM_ESTRELLAS ( INT ) 
    public void setNumEstrellas( Integer numEstrellas ) {
        this.numEstrellas = numEstrellas;
    }
    public Integer getNumEstrellas() {
        return this.numEstrellas;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setDireccion( DireccionEntity direccion ) {
        this.direccion = direccion;
    }
    public DireccionEntity getDireccion() {
        return this.direccion;
    }

    public void setListOfPuestoDeTrabajo( List<PuestoDeTrabajoEntity> listOfPuestoDeTrabajo ) {
        this.listOfPuestoDeTrabajo = listOfPuestoDeTrabajo;
    }
    public List<PuestoDeTrabajoEntity> getListOfPuestoDeTrabajo() {
        return this.listOfPuestoDeTrabajo;
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
        sb.append(idcentrosDeTrabajo);
        sb.append("]:"); 
        sb.append(nombre);
        sb.append("|");
        sb.append(descripcion);
        sb.append("|");
        sb.append(parking);
        sb.append("|");
        sb.append(piscina);
        sb.append("|");
        sb.append(numHabitaciones);
        sb.append("|");
        sb.append(numEstrellas);
        return sb.toString(); 
    } 

}
