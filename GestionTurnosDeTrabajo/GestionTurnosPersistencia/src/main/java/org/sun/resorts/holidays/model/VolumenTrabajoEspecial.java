/*
 * Java bean class for entity table volumen_trabajo_especial 
 * Created on 28 oct 2015 ( Date ISO 2015-10-28 - Time 21:52:19 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */

package org.sun.resorts.holidays.model;

import java.io.Serializable;

import java.util.Date;

/**
 * Entity bean for table "volumen_trabajo_especial"
 * 
 * @author Telosys Tools Generator
 *
 */
public class VolumenTrabajoEspecial implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer    idvolumen    ; // Primary Key

    private Date       fechaInicio  ;
    private Date       fechaFin     ;
    private String     observaciones ;

    /**
     * Default constructor
     */
    public VolumenTrabajoEspecial()
    {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER(S) & SETTER(S) FOR THE PRIMARY KEY 
    //----------------------------------------------------------------------
    /**
     * Set the "idvolumen" field value
     * This field is mapped on the database column "idVOLUMEN" ( type "INT", NotNull : true ) 
     * @param idvolumen
     */
	public void setIdvolumen( Integer idvolumen )
    {
        this.idvolumen = idvolumen ;
    }
    /**
     * Get the "idvolumen" field value
     * This field is mapped on the database column "idVOLUMEN" ( type "INT", NotNull : true ) 
     * @return the field value
     */
	public Integer getIdvolumen()
    {
        return this.idvolumen;
    }

    //----------------------------------------------------------------------
    // GETTER(S) & SETTER(S) FOR DATA FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FECHA_INICIO ( DATE ) 
    /**
     * Set the "fechaInicio" field value
     * This field is mapped on the database column "FECHA_INICIO" ( type "DATE", NotNull : true ) 
     * @param fechaInicio
     */
    public void setFechaInicio( Date fechaInicio )
    {
        this.fechaInicio = fechaInicio;
    }
    /**
     * Get the "fechaInicio" field value
     * This field is mapped on the database column "FECHA_INICIO" ( type "DATE", NotNull : true ) 
     * @return the field value
     */
    public Date getFechaInicio()
    {
        return this.fechaInicio;
    }

    //--- DATABASE MAPPING : FECHA_FIN ( DATE ) 
    /**
     * Set the "fechaFin" field value
     * This field is mapped on the database column "FECHA_FIN" ( type "DATE", NotNull : true ) 
     * @param fechaFin
     */
    public void setFechaFin( Date fechaFin )
    {
        this.fechaFin = fechaFin;
    }
    /**
     * Get the "fechaFin" field value
     * This field is mapped on the database column "FECHA_FIN" ( type "DATE", NotNull : true ) 
     * @return the field value
     */
    public Date getFechaFin()
    {
        return this.fechaFin;
    }

    //--- DATABASE MAPPING : OBSERVACIONES ( VARCHAR ) 
    /**
     * Set the "observaciones" field value
     * This field is mapped on the database column "OBSERVACIONES" ( type "VARCHAR", NotNull : false ) 
     * @param observaciones
     */
    public void setObservaciones( String observaciones )
    {
        this.observaciones = observaciones;
    }
    /**
     * Get the "observaciones" field value
     * This field is mapped on the database column "OBSERVACIONES" ( type "VARCHAR", NotNull : false ) 
     * @return the field value
     */
    public String getObservaciones()
    {
        return this.observaciones;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(idvolumen);
        sb.append("|");
        sb.append(fechaInicio);
        sb.append("|");
        sb.append(fechaFin);
        sb.append("|");
        sb.append(observaciones);
        return sb.toString(); 
    } 


}
