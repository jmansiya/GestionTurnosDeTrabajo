/*
 * Created on 31 oct 2015 ( Time 10:51:33 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.persistence.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.sun.resorts.holidays.model.CentrosDeTrabajo;
import org.sun.resorts.holidays.model.jpa.CentrosDeTrabajoEntity;
import org.sun.resorts.holidays.model.jpa.DireccionEntity;
import org.sun.resorts.holidays.model.jpa.EmpleadosEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class CentrosDeTrabajoServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public CentrosDeTrabajoServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'CentrosDeTrabajoEntity' to 'CentrosDeTrabajo'
	 * @param centrosDeTrabajoEntity
	 */
	public CentrosDeTrabajo mapCentrosDeTrabajoEntityToCentrosDeTrabajo(CentrosDeTrabajoEntity centrosDeTrabajoEntity) {
		if(centrosDeTrabajoEntity == null) {
			return null;
		}

		//--- Generic mapping 
		CentrosDeTrabajo centrosDeTrabajo = map(centrosDeTrabajoEntity, CentrosDeTrabajo.class);

		//--- Link mapping ( link to Direccion )
		if(centrosDeTrabajoEntity.getDireccion() != null) {
			centrosDeTrabajo.setIdDireccion(centrosDeTrabajoEntity.getDireccion().getIddireccion());
		}
		//--- Link mapping ( link to Empleados )
		if(centrosDeTrabajoEntity.getAdministrador() != null) {
			centrosDeTrabajo.setIdAdministrador(centrosDeTrabajoEntity.getAdministrador().getIdempleados());
		}
		return centrosDeTrabajo;
	}
	
	/**
	 * Mapping from 'CentrosDeTrabajo' to 'CentrosDeTrabajoEntity'
	 * @param centrosDeTrabajo
	 * @param centrosDeTrabajoEntity
	 */
	public void mapCentrosDeTrabajoToCentrosDeTrabajoEntity(CentrosDeTrabajo centrosDeTrabajo, CentrosDeTrabajoEntity centrosDeTrabajoEntity) {
		if(centrosDeTrabajo == null) {
			return;
		}

		//--- Generic mapping 
		map(centrosDeTrabajo, centrosDeTrabajoEntity);

		//--- Link mapping ( link : centrosDeTrabajo )
		if( hasLinkToDireccion(centrosDeTrabajo) ) {
			DireccionEntity direccion1 = new DireccionEntity();
			direccion1.setIddireccion( centrosDeTrabajo.getIdDireccion() );
			centrosDeTrabajoEntity.setDireccion( direccion1 );
		} else {
			centrosDeTrabajoEntity.setDireccion( null );
		}

		//--- Link mapping ( link : centrosDeTrabajo )
		if( hasLinkToEmpleados(centrosDeTrabajo) ) {
			EmpleadosEntity empleados2 = new EmpleadosEntity();
			empleados2.setIdempleados( centrosDeTrabajo.getIdAdministrador() );
			centrosDeTrabajoEntity.setAdministrador( empleados2 );
		} else {
			centrosDeTrabajoEntity.setAdministrador( null );
		}

	}
	
	/**
	 * Verify that Direccion id is valid.
	 * @param Direccion Direccion
	 * @return boolean
	 */
	private boolean hasLinkToDireccion(CentrosDeTrabajo centrosDeTrabajo) {
		if(centrosDeTrabajo.getIdDireccion() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that Empleados id is valid.
	 * @param Empleados Empleados
	 * @return boolean
	 */
	private boolean hasLinkToEmpleados(CentrosDeTrabajo centrosDeTrabajo) {
		if(centrosDeTrabajo.getIdAdministrador() != null) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}