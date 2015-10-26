/*
 * Created on 25 oct 2015 ( Time 10:44:44 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.sun.resorts.holidays.data.model;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "planillas"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="planillas", catalog="sunholidayresortsbbdd" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="PlanillasEntity.countAll", query="SELECT COUNT(x) FROM PlanillasEntity x" )
} )
public class PlanillasEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idPLANILLAS", nullable=false)
    private Integer    idplanillas  ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Temporal(TemporalType.DATE)
    @Column(name="FECHA", nullable=false)
    private Date       fecha        ;

    @Column(name="OBSERVACIONES", length=50)
    private String     observaciones ;

	// "idPuestoTrabajo" (column "ID_PUESTO_TRABAJO") is not defined by itself because used as FK in a link 
	// "idDetalle" (column "ID_DETALLE") is not defined by itself because used as FK in a link 
	// "idEstado" (column "ID_ESTADO") is not defined by itself because used as FK in a link 
	// "idTipoFecha" (column "ID_TIPO_FECHA") is not defined by itself because used as FK in a link 
	// "idVolumenEspecial" (column "ID_VOLUMEN_ESPECIAL") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToOne
    @JoinColumn(name="ID_DETALLE", referencedColumnName="idDETALLE_PLANILLA")
    private DetallePlanillaEntity detallePlanilla;

    @ManyToMany(mappedBy="listOfPlanillas", targetEntity=EmpleadosEntity.class)
    private List<EmpleadosEntity> listOfEmpleados;

    @ManyToOne
    @JoinColumn(name="ID_VOLUMEN_ESPECIAL", referencedColumnName="idVOLUMEN")
    private VolumenTrabajoEspecialEntity volumenTrabajoEspecial;

    @ManyToOne
    @JoinColumn(name="ID_ESTADO", referencedColumnName="idESTADOS")
    private EstadosEntity estados     ;

    @ManyToOne
    @JoinColumn(name="ID_PUESTO_TRABAJO", referencedColumnName="idPUESTO_DE_TRABAJO")
    private PuestoDeTrabajoEntity puestoDeTrabajo;

    @ManyToOne
    @JoinColumn(name="ID_TIPO_FECHA", referencedColumnName="idTIPO_FECHA")
    private TipoFechaEntity tipoFecha   ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public PlanillasEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIdplanillas( Integer idplanillas ) {
        this.idplanillas = idplanillas ;
    }
    public Integer getIdplanillas() {
        return this.idplanillas;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FECHA ( DATE ) 
    public void setFecha( Date fecha ) {
        this.fecha = fecha;
    }
    public Date getFecha() {
        return this.fecha;
    }

    //--- DATABASE MAPPING : OBSERVACIONES ( VARCHAR ) 
    public void setObservaciones( String observaciones ) {
        this.observaciones = observaciones;
    }
    public String getObservaciones() {
        return this.observaciones;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setDetallePlanilla( DetallePlanillaEntity detallePlanilla ) {
        this.detallePlanilla = detallePlanilla;
    }
    public DetallePlanillaEntity getDetallePlanilla() {
        return this.detallePlanilla;
    }

    public void setListOfEmpleados( List<EmpleadosEntity> listOfEmpleados ) {
        this.listOfEmpleados = listOfEmpleados;
    }
    public List<EmpleadosEntity> getListOfEmpleados() {
        return this.listOfEmpleados;
    }

    public void setVolumenTrabajoEspecial( VolumenTrabajoEspecialEntity volumenTrabajoEspecial ) {
        this.volumenTrabajoEspecial = volumenTrabajoEspecial;
    }
    public VolumenTrabajoEspecialEntity getVolumenTrabajoEspecial() {
        return this.volumenTrabajoEspecial;
    }

    public void setEstados( EstadosEntity estados ) {
        this.estados = estados;
    }
    public EstadosEntity getEstados() {
        return this.estados;
    }

    public void setPuestoDeTrabajo( PuestoDeTrabajoEntity puestoDeTrabajo ) {
        this.puestoDeTrabajo = puestoDeTrabajo;
    }
    public PuestoDeTrabajoEntity getPuestoDeTrabajo() {
        return this.puestoDeTrabajo;
    }

    public void setTipoFecha( TipoFechaEntity tipoFecha ) {
        this.tipoFecha = tipoFecha;
    }
    public TipoFechaEntity getTipoFecha() {
        return this.tipoFecha;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(idplanillas);
        sb.append("]:"); 
        sb.append(fecha);
        sb.append("|");
        sb.append(observaciones);
        return sb.toString(); 
    } 

}
