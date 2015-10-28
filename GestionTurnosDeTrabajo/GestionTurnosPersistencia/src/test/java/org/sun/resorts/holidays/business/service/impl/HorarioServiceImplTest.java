/*
 * Created on 28 oct 2015 ( Time 21:40:10 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.sun.resorts.holidays.model.Horario;
import org.sun.resorts.holidays.model.jpa.HorarioEntity;
import java.util.Date;
import org.sun.resorts.holidays.business.service.mapping.HorarioServiceMapper;
import org.sun.resorts.holidays.data.repository.jpa.HorarioJpaRepository;
import org.sun.resorts.holidays.test.HorarioFactoryForTest;
import org.sun.resorts.holidays.test.HorarioEntityFactoryForTest;
import org.sun.resorts.holidays.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of HorarioService
 */
@RunWith(MockitoJUnitRunner.class)
public class HorarioServiceImplTest {

	@InjectMocks
	private HorarioServiceImpl horarioService;
	@Mock
	private HorarioJpaRepository horarioJpaRepository;
	@Mock
	private HorarioServiceMapper horarioServiceMapper;
	
	private HorarioFactoryForTest horarioFactoryForTest = new HorarioFactoryForTest();

	private HorarioEntityFactoryForTest horarioEntityFactoryForTest = new HorarioEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer idhorario = mockValues.nextInteger();
		
		HorarioEntity horarioEntity = horarioJpaRepository.findOne(idhorario);
		
		Horario horario = horarioFactoryForTest.newHorario();
		when(horarioServiceMapper.mapHorarioEntityToHorario(horarioEntity)).thenReturn(horario);

		// When
		Horario horarioFound = horarioService.findById(idhorario);

		// Then
		assertEquals(horario.getIdhorario(),horarioFound.getIdhorario());
	}

	@Test
	public void findAll() {
		// Given
		List<HorarioEntity> horarioEntitys = new ArrayList<HorarioEntity>();
		HorarioEntity horarioEntity1 = horarioEntityFactoryForTest.newHorarioEntity();
		horarioEntitys.add(horarioEntity1);
		HorarioEntity horarioEntity2 = horarioEntityFactoryForTest.newHorarioEntity();
		horarioEntitys.add(horarioEntity2);
		when(horarioJpaRepository.findAll()).thenReturn(horarioEntitys);
		
		Horario horario1 = horarioFactoryForTest.newHorario();
		when(horarioServiceMapper.mapHorarioEntityToHorario(horarioEntity1)).thenReturn(horario1);
		Horario horario2 = horarioFactoryForTest.newHorario();
		when(horarioServiceMapper.mapHorarioEntityToHorario(horarioEntity2)).thenReturn(horario2);

		// When
		List<Horario> horariosFounds = horarioService.findAll();

		// Then
		assertTrue(horario1 == horariosFounds.get(0));
		assertTrue(horario2 == horariosFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		Horario horario = horarioFactoryForTest.newHorario();

		HorarioEntity horarioEntity = horarioEntityFactoryForTest.newHorarioEntity();
		when(horarioJpaRepository.findOne(horario.getIdhorario())).thenReturn(null);
		
		horarioEntity = new HorarioEntity();
		horarioServiceMapper.mapHorarioToHorarioEntity(horario, horarioEntity);
		HorarioEntity horarioEntitySaved = horarioJpaRepository.save(horarioEntity);
		
		Horario horarioSaved = horarioFactoryForTest.newHorario();
		when(horarioServiceMapper.mapHorarioEntityToHorario(horarioEntitySaved)).thenReturn(horarioSaved);

		// When
		Horario horarioResult = horarioService.create(horario);

		// Then
		assertTrue(horarioResult == horarioSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		Horario horario = horarioFactoryForTest.newHorario();

		HorarioEntity horarioEntity = horarioEntityFactoryForTest.newHorarioEntity();
		when(horarioJpaRepository.findOne(horario.getIdhorario())).thenReturn(horarioEntity);

		// When
		Exception exception = null;
		try {
			horarioService.create(horario);
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
		Horario horario = horarioFactoryForTest.newHorario();

		HorarioEntity horarioEntity = horarioEntityFactoryForTest.newHorarioEntity();
		when(horarioJpaRepository.findOne(horario.getIdhorario())).thenReturn(horarioEntity);
		
		HorarioEntity horarioEntitySaved = horarioEntityFactoryForTest.newHorarioEntity();
		when(horarioJpaRepository.save(horarioEntity)).thenReturn(horarioEntitySaved);
		
		Horario horarioSaved = horarioFactoryForTest.newHorario();
		when(horarioServiceMapper.mapHorarioEntityToHorario(horarioEntitySaved)).thenReturn(horarioSaved);

		// When
		Horario horarioResult = horarioService.update(horario);

		// Then
		verify(horarioServiceMapper).mapHorarioToHorarioEntity(horario, horarioEntity);
		assertTrue(horarioResult == horarioSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer idhorario = mockValues.nextInteger();

		// When
		horarioService.delete(idhorario);

		// Then
		verify(horarioJpaRepository).delete(idhorario);
		
	}

}
