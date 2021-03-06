/*
 * Created on 31 oct 2015 ( Time 10:51:20 )
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
 * Persistent class for entity stored in table "puesto_de_trabajo"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="puesto_de_trabajo", catalog="sunholidayresortsbbdd" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="PuestoDeTrabajoEntity.countAll", query="SELECT COUNT(x) FROM PuestoDeTrabajoEntity x" )
} )
public class PuestoDeTrabajoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idPUESTO_DE_TRABAJO", nullable=false)
    private Integer    idpuestoDeTrabajo ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="NOMBRE", nullable=false, length=45)
    private String     nombre       ;

    @Column(name="DESCRIPCION", length=85)
    private String     descripcion  ;

	// "idCentrosTrabajo" (column "ID_CENTROS_TRABAJO") is not defined by itself because used as FK in a link 
	// "idSupervisor" (column "ID_SUPERVISOR") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToOne
    @JoinColumn(name="ID_SUPERVISOR", referencedColumnName="idEMPLEADOS")
    private EmpleadosEntity coordinador ;

    @OneToMany(mappedBy="puestoDeTrabajo", targetEntity=TurnosDeTrabajoEntity.class)
    private List<TurnosDeTrabajoEntity> listOfTurnosDeTrabajo;

    @OneToOne(mappedBy="coordinadorPuestoTrabajo", targetEntity=HorarioEntity.class)
    private HorarioEntity listOfHorario;

    @OneToMany(mappedBy="puestoDeTrabajo", targetEntity=VolumenTrabajoEspecialEntity.class)
    private List<VolumenTrabajoEspecialEntity> listOfVolumenTrabajoEspecial;

    @OneToMany(mappedBy="puestoDeTrabajo", targetEntity=PlanillasEntity.class)
    private List<PlanillasEntity> listOfPlanillas;

    @ManyToOne
    @JoinColumn(name="ID_CENTROS_TRABAJO", referencedColumnName="idCENTROS_DE_TRABAJO")
    private CentrosDeTrabajoEntity centrosDeTrabajo;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public PuestoDeTrabajoEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIdpuestoDeTrabajo( Integer idpuestoDeTrabajo ) {
        this.idpuestoDeTrabajo = idpuestoDeTrabajo ;
    }
    public Integer getIdpuestoDeTrabajo() {
        return this.idpuestoDeTrabajo;
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


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setCoordinador( EmpleadosEntity coordinador ) {
        this.coordinador = coordinador;
    }
    public EmpleadosEntity getCoordinador() {
        return this.coordinador;
    }

    public void setListOfTurnosDeTrabajo( List<TurnosDeTrabajoEntity> listOfTurnosDeTrabajo ) {
        this.listOfTurnosDeTrabajo = listOfTurnosDeTrabajo;
    }
    public List<TurnosDeTrabajoEntity> getListOfTurnosDeTrabajo() {
        return this.listOfTurnosDeTrabajo;
    }

    public void setListOfHorario( HorarioEntity listOfHorario ) {
        this.listOfHorario = listOfHorario;
    }
    public HorarioEntity getListOfHorario() {
        return this.listOfHorario;
    }

    public void setListOfVolumenTrabajoEspecial( List<VolumenTrabajoEspecialEntity> listOfVolumenTrabajoEspecial ) {
        this.listOfVolumenTrabajoEspecial = listOfVolumenTrabajoEspecial;
    }
    public List<VolumenTrabajoEspecialEntity> getListOfVolumenTrabajoEspecial() {
        return this.listOfVolumenTrabajoEspecial;
    }

    public void setListOfPlanillas( List<PlanillasEntity> listOfPlanillas ) {
        this.listOfPlanillas = listOfPlanillas;
    }
    public List<PlanillasEntity> getListOfPlanillas() {
        return this.listOfPlanillas;
    }

    public void setCentrosDeTrabajo( CentrosDeTrabajoEntity centrosDeTrabajo ) {
        this.centrosDeTrabajo = centrosDeTrabajo;
    }
    public CentrosDeTrabajoEntity getCentrosDeTrabajo() {
        return this.centrosDeTrabajo;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(idpuestoDeTrabajo);
        sb.append("]:"); 
        sb.append(nombre);
        sb.append("|");
        sb.append(descripcion);
        return sb.toString(); 
    } 

}
