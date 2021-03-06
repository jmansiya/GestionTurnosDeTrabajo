/*
 * Created on 31 oct 2015 ( Time 10:51:20 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a composite Primary Key  


package org.sun.resorts.holidays.model.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

/**
 * Persistent class for entity stored in table "detalle_planilla_has_empleados"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="detalle_planilla_has_empleados", catalog="sunholidayresortsbbdd" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="DetallePlanillaHasEmpleadosEntity.countAll", query="SELECT COUNT(x) FROM DetallePlanillaHasEmpleadosEntity x" )
} )
public class DetallePlanillaHasEmpleadosEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
	@EmbeddedId
    private DetallePlanillaHasEmpleadosEntityKey compositePrimaryKey ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public DetallePlanillaHasEmpleadosEntity() {
		super();
		this.compositePrimaryKey = new DetallePlanillaHasEmpleadosEntityKey();       
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE COMPOSITE KEY 
    //----------------------------------------------------------------------
    public void setDetallePlanillaIdDetalle( Integer detallePlanillaIdDetalle ) {
        this.compositePrimaryKey.setDetallePlanillaIdDetalle( detallePlanillaIdDetalle ) ;
    }
    public Integer getDetallePlanillaIdDetalle() {
        return this.compositePrimaryKey.getDetallePlanillaIdDetalle() ;
    }
    public void setEmpleadosIdempleados( Integer empleadosIdempleados ) {
        this.compositePrimaryKey.setEmpleadosIdempleados( empleadosIdempleados ) ;
    }
    public Integer getEmpleadosIdempleados() {
        return this.compositePrimaryKey.getEmpleadosIdempleados() ;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        if ( compositePrimaryKey != null ) {  
            sb.append(compositePrimaryKey.toString());  
        }  
        else {  
            sb.append( "(null-key)" ); 
        }  
        sb.append("]:"); 
        return sb.toString(); 
    } 

}
