/*
 * Created on 31 oct 2015 ( Time 10:51:36 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.persistence.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.sun.resorts.holidays.model.VolumenTrabajoEspecial;
import org.sun.resorts.holidays.model.jpa.VolumenTrabajoEspecialEntity;
import org.sun.resorts.holidays.model.jpa.PuestoDeTrabajoEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class VolumenTrabajoEspecialServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public VolumenTrabajoEspecialServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'VolumenTrabajoEspecialEntity' to 'VolumenTrabajoEspecial'
	 * @param volumenTrabajoEspecialEntity
	 */
	public VolumenTrabajoEspecial mapVolumenTrabajoEspecialEntityToVolumenTrabajoEspecial(VolumenTrabajoEspecialEntity volumenTrabajoEspecialEntity) {
		if(volumenTrabajoEspecialEntity == null) {
			return null;
		}

		//--- Generic mapping 
		VolumenTrabajoEspecial volumenTrabajoEspecial = map(volumenTrabajoEspecialEntity, VolumenTrabajoEspecial.class);

		//--- Link mapping ( link to PuestoDeTrabajo )
		if(volumenTrabajoEspecialEntity.getPuestoDeTrabajo() != null) {
			volumenTrabajoEspecial.setIdPuestoTrabajo(volumenTrabajoEspecialEntity.getPuestoDeTrabajo().getIdpuestoDeTrabajo());
		}
		return volumenTrabajoEspecial;
	}
	
	/**
	 * Mapping from 'VolumenTrabajoEspecial' to 'VolumenTrabajoEspecialEntity'
	 * @param volumenTrabajoEspecial
	 * @param volumenTrabajoEspecialEntity
	 */
	public void mapVolumenTrabajoEspecialToVolumenTrabajoEspecialEntity(VolumenTrabajoEspecial volumenTrabajoEspecial, VolumenTrabajoEspecialEntity volumenTrabajoEspecialEntity) {
		if(volumenTrabajoEspecial == null) {
			return;
		}

		//--- Generic mapping 
		map(volumenTrabajoEspecial, volumenTrabajoEspecialEntity);

		//--- Link mapping ( link : volumenTrabajoEspecial )
		if( hasLinkToPuestoDeTrabajo(volumenTrabajoEspecial) ) {
			PuestoDeTrabajoEntity puestoDeTrabajo1 = new PuestoDeTrabajoEntity();
			puestoDeTrabajo1.setIdpuestoDeTrabajo( volumenTrabajoEspecial.getIdPuestoTrabajo() );
			volumenTrabajoEspecialEntity.setPuestoDeTrabajo( puestoDeTrabajo1 );
		} else {
			volumenTrabajoEspecialEntity.setPuestoDeTrabajo( null );
		}

	}
	
	/**
	 * Verify that PuestoDeTrabajo id is valid.
	 * @param PuestoDeTrabajo PuestoDeTrabajo
	 * @return boolean
	 */
	private boolean hasLinkToPuestoDeTrabajo(VolumenTrabajoEspecial volumenTrabajoEspecial) {
		if(volumenTrabajoEspecial.getIdPuestoTrabajo() != null) {
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