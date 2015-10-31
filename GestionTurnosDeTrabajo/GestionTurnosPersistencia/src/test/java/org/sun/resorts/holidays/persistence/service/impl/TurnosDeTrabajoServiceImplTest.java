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

import org.sun.resorts.holidays.model.TurnosDeTrabajo;
import org.sun.resorts.holidays.model.jpa.TurnosDeTrabajoEntity;
import java.util.List;
import org.sun.resorts.holidays.persistence.service.mapping.TurnosDeTrabajoServiceMapper;
import org.sun.resorts.holidays.data.repository.jpa.TurnosDeTrabajoJpaRepository;
import org.sun.resorts.holidays.test.TurnosDeTrabajoFactoryForTest;
import org.sun.resorts.holidays.test.TurnosDeTrabajoEntityFactoryForTest;
import org.sun.resorts.holidays.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of TurnosDeTrabajoService
 */
@RunWith(MockitoJUnitRunner.class)
public class TurnosDeTrabajoServiceImplTest {

	@InjectMocks
	private TurnosDeTrabajoServiceImpl turnosDeTrabajoService;
	@Mock
	private TurnosDeTrabajoJpaRepository turnosDeTrabajoJpaRepository;
	@Mock
	private TurnosDeTrabajoServiceMapper turnosDeTrabajoServiceMapper;
	
	private TurnosDeTrabajoFactoryForTest turnosDeTrabajoFactoryForTest = new TurnosDeTrabajoFactoryForTest();

	private TurnosDeTrabajoEntityFactoryForTest turnosDeTrabajoEntityFactoryForTest = new TurnosDeTrabajoEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer idturnosDeTrabajo = mockValues.nextInteger();
		
		TurnosDeTrabajoEntity turnosDeTrabajoEntity = turnosDeTrabajoJpaRepository.findOne(idturnosDeTrabajo);
		
		TurnosDeTrabajo turnosDeTrabajo = turnosDeTrabajoFactoryForTest.newTurnosDeTrabajo();
		when(turnosDeTrabajoServiceMapper.mapTurnosDeTrabajoEntityToTurnosDeTrabajo(turnosDeTrabajoEntity)).thenReturn(turnosDeTrabajo);

		// When
		TurnosDeTrabajo turnosDeTrabajoFound = turnosDeTrabajoService.findById(idturnosDeTrabajo);

