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
import org.sun.resorts.holidays.model.TipoFecha;
import org.sun.resorts.holidays.model.jpa.TipoFechaEntity;
import org.sun.resorts.holidays.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class TipoFechaServiceMapperTest {

	private TipoFechaServiceMapper tipoFechaServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		tipoFechaServiceMapper = new TipoFechaServiceMapper();
		tipoFechaServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'TipoFechaEntity' to 'TipoFecha'
	 * @param tipoFechaEntity
	 */
	@Test
	public void testMapTipoFechaEntityToTipoFecha() {
		// Given
		TipoFechaEntity tipoFechaEntity = new TipoFechaEntity();
		tipoFechaEntity.setDescripcion(mockValues.nextString(45));
		
		// When
		TipoFecha tipoFecha = tipoFechaServiceMapper.mapTipoFechaEntityToTipoFecha(tipoFechaEntity);
		
		// Then
		assertEquals(tipoFechaEntity.getDescripcion(), tipoFecha.getDescripcion());
	}
	
	/**
	 * Test : Mapping from 'TipoFecha' to 'TipoFechaEntity'
	 */
	@Test
	public void testMapTipoFechaToTipoFechaEntity() {
		// Given
		TipoFecha tipoFecha = new TipoFecha();
		tipoFecha.setDescripcion(mockValues.nextString(45));

		TipoFechaEntity tipoFechaEntity = new TipoFechaEntity();
		
		// When
		tipoFechaServiceMapper.mapTipoFechaToTipoFechaEntity(tipoFecha, tipoFechaEntity);
		
		// Then
		assertEquals(tipoFecha.getDescripcion(), tipoFechaEntity.getDescripcion());
	}

}