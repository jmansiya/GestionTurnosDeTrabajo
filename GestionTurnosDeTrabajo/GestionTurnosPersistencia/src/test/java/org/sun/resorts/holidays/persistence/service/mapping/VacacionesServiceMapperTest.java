/*
 * Created on 31 oct 2015 ( Time 10:51:35 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.persistence.service.mapping;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.sun.resorts.holidays.model.Vacaciones;
import org.sun.resorts.holidays.model.jpa.VacacionesEntity;
import org.sun.resorts.holidays.model.jpa.EstadosEntity;
import org.sun.resorts.holidays.model.jpa.EmpleadosEntity;
import org.sun.resorts.holidays.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class VacacionesServiceMapperTest {

	private VacacionesServiceMapper vacacionesServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		vacacionesServiceMapper = new VacacionesServiceMapper();
		vacacionesServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'VacacionesEntity' to 'Vacaciones'
	 * @param vacacionesEntity
	 */
	@Test
	public void testMapVacacionesEntityToVacaciones() {
		// Given
		VacacionesEntity vacacionesEntity = new VacacionesEntity();
		vacacionesEntity.setObservaciones(mockValues.nextString(45));
		vacacionesEntity.setFechaVacaciones(mockValues.nextDate());
		vacacionesEntity.setFestivoPendiente(mockValues.nextBoolean());
		vacacionesEntity.setEstados(new EstadosEntity());
		vacacionesEntity.getEstados().setIdestados(mockValues.nextInteger());
		vacacionesEntity.setEmpleados(new EmpleadosEntity());
		vacacionesEntity.getEmpleados().setIdempleados(mockValues.nextInteger());
		
		// When
		Vacaciones vacaciones = vacacionesServiceMapper.mapVacacionesEntityToVacaciones(vacacionesEntity);
		
		// Then
		assertEquals(vacacionesEntity.getObservaciones(), vacaciones.getObservaciones());
		assertEquals(vacacionesEntity.getFechaVacaciones(), vacaciones.getFechaVacaciones());
		assertEquals(vacacionesEntity.getFestivoPendiente(), vacaciones.getFestivoPendiente());
		assertEquals(vacacionesEntity.getEstados().getIdestados(), vacaciones.getEstado());
		assertEquals(vacacionesEntity.getEmpleados().getIdempleados(), vacaciones.getEmpleadosIdempleados());
	}
	
	/**
	 * Test : Mapping from 'Vacaciones' to 'VacacionesEntity'
	 */
	@Test
	public void testMapVacacionesToVacacionesEntity() {
		// Given
		Vacaciones vacaciones = new Vacaciones();
		vacaciones.setObservaciones(mockValues.nextString(45));
		vacaciones.setFechaVacaciones(mockValues.nextDate());
		vacaciones.setFestivoPendiente(mockValues.nextBoolean());
		vacaciones.setEstado(mockValues.nextInteger());
		vacaciones.setEmpleadosIdempleados(mockValues.nextInteger());

		VacacionesEntity vacacionesEntity = new VacacionesEntity();
		
		// When
		vacacionesServiceMapper.mapVacacionesToVacacionesEntity(vacaciones, vacacionesEntity);
		
		// Then
		assertEquals(vacaciones.getObservaciones(), vacacionesEntity.getObservaciones());
		assertEquals(vacaciones.getFechaVacaciones(), vacacionesEntity.getFechaVacaciones());
		assertEquals(vacaciones.getFestivoPendiente(), vacacionesEntity.getFestivoPendiente());
		assertEquals(vacaciones.getEstado(), vacacionesEntity.getEstados().getIdestados());
		assertEquals(vacaciones.getEmpleadosIdempleados(), vacacionesEntity.getEmpleados().getIdempleados());
	}

}