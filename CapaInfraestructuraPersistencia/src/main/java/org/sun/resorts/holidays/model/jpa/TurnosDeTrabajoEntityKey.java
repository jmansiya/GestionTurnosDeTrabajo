/*
 * Created on 17 oct 2015 ( Time 10:46:16 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.model.jpa;
import java.io.Serializable;

import javax.persistence.*;

/**
 * Composite primary key for entity "TurnosDeTrabajoEntity" ( stored in table "turnos_de_trabajo" )
 *
 * @author Telosys Tools Generator
 *
 */
 @Embeddable
public class TurnosDeTrabajoEntityKey implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY KEY ATTRIBUTES 
    //----------------------------------------------------------------------
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idTURNOS_DE_TRABAJO", nullable=false)
    private Integer    idturnosDeTrabajo ;
    
    @Column(name="ID_PUESTO_TRABAJO", nullable=false)
    private Integer    idPuestoTrabajo ;
    

    //----------------------------------------------------------------------
    // CONSTRUCTORS
    //----------------------------------------------------------------------
    public TurnosDeTrabajoEntityKey() {
        super();
    }

    public TurnosDeTrabajoEntityKey( Integer idturnosDeTrabajo, Integer idPuestoTrabajo ) {
        super();
        this.idturnosDeTrabajo = idturnosDeTrabajo ;
        this.idPuestoTrabajo = idPuestoTrabajo ;
    }
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR KEY FIELDS
    //----------------------------------------------------------------------
    public void setIdturnosDeTrabajo( Integer value ) {
        this.idturnosDeTrabajo = value;
    }
    public Integer getIdturnosDeTrabajo() {
        return this.idturnosDeTrabajo;
    }

    public void setIdPuestoTrabajo( Integer value ) {
        this.idPuestoTrabajo = value;
    }
    public Integer getIdPuestoTrabajo() {
        return this.idPuestoTrabajo;
    }


    //----------------------------------------------------------------------
    // equals METHOD
    //----------------------------------------------------------------------
	public boolean equals(Object obj) { 
		if ( this == obj ) return true ; 
		if ( obj == null ) return false ;
		if ( this.getClass() != obj.getClass() ) return false ; 
		TurnosDeTrabajoEntityKey other = (TurnosDeTrabajoEntityKey) obj; 
		//--- Attribute idturnosDeTrabajo
		if ( idturnosDeTrabajo == null ) { 
			if ( other.idturnosDeTrabajo != null ) 
				return false ; 
		} else if ( ! idturnosDeTrabajo.equals(other.idturnosDeTrabajo) ) 
			return false ; 
		//--- Attribute idPuestoTrabajo
		if ( idPuestoTrabajo == null ) { 
			if ( other.idPuestoTrabajo != null ) 
				return false ; 
		} else if ( ! idPuestoTrabajo.equals(other.idPuestoTrabajo) ) 
			return false ; 
		return true; 
	} 


    //----------------------------------------------------------------------
    // hashCode METHOD
    //----------------------------------------------------------------------
	public int hashCode() { 
		final int prime = 31; 
		int result = 1; 
		
		//--- Attribute idturnosDeTrabajo
		result = prime * result + ((idturnosDeTrabajo == null) ? 0 : idturnosDeTrabajo.hashCode() ) ; 
		//--- Attribute idPuestoTrabajo
		result = prime * result + ((idPuestoTrabajo == null) ? 0 : idPuestoTrabajo.hashCode() ) ; 
		
		return result; 
	} 


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() {
		StringBuffer sb = new StringBuffer(); 
		sb.append(idturnosDeTrabajo); 
		sb.append("|"); 
		sb.append(idPuestoTrabajo); 
        return sb.toString();
    }
}
