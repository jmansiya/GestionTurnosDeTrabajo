/*
 * Created on 28 oct 2015 ( Time 21:40:10 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.business.service.mapping;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.sun.resorts.holidays.model.Planillas;
import org.sun.resorts.holidays.model.jpa.PlanillasEntity;
import org.sun.resorts.holidays.model.jpa.DetallePlanillaEntity;
import org.sun.resorts.holidays.model.jpa.PuestoDeTrabajoEntity;
import org.sun.resorts.holidays.model.jpa.VolumenTrabajoEspecialEntity;
import org.sun.resorts.holidays.model.jpa.EstadosEntity;
import org.sun.resorts.holidays.model.jpa.TipoFechaEntity;
import org.sun.resorts.holidays.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class PlanillasServiceMapperTest {

	private PlanillasServiceMapper planillasServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		planillasServiceMapper = new PlanillasServiceMapper();
		planillasServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'PlanillasEntity' to 'Planillas'
	 * @param planillasEntity
	 */
	@Test
	public void testMapPlanillasEntityToPlanillas() {
		// Given
		PlanillasEntity planillasEntity = new PlanillasEntity();
		planillasEntity.setFecha(mockValues.nextDate());
		planillasEntity.setObservaciones(mockValues.nextString(50));
		planillasEntity.setDetallePlanilla(new DetallePlanillaEntity());
		planillasEntity.getDetallePlanilla().setIddetallePlanilla(mockValues.nextInteger());
		planillasEntity.setPuestoDeTrabajo(new PuestoDeTrabajoEntity());
		planillasEntity.getPuestoDeTrabajo().setIdpuestoDeTrabajo(mockValues.nextInteger());
		planillasEntity.setVolumenTrabajoEspecial(new VolumenTrabajoEspecialEntity());
		planillasEntity.getVolumenTrabajoEspecial().setIdvolumen(mockValues.nextInteger());
		planillasEntity.setEstados(new EstadosEntity());
		planillasEntity.getEstados().setIdestados(mockValues.nextInteger());
		planillasEntity.setTipoFecha(new TipoFechaEntity());
		planillasEntity.getTipoFecha().setIdtipoFecha(mockValues.nextInteger());
		
		// When
		Planillas planillas = planillasServiceMapper.mapPlanillasEntityToPlanillas(planillasEntity);
		
		// Then
		assertEquals(planillasEntity.getFecha(), planillas.getFecha());
		assertEquals(planillasEntity.getObservaciones(), planillas.getObservaciones());
		assertEquals(planillasEntity.getDetallePlanilla().getIddetallePlanilla(), planillas.getIdDetalle());
		assertEquals(planillasEntity.getPuestoDeTrabajo().getIdpuestoDeTrabajo(), planillas.getIdPuestoTrabajo());
		assertEquals(planillasEntity.getVolumenTrabajoEspecial().getIdvolumen(), planillas.getIdVolumenEspecial());
		assertEquals(planillasEntity.getEstados().getIdestados(), planillas.getIdEstado());
		assertEquals(planillasEntity.getTipoFecha().getIdtipoFecha(), planillas.getIdTipoFecha());
	}
	
	/**
	 * Test : Mapping from 'Planillas' to 'PlanillasEntity'
	 */
	@Test
	public void testMapPlanillasToPlanillasEntity() {
		// Given
		Planillas planillas = new Planillas();
		planillas.setFecha(mockValues.nextDate());
		planillas.setObservaciones(mockValues.nextString(50));
		planillas.setIdDetalle(mockValues.nextInteger());
		planillas.setIdPuestoTrabajo(mockValues.nextInteger());
		planillas.setIdVolumenEspecial(mockValues.nextInteger());
		planillas.setIdEstado(mockValues.nextInteger());
		planillas.setIdTipoFecha(mockValues.nextInteger());

		PlanillasEntity planillasEntity = new PlanillasEntity();
		
		// When
		planillasServiceMapper.mapPlanillasToPlanillasEntity(planillas, planillasEntity);
		
		// Then
		assertEquals(planillas.getFecha(), planillasEntity.getFecha());
		assertEquals(planillas.getObservaciones(), planillasEntity.getObservaciones());
		assertEquals(planillas.getIdDetalle(), planillasEntity.getDetallePlanilla().getIddetallePlanilla());
		assertEquals(planillas.getIdPuestoTrabajo(), planillasEntity.getPuestoDeTrabajo().getIdpuestoDeTrabajo());
		assertEquals(planillas.getIdVolumenEspecial(), planillasEntity.getVolumenTrabajoEspecial().getIdvolumen());
		assertEquals(planillas.getIdEstado(), planillasEntity.getEstados().getIdestados());
		assertEquals(planillas.getIdTipoFecha(), planillasEntity.getTipoFecha().getIdtipoFecha());
	}

}