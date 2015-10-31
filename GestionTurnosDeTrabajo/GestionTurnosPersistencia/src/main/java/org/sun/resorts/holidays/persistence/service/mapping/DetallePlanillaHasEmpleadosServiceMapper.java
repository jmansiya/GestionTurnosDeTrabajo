/*
 * Created on 31 oct 2015 ( Time 10:51:33 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.persistence.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.sun.resorts.holidays.model.DetallePlanillaHasEmpleados;
import org.sun.resorts.holidays.model.jpa.DetallePlanillaHasEmpleadosEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class DetallePlanillaHasEmpleadosServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public DetallePlanillaHasEmpleadosServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'DetallePlanillaHasEmpleadosEntity' to 'DetallePlanillaHasEmpleados'
	 * @param detallePlanillaHasEmpleadosEntity
	 */
	public DetallePlanillaHasEmpleados mapDetallePlanillaHasEmpleadosEntityToDetallePlanillaHasEmpleados(DetallePlanillaHasEmpleadosEntity detallePlanillaHasEmpleadosEntity) {
		if(detallePlanillaHasEmpleadosEntity == null) {
			return null;
		}

		//--- Generic mapping 
		DetallePlanillaHasEmpleados detallePlanillaHasEmpleados = map(detallePlanillaHasEmpleadosEntity, DetallePlanillaHasEmpleados.class);

		return detallePlanillaHasEmpleados;
	}
	
	/**
	 * Mapping from 'DetallePlanillaHasEmpleados' to 'DetallePlanillaHasEmpleadosEntity'
	 * @param detallePlanillaHasEmpleados
	 * @param detallePlanillaHasEmpleadosEntity
	 */
	public void mapDetallePlanillaHasEmpleadosToDetallePlanillaHasEmpleadosEntity(DetallePlanillaHasEmpleados detallePlanillaHasEmpleados, DetallePlanillaHasEmpleadosEntity detallePlanillaHasEmpleadosEntity) {
		if(detallePlanillaHasEmpleados == null) {
			return;
		}

		//--- Generic mapping 
		map(detallePlanillaHasEmpleados, detallePlanillaHasEmpleadosEntity);

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