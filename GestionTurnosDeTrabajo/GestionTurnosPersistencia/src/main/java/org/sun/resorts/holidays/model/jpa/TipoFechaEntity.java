/*
 * Created on 31 oct 2015 ( Time 10:51:20 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.sun.resorts.holidays.model.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

/**
 * Persistent class for entity stored in table "tipo_fecha"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="tipo_fecha", catalog="sunholidayresortsbbdd" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TipoFechaEntity.countAll", query="SELECT COUNT(x) FROM TipoFechaEntity x" )
} )
public class TipoFechaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idTIPO_FECHA", nullable=false)
    private Integer    idtipoFecha  ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="DESCRIPCION", nullable=false, length=45)
    private String     descripcion  ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TipoFechaEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIdtipoFecha( Integer idtipoFecha ) {
        this.idtipoFecha = idtipoFecha ;
    }
    public Integer getIdtipoFecha() {
        return this.idtipoFecha;
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


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(idtipoFecha);
        sb.append("]:"); 
        sb.append(descripcion);
        return sb.toString(); 
    } 

}
