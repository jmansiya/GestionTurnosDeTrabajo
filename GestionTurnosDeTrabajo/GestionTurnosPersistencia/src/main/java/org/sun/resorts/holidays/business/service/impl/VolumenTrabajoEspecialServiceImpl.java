/*
 * Created on 28 oct 2015 ( Time 21:40:11 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.sun.resorts.holidays.model.VolumenTrabajoEspecial;
import org.sun.resorts.holidays.model.jpa.VolumenTrabajoEspecialEntity;
import java.util.Date;
import java.util.List;
import org.sun.resorts.holidays.business.service.VolumenTrabajoEspecialService;
import org.sun.resorts.holidays.business.service.mapping.VolumenTrabajoEspecialServiceMapper;
import org.sun.resorts.holidays.data.repository.jpa.VolumenTrabajoEspecialJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of VolumenTrabajoEspecialService
 */
@Component
@Transactional
public class VolumenTrabajoEspecialServiceImpl implements VolumenTrabajoEspecialService {

	@Resource
	private VolumenTrabajoEspecialJpaRepository volumenTrabajoEspecialJpaRepository;

	@Resource
	private VolumenTrabajoEspecialServiceMapper volumenTrabajoEspecialServiceMapper;
	
	public VolumenTrabajoEspecial findById(Integer idvolumen) {
		VolumenTrabajoEspecialEntity volumenTrabajoEspecialEntity = volumenTrabajoEspecialJpaRepository.findOne(idvolumen);
		return volumenTrabajoEspecialServiceMapper.mapVolumenTrabajoEspecialEntityToVolumenTrabajoEspecial(volumenTrabajoEspecialEntity);
	}

	
	public List<VolumenTrabajoEspecial> findAll() {
		Iterable<VolumenTrabajoEspecialEntity> entities = volumenTrabajoEspecialJpaRepository.findAll();
		List<VolumenTrabajoEspecial> beans = new ArrayList<VolumenTrabajoEspecial>();
		for(VolumenTrabajoEspecialEntity volumenTrabajoEspecialEntity : entities) {
			beans.add(volumenTrabajoEspecialServiceMapper.mapVolumenTrabajoEspecialEntityToVolumenTrabajoEspecial(volumenTrabajoEspecialEntity));
		}
		return beans;
	}

	
	public VolumenTrabajoEspecial save(VolumenTrabajoEspecial volumenTrabajoEspecial) {
		return update(volumenTrabajoEspecial) ;
	}

	
	public VolumenTrabajoEspecial create(VolumenTrabajoEspecial volumenTrabajoEspecial) {
		VolumenTrabajoEspecialEntity volumenTrabajoEspecialEntity = volumenTrabajoEspecialJpaRepository.findOne(volumenTrabajoEspecial.getIdvolumen());
		if( volumenTrabajoEspecialEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		volumenTrabajoEspecialEntity = new VolumenTrabajoEspecialEntity();
		volumenTrabajoEspecialServiceMapper.mapVolumenTrabajoEspecialToVolumenTrabajoEspecialEntity(volumenTrabajoEspecial, volumenTrabajoEspecialEntity);
		VolumenTrabajoEspecialEntity volumenTrabajoEspecialEntitySaved = volumenTrabajoEspecialJpaRepository.save(volumenTrabajoEspecialEntity);
		return volumenTrabajoEspecialServiceMapper.mapVolumenTrabajoEspecialEntityToVolumenTrabajoEspecial(volumenTrabajoEspecialEntitySaved);
	}

	
	public VolumenTrabajoEspecial update(VolumenTrabajoEspecial volumenTrabajoEspecial) {
		VolumenTrabajoEspecialEntity volumenTrabajoEspecialEntity = volumenTrabajoEspecialJpaRepository.findOne(volumenTrabajoEspecial.getIdvolumen());
		volumenTrabajoEspecialServiceMapper.mapVolumenTrabajoEspecialToVolumenTrabajoEspecialEntity(volumenTrabajoEspecial, volumenTrabajoEspecialEntity);
		VolumenTrabajoEspecialEntity volumenTrabajoEspecialEntitySaved = volumenTrabajoEspecialJpaRepository.save(volumenTrabajoEspecialEntity);
		return volumenTrabajoEspecialServiceMapper.mapVolumenTrabajoEspecialEntityToVolumenTrabajoEspecial(volumenTrabajoEspecialEntitySaved);
	}

	
	public void delete(Integer idvolumen) {
		volumenTrabajoEspecialJpaRepository.delete(idvolumen);
	}

	public VolumenTrabajoEspecialJpaRepository getVolumenTrabajoEspecialJpaRepository() {
		return volumenTrabajoEspecialJpaRepository;
	}

	public void setVolumenTrabajoEspecialJpaRepository(VolumenTrabajoEspecialJpaRepository volumenTrabajoEspecialJpaRepository) {
		this.volumenTrabajoEspecialJpaRepository = volumenTrabajoEspecialJpaRepository;
	}

	public VolumenTrabajoEspecialServiceMapper getVolumenTrabajoEspecialServiceMapper() {
		return volumenTrabajoEspecialServiceMapper;
	}

	public void setVolumenTrabajoEspecialServiceMapper(VolumenTrabajoEspecialServiceMapper volumenTrabajoEspecialServiceMapper) {
		this.volumenTrabajoEspecialServiceMapper = volumenTrabajoEspecialServiceMapper;
	}

}
