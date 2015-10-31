/*
 * Created on 31 oct 2015 ( Time 10:51:35 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.persistence.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.sun.resorts.holidays.model.Planillas;
import org.sun.resorts.holidays.model.jpa.PlanillasEntity;
import org.sun.resorts.holidays.model.jpa.PuestoDeTrabajoEntity;
import org.sun.resorts.holidays.model.jpa.EstadosEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class PlanillasServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public PlanillasServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'PlanillasEntity' to 'Planillas'
	 * @param planillasEntity
	 */
	public Planillas mapPlanillasEntityToPlanillas(PlanillasEntity planillasEntity) {
		if(planillasEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Planillas planillas = map(planillasEntity, Planillas.class);

		//--- Link mapping ( link to PuestoDeTrabajo )
		if(planillasEntity.getPuestoDeTrabajo() != null) {
			planillas.setIdPuestoTrabajo(planillasEntity.getPuestoDeTrabajo().getIdpuestoDeTrabajo());
		}
		//--- Link mapping ( link to Estados )
		if(planillasEntity.getEstados() != null) {
			planillas.setIdEstado(planillasEntity.getEstados().getIdestados());
		}
		return planillas;
	}
	
	/**
	 * Mapping from 'Planillas' to 'PlanillasEntity'
	 * @param planillas
	 * @param planillasEntity
	 */
	public void mapPlanillasToPlanillasEntity(Planillas planillas, PlanillasEntity planillasEntity) {
		if(planillas == null) {
			return;
		}

		//--- Generic mapping 
		map(planillas, planillasEntity);

		//--- Link mapping ( link : planillas )
		if( hasLinkToPuestoDeTrabajo(planillas) ) {
			PuestoDeTrabajoEntity puestoDeTrabajo1 = new PuestoDeTrabajoEntity();
			puestoDeTrabajo1.setIdpuestoDeTrabajo( planillas.getIdPuestoTrabajo() );
			planillasEntity.setPuestoDeTrabajo( puestoDeTrabajo1 );
		} else {
			planillasEntity.setPuestoDeTrabajo( null );
		}

		//--- Link mapping ( link : planillas )
		if( hasLinkToEstados(planillas) ) {
			EstadosEntity estados2 = new EstadosEntity();
			estados2.setIdestados( planillas.getIdEstado() );
			planillasEntity.setEstados( estados2 );
		} else {
			planillasEntity.setEstados( null );
		}

	}
	
	/**
	 * Verify that PuestoDeTrabajo id is valid.
	 * @param PuestoDeTrabajo PuestoDeTrabajo
	 * @return boolean
	 */
	private boolean hasLinkToPuestoDeTrabajo(Planillas planillas) {
		if(planillas.getIdPuestoTrabajo() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that Estados id is valid.
	 * @param Estados Estados
	 * @return boolean
	 */
	private boolean hasLinkToEstados(Planillas planillas) {
		if(planillas.getIdEstado() != null) {
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