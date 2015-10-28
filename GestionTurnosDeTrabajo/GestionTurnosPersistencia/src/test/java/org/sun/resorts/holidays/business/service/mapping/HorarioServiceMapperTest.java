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
import org.sun.resorts.holidays.model.Horario;
import org.sun.resorts.holidays.model.jpa.HorarioEntity;
import org.sun.resorts.holidays.model.jpa.PuestoDeTrabajoEntity;
import org.sun.resorts.holidays.model.jpa.TurnosDeTrabajoEntity;
import org.sun.resorts.holidays.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class HorarioServiceMapperTest {

	private HorarioServiceMapper horarioServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		horarioServiceMapper = new HorarioServiceMapper();
		horarioServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'HorarioEntity' to 'Horario'
	 * @param horarioEntity
	 */
	@Test
	public void testMapHorarioEntityToHorario() {
		// Given
		HorarioEntity horarioEntity = new HorarioEntity();
		horarioEntity.setHoraInicio(mockValues.nextDate());
		horarioEntity.setHoraFin(mockValues.nextDate());
		horarioEntity.setHoraInicioEspecial(mockValues.nextDate());
		horarioEntity.setHoraFinEspecial(mockValues.nextDate());
		horarioEntity.setPuestoDeTrabajo(new PuestoDeTrabajoEntity());
		horarioEntity.getPuestoDeTrabajo().setIdpuestoDeTrabajo(mockValues.nextInteger());
		horarioEntity.setTurnosDeTrabajo(new TurnosDeTrabajoEntity());
		horarioEntity.getTurnosDeTrabajo().setIdturnosDeTrabajo(mockValues.nextInteger());
		
		// When
		Horario horario = horarioServiceMapper.mapHorarioEntityToHorario(horarioEntity);
		
		// Then
		assertEquals(horarioEntity.getHoraInicio(), horario.getHoraInicio());
		assertEquals(horarioEntity.getHoraFin(), horario.getHoraFin());
		assertEquals(horarioEntity.getHoraInicioEspecial(), horario.getHoraInicioEspecial());
		assertEquals(horarioEntity.getHoraFinEspecial(), horario.getHoraFinEspecial());
		assertEquals(horarioEntity.getPuestoDeTrabajo().getIdpuestoDeTrabajo(), horario.getIdPuestoTrabajo());
		assertEquals(horarioEntity.getTurnosDeTrabajo().getIdturnosDeTrabajo(), horario.getIdTurnoTrabajo());
	}
	
	/**
	 * Test : Mapping from 'Horario' to 'HorarioEntity'
	 */
	@Test
	public void testMapHorarioToHorarioEntity() {
		// Given
		Horario horario = new Horario();
		horario.setHoraInicio(mockValues.nextDate());
		horario.setHoraFin(mockValues.nextDate());
		horario.setHoraInicioEspecial(mockValues.nextDate());
		horario.setHoraFinEspecial(mockValues.nextDate());
		horario.setIdPuestoTrabajo(mockValues.nextInteger());
		horario.setIdTurnoTrabajo(mockValues.nextInteger());

		HorarioEntity horarioEntity = new HorarioEntity();
		
		// When
		horarioServiceMapper.mapHorarioToHorarioEntity(horario, horarioEntity);
		
		// Then
		assertEquals(horario.getHoraInicio(), horarioEntity.getHoraInicio());
		assertEquals(horario.getHoraFin(), horarioEntity.getHoraFin());
		assertEquals(horario.getHoraInicioEspecial(), horarioEntity.getHoraInicioEspecial());
		assertEquals(horario.getHoraFinEspecial(), horarioEntity.getHoraFinEspecial());
		assertEquals(horario.getIdPuestoTrabajo(), horarioEntity.getPuestoDeTrabajo().getIdpuestoDeTrabajo());
		assertEquals(horario.getIdTurnoTrabajo(), horarioEntity.getTurnosDeTrabajo().getIdturnosDeTrabajo());
	}

}