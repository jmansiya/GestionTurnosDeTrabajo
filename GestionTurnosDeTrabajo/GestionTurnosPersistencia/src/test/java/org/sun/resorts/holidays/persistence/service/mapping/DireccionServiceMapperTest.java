/*
 * Created on 31 oct 2015 ( Time 10:51:34 )
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
import org.sun.resorts.holidays.model.Direccion;
import org.sun.resorts.holidays.model.jpa.DireccionEntity;
import org.sun.resorts.holidays.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class DireccionServiceMapperTest {

	private DireccionServiceMapper direccionServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		direccionServiceMapper = new DireccionServiceMapper();
		direccionServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'DireccionEntity' to 'Direccion'
	 * @param direccionEntity
	 */
	@Test
	public void testMapDireccionEntityToDireccion() {
		// Given
		DireccionEntity direccionEntity = new DireccionEntity();
		direccionEntity.setDireccion(mockValues.nextString(65));
		direccionEntity.setCodigoPostal(mockValues.nextString(5));
		direccionEntity.setLocalidad(mockValues.nextString(55));
		direccionEntity.setProvincia(mockValues.nextString(55));
		direccionEntity.setPais(mockValues.nextString(45));
		
		// When
		Direccion direccion = direccionServiceMapper.mapDireccionEntityToDireccion(direccionEntity);
		
		// Then
		assertEquals(direccionEntity.getDireccion(), direccion.getDireccion());
		assertEquals(direccionEntity.getCodigoPostal(), direccion.getCodigoPostal());
		assertEquals(direccionEntity.getLocalidad(), direccion.getLocalidad());
		assertEquals(direccionEntity.getProvincia(), direccion.getProvincia());
		assertEquals(direccionEntity.getPais(), direccion.getPais());
	}
	
	/**
	 * Test : Mapping from 'Direccion' to 'DireccionEntity'
	 */
	@Test
	public void testMapDireccionToDireccionEntity() {
		// Given
		Direccion direccion = new Direccion();
		direccion.setDireccion(mockValues.nextString(65));
		direccion.setCodigoPostal(mockValues.nextString(5));
		direccion.setLocalidad(mockValues.nextString(55));
		direccion.setProvincia(mockValues.nextString(55));
		direccion.setPais(mockValues.nextString(45));

		DireccionEntity direccionEntity = new DireccionEntity();
		
		// When
		direccionServiceMapper.mapDireccionToDireccionEntity(direccion, direccionEntity);
		
		// Then
		assertEquals(direccion.getDireccion(), direccionEntity.getDireccion());
		assertEquals(direccion.getCodigoPostal(), direccionEntity.getCodigoPostal());
		assertEquals(direccion.getLocalidad(), direccionEntity.getLocalidad());
		assertEquals(direccion.getProvincia(), direccionEntity.getProvincia());
		assertEquals(direccion.getPais(), direccionEntity.getPais());
	}

}