/*
 * Created on 31 oct 2015 ( Time 10:51:35 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.persistence.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.sun.resorts.holidays.model.TurnosDeTrabajo;
import org.sun.resorts.holidays.model.jpa.TurnosDeTrabajoEntity;
import org.sun.resorts.holidays.model.jpa.PuestoDeTrabajoEntity;
import org.sun.resorts.holidays.model.jpa.TurnosDeTrabajoEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class TurnosDeTrabajoServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public TurnosDeTrabajoServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'TurnosDeTrabajoEntity' to 'TurnosDeTrabajo'
	 * @param turnosDeTrabajoEntity
	 */
	public TurnosDeTrabajo mapTurnosDeTrabajoEntityToTurnosDeTrabajo(TurnosDeTrabajoEntity turnosDeTrabajoEntity) {
		if(turnosDeTrabajoEntity == null) {
			return null;
		}

		//--- Generic mapping 
		TurnosDeTrabajo turnosDeTrabajo = map(turnosDeTrabajoEntity, TurnosDeTrabajo.class);

		//--- Link mapping ( link to PuestoDeTrabajo )
		if(turnosDeTrabajoEntity.getPuestoDeTrabajo() != null) {
			turnosDeTrabajo.setIdPuestoTrabajo(turnosDeTrabajoEntity.getPuestoDeTrabajo().getIdpuestoDeTrabajo());
		}
		//--- Link mapping ( link to TurnosDeTrabajo )
		if(turnosDeTrabajoEntity.getTurnosDeTrabajo() != null) {
			turnosDeTrabajo.setIdSiguienteTurno(turnosDeTrabajoEntity.getTurnosDeTrabajo().getIdturnosDeTrabajo());
		}
		return turnosDeTrabajo;
	}
	
	/**
	 * Mapping from 'TurnosDeTrabajo' to 'TurnosDeTrabajoEntity'
	 * @param turnosDeTrabajo
	 * @param turnosDeTrabajoEntity
	 */
	public void mapTurnosDeTrabajoToTurnosDeTrabajoEntity(TurnosDeTrabajo turnosDeTrabajo, TurnosDeTrabajoEntity turnosDeTrabajoEntity) {
		if(turnosDeTrabajo == null) {
			return;
		}

		//--- Generic mapping 
		map(turnosDeTrabajo, turnosDeTrabajoEntity);

		//--- Link mapping ( link : turnosDeTrabajo )
		if( hasLinkToPuestoDeTrabajo(turnosDeTrabajo) ) {
			PuestoDeTrabajoEntity puestoDeTrabajo1 = new PuestoDeTrabajoEntity();
			puestoDeTrabajo1.setIdpuestoDeTrabajo( turnosDeTrabajo.getIdPuestoTrabajo() );
			turnosDeTrabajoEntity.setPuestoDeTrabajo( puestoDeTrabajo1 );
		} else {
			turnosDeTrabajoEntity.setPuestoDeTrabajo( null );
		}

		//--- Link mapping ( link : turnosDeTrabajo )
		if( hasLinkToTurnosDeTrabajo(turnosDeTrabajo) ) {
			TurnosDeTrabajoEntity turnosDeTrabajo2 = new TurnosDeTrabajoEntity();
			turnosDeTrabajo2.setIdturnosDeTrabajo( turnosDeTrabajo.getIdSiguienteTurno() );
			turnosDeTrabajoEntity.setTurnosDeTrabajo( turnosDeTrabajo2 );
		} else {
			turnosDeTrabajoEntity.setTurnosDeTrabajo( null );
		}

	}
	
	/**
	 * Verify that PuestoDeTrabajo id is valid.
	 * @param PuestoDeTrabajo PuestoDeTrabajo
	 * @return boolean
	 */
	private boolean hasLinkToPuestoDeTrabajo(TurnosDeTrabajo turnosDeTrabajo) {
		if(turnosDeTrabajo.getIdPuestoTrabajo() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that TurnosDeTrabajo id is valid.
	 * @param TurnosDeTrabajo TurnosDeTrabajo
	 * @return boolean
	 */
	private boolean hasLinkToTurnosDeTrabajo(TurnosDeTrabajo turnosDeTrabajo) {
		if(turnosDeTrabajo.getIdSiguienteTurno() != null) {
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