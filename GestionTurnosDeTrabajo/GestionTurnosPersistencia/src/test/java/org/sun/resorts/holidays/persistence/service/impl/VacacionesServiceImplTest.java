/*
 * Created on 31 oct 2015 ( Time 10:51:35 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.persistence.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.sun.resorts.holidays.model.Vacaciones;
import org.sun.resorts.holidays.model.jpa.VacacionesEntity;
import java.util.Date;
import org.sun.resorts.holidays.persistence.service.mapping.VacacionesServiceMapper;
import org.sun.resorts.holidays.data.repository.jpa.VacacionesJpaRepository;
import org.sun.resorts.holidays.test.VacacionesFactoryForTest;
import org.sun.resorts.holidays.test.VacacionesEntityFactoryForTest;
import org.sun.resorts.holidays.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of VacacionesService
 */
@RunWith(MockitoJUnitRunner.class)
public class VacacionesServiceImplTest {

	@InjectMocks
	private VacacionesServiceImpl vacacionesService;
	@Mock
	private VacacionesJpaRepository vacacionesJpaRepository;
	@Mock
	private VacacionesServiceMapper vacacionesServiceMapper;
	
	private VacacionesFactoryForTest vacacionesFactoryForTest = new VacacionesFactoryForTest();

	private VacacionesEntityFactoryForTest vacacionesEntityFactoryForTest = new VacacionesEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer idvacaciones = mockValues.nextInteger();
		
		VacacionesEntity vacacionesEntity = vacacionesJpaRepository.findOne(idvacaciones);
		
		Vacaciones vacaciones = vacacionesFactoryForTest.newVacaciones();
		when(vacacionesServiceMapper.mapVacacionesEntityToVacaciones(vacacionesEntity)).thenReturn(vacaciones);

		// When
		Vacaciones vacacionesFound = vacacionesService.findById(idvacaciones);

		// Then
		assertEquals(vacaciones.getIdvacaciones(),vacacionesFound.getIdvacaciones());
	}

	@Test
	public void findAll() {
		// Given
		List<VacacionesEntity> vacacionesEntitys = new ArrayList<VacacionesEntity>();
		VacacionesEntity vacacionesEntity1 = vacacionesEntityFactoryForTest.newVacacionesEntity();
		vacacionesEntitys.add(vacacionesEntity1);
		VacacionesEntity vacacionesEntity2 = vacacionesEntityFactoryForTest.newVacacionesEntity();
		vacacionesEntitys.add(vacacionesEntity2);
		when(vacacionesJpaRepository.findAll()).thenReturn(vacacionesEntitys);
		
		Vacaciones vacaciones1 = vacacionesFactoryForTest.newVacaciones();
		when(vacacionesServiceMapper.mapVacacionesEntityToVacaciones(vacacionesEntity1)).thenReturn(vacaciones1);
		Vacaciones vacaciones2 = vacacionesFactoryForTest.newVacaciones();
		when(vacacionesServiceMapper.mapVacacionesEntityToVacaciones(vacacionesEntity2)).thenReturn(vacaciones2);

		// When
		List<Vacaciones> vacacionessFounds = vacacionesService.findAll();

		// Then
		assertTrue(vacaciones1 == vacacionessFounds.get(0));
		assertTrue(vacaciones2 == vacacionessFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		Vacaciones vacaciones = vacacionesFactoryForTest.newVacaciones();

		VacacionesEntity vacacionesEntity = vacacionesEntityFactoryForTest.newVacacionesEntity();
		when(vacacionesJpaRepository.findOne(vacaciones.getIdvacaciones())).thenReturn(null);
		
		vacacionesEntity = new VacacionesEntity();
		vacacionesServiceMapper.mapVacacionesToVacacionesEntity(vacaciones, vacacionesEntity);
		VacacionesEntity vacacionesEntitySaved = vacacionesJpaRepository.save(vacacionesEntity);
		
		Vacaciones vacacionesSaved = vacacionesFactoryForTest.newVacaciones();
		when(vacacionesServiceMapper.mapVacacionesEntityToVacaciones(vacacionesEntitySaved)).thenReturn(vacacionesSaved);

		// When
		Vacaciones vacacionesResult = vacacionesService.create(vacaciones);

		// Then
		assertTrue(vacacionesResult == vacacionesSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		Vacaciones vacaciones = vacacionesFactoryForTest.newVacaciones();

		VacacionesEntity vacacionesEntity = vacacionesEntityFactoryForTest.newVacacionesEntity();
		when(vacacionesJpaRepository.findOne(vacaciones.getIdvacaciones())).thenReturn(vacacionesEntity);

		// When
		Exception exception = null;
		try {
			vacacionesService.create(vacaciones);
		} catch(Exception e) {
			exception = e;
		}

		// Then
		assertTrue(exception instanceof IllegalStateException);
		assertEquals("already.exists", exception.getMessage());
	}

	@Test
	public void update() {
		// Given
		Vacaciones vacaciones = vacacionesFactoryForTest.newVacaciones();

		VacacionesEntity vacacionesEntity = vacacionesEntityFactoryForTest.newVacacionesEntity();
		when(vacacionesJpaRepository.findOne(vacaciones.getIdvacaciones())).thenReturn(vacacionesEntity);
		
		VacacionesEntity vacacionesEntitySaved = vacacionesEntityFactoryForTest.newVacacionesEntity();
		when(vacacionesJpaRepository.save(vacacionesEntity)).thenReturn(vacacionesEntitySaved);
		
		Vacaciones vacacionesSaved = vacacionesFactoryForTest.newVacaciones();
		when(vacacionesServiceMapper.mapVacacionesEntityToVacaciones(vacacionesEntitySaved)).thenReturn(vacacionesSaved);

		// When
		Vacaciones vacacionesResult = vacacionesService.update(vacaciones);

		// Then
		verify(vacacionesServiceMapper).mapVacacionesToVacacionesEntity(vacaciones, vacacionesEntity);
		assertTrue(vacacionesResult == vacacionesSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer idvacaciones = mockValues.nextInteger();

		// When
		vacacionesService.delete(idvacaciones);

		// Then
		verify(vacacionesJpaRepository).delete(idvacaciones);
		
	}

}
