/*
 * Created on 31 oct 2015 ( Time 10:51:33 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.persistence.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.sun.resorts.holidays.model.DetallePlanilla;
import org.sun.resorts.holidays.model.jpa.DetallePlanillaEntity;
import java.util.Date;
import java.util.List;
import org.sun.resorts.holidays.persistence.service.DetallePlanillaService;
import org.sun.resorts.holidays.persistence.service.mapping.DetallePlanillaServiceMapper;
import org.sun.resorts.holidays.data.repository.jpa.DetallePlanillaJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of DetallePlanillaService
 */
@Component
@Transactional
public class DetallePlanillaServiceImpl implements DetallePlanillaService {

	@Resource
	private DetallePlanillaJpaRepository detallePlanillaJpaRepository;

	@Resource
	private DetallePlanillaServiceMapper detallePlanillaServiceMapper;
	
	@Override
	public DetallePlanilla findById(Integer idDetalle) {
		DetallePlanillaEntity detallePlanillaEntity = detallePlanillaJpaRepository.findOne(idDetalle);
		return detallePlanillaServiceMapper.mapDetallePlanillaEntityToDetallePlanilla(detallePlanillaEntity);
	}

	@Override
	public List<DetallePlanilla> findAll() {
		Iterable<DetallePlanillaEntity> entities = detallePlanillaJpaRepository.findAll();
		List<DetallePlanilla> beans = new ArrayList<DetallePlanilla>();
		for(DetallePlanillaEntity detallePlanillaEntity : entities) {
			beans.add(detallePlanillaServiceMapper.mapDetallePlanillaEntityToDetallePlanilla(detallePlanillaEntity));
		}
		return beans;
	}

	@Override
	public DetallePlanilla save(DetallePlanilla detallePlanilla) {
		return update(detallePlanilla) ;
	}

	@Override
	public DetallePlanilla create(DetallePlanilla detallePlanilla) {
		DetallePlanillaEntity detallePlanillaEntity = detallePlanillaJpaRepository.findOne(detallePlanilla.getIdDetalle());
		if( detallePlanillaEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		detallePlanillaEntity = new DetallePlanillaEntity();
		detallePlanillaServiceMapper.mapDetallePlanillaToDetallePlanillaEntity(detallePlanilla, detallePlanillaEntity);
		DetallePlanillaEntity detallePlanillaEntitySaved = detallePlanillaJpaRepository.save(detallePlanillaEntity);
		return detallePlanillaServiceMapper.mapDetallePlanillaEntityToDetallePlanilla(detallePlanillaEntitySaved);
	}

	@Override
	public DetallePlanilla update(DetallePlanilla detallePlanilla) {
		DetallePlanillaEntity detallePlanillaEntity = detallePlanillaJpaRepository.findOne(detallePlanilla.getIdDetalle());
		detallePlanillaServiceMapper.mapDetallePlanillaToDetallePlanillaEntity(detallePlanilla, detallePlanillaEntity);
		DetallePlanillaEntity detallePlanillaEntitySaved = detallePlanillaJpaRepository.save(detallePlanillaEntity);
		return detallePlanillaServiceMapper.mapDetallePlanillaEntityToDetallePlanilla(detallePlanillaEntitySaved);
	}

	@Override
	public void delete(Integer idDetalle) {
		detallePlanillaJpaRepository.delete(idDetalle);
	}

	public DetallePlanillaJpaRepository getDetallePlanillaJpaRepository() {
		return detallePlanillaJpaRepository;
	}

	public void setDetallePlanillaJpaRepository(DetallePlanillaJpaRepository detallePlanillaJpaRepository) {
		this.detallePlanillaJpaRepository = detallePlanillaJpaRepository;
	}

	public DetallePlanillaServiceMapper getDetallePlanillaServiceMapper() {
		return detallePlanillaServiceMapper;
	}

	public void setDetallePlanillaServiceMapper(DetallePlanillaServiceMapper detallePlanillaServiceMapper) {
		this.detallePlanillaServiceMapper = detallePlanillaServiceMapper;
	}

}
