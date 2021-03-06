/*
 * Java bean class for entity table puesto_de_trabajo 
 * Created on 31 oct 2015 ( Date ISO 2015-10-31 - Time 10:15:17 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */

package org.sun.resorts.holidays.model;

import java.io.Serializable;


/**
 * Entity bean for table "puesto_de_trabajo"
 * 
 * @author Telosys Tools Generator
 *
 */
public class PuestoDeTrabajo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer    idpuestoDeTrabajo ; // Primary Key

    private String     nombre       ;
    private String     descripcion  ;
    private Integer    idCentrosTrabajo ;
    private Integer    idSupervisor ;

    /**
     * Default constructor
     */
    public PuestoDeTrabajo()
    {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER(S) & SETTER(S) FOR THE PRIMARY KEY 
    //----------------------------------------------------------------------
    /**
     * Set the "idpuestoDeTrabajo" field value
     * This field is mapped on the database column "idPUESTO_DE_TRABAJO" ( type "INT", NotNull : true ) 
     * @param idpuestoDeTrabajo
     */
	public void setIdpuestoDeTrabajo( Integer idpuestoDeTrabajo )
    {
        this.idpuestoDeTrabajo = idpuestoDeTrabajo ;
    }
    /**
     * Get the "idpuestoDeTrabajo" field value
     * This field is mapped on the database column "idPUESTO_DE_TRABAJO" ( type "INT", NotNull : true ) 
     * @return the field value
     */
	public Integer getIdpuestoDeTrabajo()
    {
        return this.idpuestoDeTrabajo;
    }

    //----------------------------------------------------------------------
    // GETTER(S) & SETTER(S) FOR DATA FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : NOMBRE ( VARCHAR ) 
    /**
     * Set the "nombre" field value
     * This field is mapped on the database column "NOMBRE" ( type "VARCHAR", NotNull : true ) 
     * @param nombre
     */
    public void setNombre( String nombre )
    {
        this.nombre = nombre;
    }
    /**
     * Get the "nombre" field value
     * This field is mapped on the database column "NOMBRE" ( type "VARCHAR", NotNull : true ) 
     * @return the field value
     */
    public String getNombre()
    {
        return this.nombre;
    }

    //--- DATABASE MAPPING : DESCRIPCION ( VARCHAR ) 
    /**
     * Set the "descripcion" field value
     * This field is mapped on the database column "DESCRIPCION" ( type "VARCHAR", NotNull : false ) 
     * @param descripcion
     */
    public void setDescripcion( String descripcion )
    {
        this.descripcion = descripcion;
    }
    /**
     * Get the "descripcion" field value
     * This field is mapped on the database column "DESCRIPCION" ( type "VARCHAR", NotNull : false ) 
     * @return the field value
     */
    public String getDescripcion()
    {
        return this.descripcion;
    }

    //--- DATABASE MAPPING : ID_CENTROS_TRABAJO ( INT ) 
    /**
     * Set the "idCentrosTrabajo" field value
     * This field is mapped on the database column "ID_CENTROS_TRABAJO" ( type "INT", NotNull : true ) 
     * @param idCentrosTrabajo
     */
    public void setIdCentrosTrabajo( Integer idCentrosTrabajo )
    {
        this.idCentrosTrabajo = idCentrosTrabajo;
    }
    /**
     * Get the "idCentrosTrabajo" field value
     * This field is mapped on the database column "ID_CENTROS_TRABAJO" ( type "INT", NotNull : true ) 
     * @return the field value
     */
    public Integer getIdCentrosTrabajo()
    {
        return this.idCentrosTrabajo;
    }

    //--- DATABASE MAPPING : ID_SUPERVISOR ( INT ) 
    /**
     * Set the "idSupervisor" field value
     * This field is mapped on the database column "ID_SUPERVISOR" ( type "INT", NotNull : false ) 
     * @param idSupervisor
     */
    public void setIdSupervisor( Integer idSupervisor )
    {
        this.idSupervisor = idSupervisor;
    }
    /**
     * Get the "idSupervisor" field value
     * This field is mapped on the database column "ID_SUPERVISOR" ( type "INT", NotNull : false ) 
     * @return the field value
     */
    public Integer getIdSupervisor()
    {
        return this.idSupervisor;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(idpuestoDeTrabajo);
        sb.append("|");
        sb.append(nombre);
        sb.append("|");
        sb.append(descripcion);
        sb.append("|");
        sb.append(idCentrosTrabajo);
        sb.append("|");
        sb.append(idSupervisor);
        return sb.toString(); 
    } 


}
