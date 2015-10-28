/*
 * Created on 28 oct 2015 ( Time 21:33:28 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.model.jpa;
import java.io.Serializable;

import javax.persistence.*;

/**
 * Composite primary key for entity "TurnosTrabajoEspecialesEntity" ( stored in table "turnos_trabajo_especiales" )
 *
 * @author Telosys Tools Generator
 *
 */
 @Embeddable
public class TurnosTrabajoEspecialesEntityKey implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY KEY ATTRIBUTES 
    //----------------------------------------------------------------------
    @Column(name="EMPLEADOS_idEMPLEADOS", nullable=false)
    private Integer    empleadosIdempleados ;
    
    @Column(name="TURNOS_DE_TRABAJO_idTURNOS_DE_TRABAJO", nullable=false)
    private Integer    turnosDeTrabajoIdturnosDeTrabajo ;
    

    //----------------------------------------------------------------------
    // CONSTRUCTORS
    //----------------------------------------------------------------------
    public TurnosTrabajoEspecialesEntityKey() {
        super();
    }

    public TurnosTrabajoEspecialesEntityKey( Integer empleadosIdempleados, Integer turnosDeTrabajoIdturnosDeTrabajo ) {
        super();
        this.empleadosIdempleados = empleadosIdempleados ;
        this.turnosDeTrabajoIdturnosDeTrabajo = turnosDeTrabajoIdturnosDeTrabajo ;
    }
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR KEY FIELDS
    //----------------------------------------------------------------------
    public void setEmpleadosIdempleados( Integer value ) {
        this.empleadosIdempleados = value;
    }
    public Integer getEmpleadosIdempleados() {
        return this.empleadosIdempleados;
    }

    public void setTurnosDeTrabajoIdturnosDeTrabajo( Integer value ) {
        this.turnosDeTrabajoIdturnosDeTrabajo = value;
    }
    public Integer getTurnosDeTrabajoIdturnosDeTrabajo() {
        return this.turnosDeTrabajoIdturnosDeTrabajo;
    }


    //----------------------------------------------------------------------
    // equals METHOD
    //----------------------------------------------------------------------
	public boolean equals(Object obj) { 
		if ( this == obj ) return true ; 
		if ( obj == null ) return false ;
		if ( this.getClass() != obj.getClass() ) return false ; 
		TurnosTrabajoEspecialesEntityKey other = (TurnosTrabajoEspecialesEntityKey) obj; 
		//--- Attribute empleadosIdempleados
		if ( empleadosIdempleados == null ) { 
			if ( other.empleadosIdempleados != null ) 
				return false ; 
		} else if ( ! empleadosIdempleados.equals(other.empleadosIdempleados) ) 
			return false ; 
		//--- Attribute turnosDeTrabajoIdturnosDeTrabajo
		if ( turnosDeTrabajoIdturnosDeTrabajo == null ) { 
			if ( other.turnosDeTrabajoIdturnosDeTrabajo != null ) 
				return false ; 
		} else if ( ! turnosDeTrabajoIdturnosDeTrabajo.equals(other.turnosDeTrabajoIdturnosDeTrabajo) ) 
			return false ; 
		return true; 
	} 


    //----------------------------------------------------------------------
    // hashCode METHOD
    //----------------------------------------------------------------------
	public int hashCode() { 
		final int prime = 31; 
		int result = 1; 
		
		//--- Attribute empleadosIdempleados
		result = prime * result + ((empleadosIdempleados == null) ? 0 : empleadosIdempleados.hashCode() ) ; 
		//--- Attribute turnosDeTrabajoIdturnosDeTrabajo
		result = prime * result + ((turnosDeTrabajoIdturnosDeTrabajo == null) ? 0 : turnosDeTrabajoIdturnosDeTrabajo.hashCode() ) ; 
		
		return result; 
	} 


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() {
		StringBuffer sb = new StringBuffer(); 
		sb.append(empleadosIdempleados); 
		sb.append("|"); 
		sb.append(turnosDeTrabajoIdturnosDeTrabajo); 
        return sb.toString();
    }
}