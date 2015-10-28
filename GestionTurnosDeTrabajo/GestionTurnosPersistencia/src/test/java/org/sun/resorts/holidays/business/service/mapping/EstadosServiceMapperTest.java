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
import org.sun.resorts.holidays.model.Estados;
import org.sun.resorts.holidays.model.jpa.EstadosEntity;
import org.sun.resorts.holidays.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class EstadosServiceMapperTest {

	private EstadosServiceMapper estadosServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		estadosServiceMapper = new EstadosServiceMapper();
		estadosServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'EstadosEntity' to 'Estados'
	 * @param estadosEntity
	 */
	@Test
	public void testMapEstadosEntityToEstados() {
		// Given
		EstadosEntity estadosEntity = new EstadosEntity();
		estadosEntity.setDescripcion(mockValues.nextString(50));
		
		// When
		Estados estados = estadosServiceMapper.mapEstadosEntityToEstados(estadosEntity);
		
		// Then
		assertEquals(estadosEntity.getDescripcion(), estados.getDescripcion());
	}
	
	/**
	 * Test : Mapping from 'Estados' to 'EstadosEntity'
	 */
	@Test
	public void testMapEstadosToEstadosEntity() {
		// Given
		Estados estados = new Estados();
		estados.setDescripcion(mockValues.nextString(50));

		EstadosEntity estadosEntity = new EstadosEntity();
		
		// When
		estadosServiceMapper.mapEstadosToEstadosEntity(estados, estadosEntity);
		
		// Then
		assertEquals(estados.getDescripcion(), estadosEntity.getDescripcion());
	}

}