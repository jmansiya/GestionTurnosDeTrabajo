/*
 * Created on 28 oct 2015 ( Time 21:40:11 )
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
import org.sun.resorts.holidays.model.PuestoDeTrabajo;
import org.sun.resorts.holidays.model.jpa.PuestoDeTrabajoEntity;
import org.sun.resorts.holidays.model.jpa.EmpleadosEntity;
import org.sun.resorts.holidays.model.jpa.CentrosDeTrabajoEntity;
import org.sun.resorts.holidays.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class PuestoDeTrabajoServiceMapperTest {

	private PuestoDeTrabajoServiceMapper puestoDeTrabajoServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		puestoDeTrabajoServiceMapper = new PuestoDeTrabajoServiceMapper();
		puestoDeTrabajoServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'PuestoDeTrabajoEntity' to 'PuestoDeTrabajo'
	 * @param puestoDeTrabajoEntity
	 */
	@Test
	public void testMapPuestoDeTrabajoEntityToPuestoDeTrabajo() {
		// Given
		PuestoDeTrabajoEntity puestoDeTrabajoEntity = new PuestoDeTrabajoEntity();
		puestoDeTrabajoEntity.setNombre(mockValues.nextString(45));
		puestoDeTrabajoEntity.setDescripcion(mockValues.nextString(85));
		puestoDeTrabajoEntity.setEmpleados(new EmpleadosEntity());
		puestoDeTrabajoEntity.getEmpleados().setIdempleados(mockValues.nextInteger());
		puestoDeTrabajoEntity.setCentrosDeTrabajo(new CentrosDeTrabajoEntity());
		puestoDeTrabajoEntity.getCentrosDeTrabajo().setIdcentrosDeTrabajo(mockValues.nextInteger());
		
		// When
		PuestoDeTrabajo puestoDeTrabajo = puestoDeTrabajoServiceMapper.mapPuestoDeTrabajoEntityToPuestoDeTrabajo(puestoDeTrabajoEntity);
		
		// Then
		assertEquals(puestoDeTrabajoEntity.getNombre(), puestoDeTrabajo.getNombre());
		assertEquals(puestoDeTrabajoEntity.getDescripcion(), puestoDeTrabajo.getDescripcion());
		assertEquals(puestoDeTrabajoEntity.getEmpleados().getIdempleados(), puestoDeTrabajo.getIdSupervisor());
		assertEquals(puestoDeTrabajoEntity.getCentrosDeTrabajo().getIdcentrosDeTrabajo(), puestoDeTrabajo.getIdCentrosTrabajo());
	}
	
	/**
	 * Test : Mapping from 'PuestoDeTrabajo' to 'PuestoDeTrabajoEntity'
	 */
	@Test
	public void testMapPuestoDeTrabajoToPuestoDeTrabajoEntity() {
		// Given
		PuestoDeTrabajo puestoDeTrabajo = new PuestoDeTrabajo();
		puestoDeTrabajo.setNombre(mockValues.nextString(45));
		puestoDeTrabajo.setDescripcion(mockValues.nextString(85));
		puestoDeTrabajo.setIdSupervisor(mockValues.nextInteger());
		puestoDeTrabajo.setIdCentrosTrabajo(mockValues.nextInteger());

		PuestoDeTrabajoEntity puestoDeTrabajoEntity = new PuestoDeTrabajoEntity();
		
		// When
		puestoDeTrabajoServiceMapper.mapPuestoDeTrabajoToPuestoDeTrabajoEntity(puestoDeTrabajo, puestoDeTrabajoEntity);
		
		// Then
		assertEquals(puestoDeTrabajo.getNombre(), puestoDeTrabajoEntity.getNombre());
		assertEquals(puestoDeTrabajo.getDescripcion(), puestoDeTrabajoEntity.getDescripcion());
		assertEquals(puestoDeTrabajo.getIdSupervisor(), puestoDeTrabajoEntity.getEmpleados().getIdempleados());
		assertEquals(puestoDeTrabajo.getIdCentrosTrabajo(), puestoDeTrabajoEntity.getCentrosDeTrabajo().getIdcentrosDeTrabajo());
	}

}