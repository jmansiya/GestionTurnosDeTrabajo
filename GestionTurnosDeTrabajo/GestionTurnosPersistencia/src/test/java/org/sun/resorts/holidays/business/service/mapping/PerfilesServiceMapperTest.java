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
import org.sun.resorts.holidays.model.Perfiles;
import org.sun.resorts.holidays.model.jpa.PerfilesEntity;
import org.sun.resorts.holidays.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class PerfilesServiceMapperTest {

	private PerfilesServiceMapper perfilesServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		perfilesServiceMapper = new PerfilesServiceMapper();
		perfilesServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'PerfilesEntity' to 'Perfiles'
	 * @param perfilesEntity
	 */
	@Test
	public void testMapPerfilesEntityToPerfiles() {
		// Given
		PerfilesEntity perfilesEntity = new PerfilesEntity();
		perfilesEntity.setDescripcion(mockValues.nextString(45));
		
		// When
		Perfiles perfiles = perfilesServiceMapper.mapPerfilesEntityToPerfiles(perfilesEntity);
		
		// Then
		assertEquals(perfilesEntity.getDescripcion(), perfiles.getDescripcion());
	}
	
	/**
	 * Test : Mapping from 'Perfiles' to 'PerfilesEntity'
	 */
	@Test
	public void testMapPerfilesToPerfilesEntity() {
		// Given
		Perfiles perfiles = new Perfiles();
		perfiles.setDescripcion(mockValues.nextString(45));

		PerfilesEntity perfilesEntity = new PerfilesEntity();
		
		// When
		perfilesServiceMapper.mapPerfilesToPerfilesEntity(perfiles, perfilesEntity);
		
		// Then
		assertEquals(perfiles.getDescripcion(), perfilesEntity.getDescripcion());
	}

}