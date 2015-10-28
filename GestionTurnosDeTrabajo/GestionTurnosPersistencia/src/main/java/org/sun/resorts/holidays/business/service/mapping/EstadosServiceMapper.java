/*
 * Created on 28 oct 2015 ( Time 21:40:10 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.sun.resorts.holidays.model.Estados;
import org.sun.resorts.holidays.model.jpa.EstadosEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class EstadosServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public EstadosServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'EstadosEntity' to 'Estados'
	 * @param estadosEntity
	 */
	public Estados mapEstadosEntityToEstados(EstadosEntity estadosEntity) {
		if(estadosEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Estados estados = map(estadosEntity, Estados.class);

		return estados;
	}
	
	/**
	 * Mapping from 'Estados' to 'EstadosEntity'
	 * @param estados
	 * @param estadosEntity
	 */
	public void mapEstadosToEstadosEntity(Estados estados, EstadosEntity estadosEntity) {
		if(estados == null) {
			return;
		}

		//--- Generic mapping 
		map(estados, estadosEntity);

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