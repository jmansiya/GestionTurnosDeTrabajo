/*
 * Created on 31 oct 2015 ( Time 10:51:34 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.persistence.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.sun.resorts.holidays.model.Direccion;
import org.sun.resorts.holidays.model.jpa.DireccionEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class DireccionServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public DireccionServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'DireccionEntity' to 'Direccion'
	 * @param direccionEntity
	 */
	public Direccion mapDireccionEntityToDireccion(DireccionEntity direccionEntity) {
		if(direccionEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Direccion direccion = map(direccionEntity, Direccion.class);

		return direccion;
	}
	
	/**
	 * Mapping from 'Direccion' to 'DireccionEntity'
	 * @param direccion
	 * @param direccionEntity
	 */
	public void mapDireccionToDireccionEntity(Direccion direccion, DireccionEntity direccionEntity) {
		if(direccion == null) {
			return;
		}

		//--- Generic mapping 
		map(direccion, direccionEntity);

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