		// Then
		assertEquals(turnosDeTrabajo.getIdturnosDeTrabajo(),turnosDeTrabajoFound.getIdturnosDeTrabajo());
	}

	@Test
	public void findAll() {
		// Given
		List<TurnosDeTrabajoEntity> turnosDeTrabajoEntitys = new ArrayList<TurnosDeTrabajoEntity>();
		TurnosDeTrabajoEntity turnosDeTrabajoEntity1 = turnosDeTrabajoEntityFactoryForTest.newTurnosDeTrabajoEntity();
		turnosDeTrabajoEntitys.add(turnosDeTrabajoEntity1);
		TurnosDeTrabajoEntity turnosDeTrabajoEntity2 = turnosDeTrabajoEntityFactoryForTest.newTurnosDeTrabajoEntity();
		turnosDeTrabajoEntitys.add(turnosDeTrabajoEntity2);
		when(turnosDeTrabajoJpaRepository.findAll()).thenReturn(turnosDeTrabajoEntitys);
		
		TurnosDeTrabajo turnosDeTrabajo1 = turnosDeTrabajoFactoryForTest.newTurnosDeTrabajo();
		when(turnosDeTrabajoServiceMapper.mapTurnosDeTrabajoEntityToTurnosDeTrabajo(turnosDeTrabajoEntity1)).thenReturn(turnosDeTrabajo1);
		TurnosDeTrabajo turnosDeTrabajo2 = turnosDeTrabajoFactoryForTest.newTurnosDeTrabajo();
		when(turnosDeTrabajoServiceMapper.mapTurnosDeTrabajoEntityToTurnosDeTrabajo(turnosDeTrabajoEntity2)).thenReturn(turnosDeTrabajo2);

		// When
		List<TurnosDeTrabajo> turnosDeTrabajosFounds = turnosDeTrabajoService.findAll();

		// Then
		assertTrue(turnosDeTrabajo1 == turnosDeTrabajosFounds.get(0));
		assertTrue(turnosDeTrabajo2 == turnosDeTrabajosFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		TurnosDeTrabajo turnosDeTrabajo = turnosDeTrabajoFactoryForTest.newTurnosDeTrabajo();

		TurnosDeTrabajoEntity turnosDeTrabajoEntity = turnosDeTrabajoEntityFactoryForTest.newTurnosDeTrabajoEntity();
		when(turnosDeTrabajoJpaRepository.findOne(turnosDeTrabajo.getIdturnosDeTrabajo())).thenReturn(null);
		
		turnosDeTrabajoEntity = new TurnosDeTrabajoEntity();
		turnosDeTrabajoServiceMapper.mapTurnosDeTrabajoToTurnosDeTrabajoEntity(turnosDeTrabajo, turnosDeTrabajoEntity);
		TurnosDeTrabajoEntity turnosDeTrabajoEntitySaved = turnosDeTrabajoJpaRepository.save(turnosDeTrabajoEntity);
		
		TurnosDeTrabajo turnosDeTrabajoSaved = turnosDeTrabajoFactoryForTest.newTurnosDeTrabajo();
		when(turnosDeTrabajoServiceMapper.mapTurnosDeTrabajoEntityToTurnosDeTrabajo(turnosDeTrabajoEntitySaved)).thenReturn(turnosDeTrabajoSaved);

		// When
		TurnosDeTrabajo turnosDeTrabajoResult = turnosDeTrabajoService.create(turnosDeTrabajo);

		// Then
		assertTrue(turnosDeTrabajoResult == turnosDeTrabajoSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		TurnosDeTrabajo turnosDeTrabajo = turnosDeTrabajoFactoryForTest.newTurnosDeTrabajo();

		TurnosDeTrabajoEntity turnosDeTrabajoEntity = turnosDeTrabajoEntityFactoryForTest.newTurnosDeTrabajoEntity();
		when(turnosDeTrabajoJpaRepository.findOne(turnosDeTrabajo.getIdturnosDeTrabajo())).thenReturn(turnosDeTrabajoEntity);

		// When
		Exception exception = null;
		try {
			turnosDeTrabajoService.create(turnosDeTrabajo);
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
		TurnosDeTrabajo turnosDeTrabajo = turnosDeTrabajoFactoryForTest.newTurnosDeTrabajo();

		TurnosDeTrabajoEntity turnosDeTrabajoEntity = turnosDeTrabajoEntityFactoryForTest.newTurnosDeTrabajoEntity();
		when(turnosDeTrabajoJpaRepository.findOne(turnosDeTrabajo.getIdturnosDeTrabajo())).thenReturn(turnosDeTrabajoEntity);
		
		TurnosDeTrabajoEntity turnosDeTrabajoEntitySaved = turnosDeTrabajoEntityFactoryForTest.newTurnosDeTrabajoEntity();
		when(turnosDeTrabajoJpaRepository.save(turnosDeTrabajoEntity)).thenReturn(turnosDeTrabajoEntitySaved);
		
		TurnosDeTrabajo turnosDeTrabajoSaved = turnosDeTrabajoFactoryForTest.newTurnosDeTrabajo();
		when(turnosDeTrabajoServiceMapper.mapTurnosDeTrabajoEntityToTurnosDeTrabajo(turnosDeTrabajoEntitySaved)).thenReturn(turnosDeTrabajoSaved);

		// When
		TurnosDeTrabajo turnosDeTrabajoResult = turnosDeTrabajoService.update(turnosDeTrabajo);

		// Then
		verify(turnosDeTrabajoServiceMapper).mapTurnosDeTrabajoToTurnosDeTrabajoEntity(turnosDeTrabajo, turnosDeTrabajoEntity);
		assertTrue(turnosDeTrabajoResult == turnosDeTrabajoSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer idturnosDeTrabajo = mockValues.nextInteger();

		// When
		turnosDeTrabajoService.delete(idturnosDeTrabajo);

		// Then
		verify(turnosDeTrabajoJpaRepository).delete(idturnosDeTrabajo);
		
	}

}
