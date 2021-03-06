/*
 * Created on 31 oct 2015 ( Time 10:51:34 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.persistence.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.sun.resorts.holidays.model.Perfiles;
import org.sun.resorts.holidays.model.jpa.PerfilesEntity;
import java.util.List;
import org.sun.resorts.holidays.persistence.service.PerfilesService;
import org.sun.resorts.holidays.persistence.service.mapping.PerfilesServiceMapper;
import org.sun.resorts.holidays.data.repository.jpa.PerfilesJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of PerfilesService
 */
@Component
@Transactional
public class PerfilesServiceImpl implements PerfilesService {

	@Resource
	private PerfilesJpaRepository perfilesJpaRepository;

	@Resource
	private PerfilesServiceMapper perfilesServiceMapper;
	
	@Override
	public Perfiles findById(Integer idperfiles) {
		PerfilesEntity perfilesEntity = perfilesJpaRepository.findOne(idperfiles);
		return perfilesServiceMapper.mapPerfilesEntityToPerfiles(perfilesEntity);
	}

	@Override
	public List<Perfiles> findAll() {
		Iterable<PerfilesEntity> entities = perfilesJpaRepository.findAll();
		List<Perfiles> beans = new ArrayList<Perfiles>();
		for(PerfilesEntity perfilesEntity : entities) {
			beans.add(perfilesServiceMapper.mapPerfilesEntityToPerfiles(perfilesEntity));
		}
		return beans;
	}

	@Override
	public Perfiles save(Perfiles perfiles) {
		return update(perfiles) ;
	}

	@Override
	public Perfiles create(Perfiles perfiles) {
		PerfilesEntity perfilesEntity = perfilesJpaRepository.findOne(perfiles.getIdperfiles());
		if( perfilesEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		perfilesEntity = new PerfilesEntity();
		perfilesServiceMapper.mapPerfilesToPerfilesEntity(perfiles, perfilesEntity);
		PerfilesEntity perfilesEntitySaved = perfilesJpaRepository.save(perfilesEntity);
		return perfilesServiceMapper.mapPerfilesEntityToPerfiles(perfilesEntitySaved);
	}

	@Override
	public Perfiles update(Perfiles perfiles) {
		PerfilesEntity perfilesEntity = perfilesJpaRepository.findOne(perfiles.getIdperfiles());
		perfilesServiceMapper.mapPerfilesToPerfilesEntity(perfiles, perfilesEntity);
		PerfilesEntity perfilesEntitySaved = perfilesJpaRepository.save(perfilesEntity);
		return perfilesServiceMapper.mapPerfilesEntityToPerfiles(perfilesEntitySaved);
	}

	@Override
	public void delete(Integer idperfiles) {
		perfilesJpaRepository.delete(idperfiles);
	}

	public PerfilesJpaRepository getPerfilesJpaRepository() {
		return perfilesJpaRepository;
	}

	public void setPerfilesJpaRepository(PerfilesJpaRepository perfilesJpaRepository) {
		this.perfilesJpaRepository = perfilesJpaRepository;
	}

	public PerfilesServiceMapper getPerfilesServiceMapper() {
		return perfilesServiceMapper;
	}

	public void setPerfilesServiceMapper(PerfilesServiceMapper perfilesServiceMapper) {
		this.perfilesServiceMapper = perfilesServiceMapper;
	}

}
