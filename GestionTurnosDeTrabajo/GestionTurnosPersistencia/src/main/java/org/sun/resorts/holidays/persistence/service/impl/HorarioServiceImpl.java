/*
 * Created on 31 oct 2015 ( Time 10:51:34 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.persistence.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.sun.resorts.holidays.model.Horario;
import org.sun.resorts.holidays.model.jpa.HorarioEntity;
import java.util.Date;
import org.sun.resorts.holidays.persistence.service.HorarioService;
import org.sun.resorts.holidays.persistence.service.mapping.HorarioServiceMapper;
import org.sun.resorts.holidays.data.repository.jpa.HorarioJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of HorarioService
 */
@Component
@Transactional
public class HorarioServiceImpl implements HorarioService {

	@Resource
	private HorarioJpaRepository horarioJpaRepository;

	@Resource
	private HorarioServiceMapper horarioServiceMapper;
	
	@Override
	public Horario findById(Integer idhorario) {
		HorarioEntity horarioEntity = horarioJpaRepository.findOne(idhorario);
		return horarioServiceMapper.mapHorarioEntityToHorario(horarioEntity);
	}

	@Override
	public List<Horario> findAll() {
		Iterable<HorarioEntity> entities = horarioJpaRepository.findAll();
		List<Horario> beans = new ArrayList<Horario>();
		for(HorarioEntity horarioEntity : entities) {
			beans.add(horarioServiceMapper.mapHorarioEntityToHorario(horarioEntity));
		}
		return beans;
	}

	@Override
	public Horario save(Horario horario) {
		return update(horario) ;
	}

	@Override
	public Horario create(Horario horario) {
		HorarioEntity horarioEntity = horarioJpaRepository.findOne(horario.getIdhorario());
		if( horarioEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		horarioEntity = new HorarioEntity();
		horarioServiceMapper.mapHorarioToHorarioEntity(horario, horarioEntity);
		HorarioEntity horarioEntitySaved = horarioJpaRepository.save(horarioEntity);
		return horarioServiceMapper.mapHorarioEntityToHorario(horarioEntitySaved);
	}

	@Override
	public Horario update(Horario horario) {
		HorarioEntity horarioEntity = horarioJpaRepository.findOne(horario.getIdhorario());
		horarioServiceMapper.mapHorarioToHorarioEntity(horario, horarioEntity);
		HorarioEntity horarioEntitySaved = horarioJpaRepository.save(horarioEntity);
		return horarioServiceMapper.mapHorarioEntityToHorario(horarioEntitySaved);
	}

	@Override
	public void delete(Integer idhorario) {
		horarioJpaRepository.delete(idhorario);
	}

	public HorarioJpaRepository getHorarioJpaRepository() {
		return horarioJpaRepository;
	}

	public void setHorarioJpaRepository(HorarioJpaRepository horarioJpaRepository) {
		this.horarioJpaRepository = horarioJpaRepository;
	}

	public HorarioServiceMapper getHorarioServiceMapper() {
		return horarioServiceMapper;
	}

	public void setHorarioServiceMapper(HorarioServiceMapper horarioServiceMapper) {
		this.horarioServiceMapper = horarioServiceMapper;
	}

}
