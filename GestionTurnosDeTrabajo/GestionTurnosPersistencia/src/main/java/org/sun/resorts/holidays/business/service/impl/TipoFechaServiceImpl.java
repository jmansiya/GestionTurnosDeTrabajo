/*
 * Created on 28 oct 2015 ( Time 21:40:11 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.sun.resorts.holidays.model.TipoFecha;
import org.sun.resorts.holidays.model.jpa.TipoFechaEntity;
import java.util.List;
import org.sun.resorts.holidays.business.service.TipoFechaService;
import org.sun.resorts.holidays.business.service.mapping.TipoFechaServiceMapper;
import org.sun.resorts.holidays.data.repository.jpa.TipoFechaJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of TipoFechaService
 */
@Component
@Transactional
public class TipoFechaServiceImpl implements TipoFechaService {

	@Resource
	private TipoFechaJpaRepository tipoFechaJpaRepository;

	@Resource
	private TipoFechaServiceMapper tipoFechaServiceMapper;
	
	
	public TipoFecha findById(Integer idtipoFecha) {
		TipoFechaEntity tipoFechaEntity = tipoFechaJpaRepository.findOne(idtipoFecha);
		return tipoFechaServiceMapper.mapTipoFechaEntityToTipoFecha(tipoFechaEntity);
	}

	
	public List<TipoFecha> findAll() {
		Iterable<TipoFechaEntity> entities = tipoFechaJpaRepository.findAll();
		List<TipoFecha> beans = new ArrayList<TipoFecha>();
		for(TipoFechaEntity tipoFechaEntity : entities) {
			beans.add(tipoFechaServiceMapper.mapTipoFechaEntityToTipoFecha(tipoFechaEntity));
		}
		return beans;
	}

	
	public TipoFecha save(TipoFecha tipoFecha) {
		return update(tipoFecha) ;
	}

	
	public TipoFecha create(TipoFecha tipoFecha) {
		TipoFechaEntity tipoFechaEntity = tipoFechaJpaRepository.findOne(tipoFecha.getIdtipoFecha());
		if( tipoFechaEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		tipoFechaEntity = new TipoFechaEntity();
		tipoFechaServiceMapper.mapTipoFechaToTipoFechaEntity(tipoFecha, tipoFechaEntity);
		TipoFechaEntity tipoFechaEntitySaved = tipoFechaJpaRepository.save(tipoFechaEntity);
		return tipoFechaServiceMapper.mapTipoFechaEntityToTipoFecha(tipoFechaEntitySaved);
	}

	
	public TipoFecha update(TipoFecha tipoFecha) {
		TipoFechaEntity tipoFechaEntity = tipoFechaJpaRepository.findOne(tipoFecha.getIdtipoFecha());
		tipoFechaServiceMapper.mapTipoFechaToTipoFechaEntity(tipoFecha, tipoFechaEntity);
		TipoFechaEntity tipoFechaEntitySaved = tipoFechaJpaRepository.save(tipoFechaEntity);
		return tipoFechaServiceMapper.mapTipoFechaEntityToTipoFecha(tipoFechaEntitySaved);
	}

	
	public void delete(Integer idtipoFecha) {
		tipoFechaJpaRepository.delete(idtipoFecha);
	}

	public TipoFechaJpaRepository getTipoFechaJpaRepository() {
		return tipoFechaJpaRepository;
	}

	public void setTipoFechaJpaRepository(TipoFechaJpaRepository tipoFechaJpaRepository) {
		this.tipoFechaJpaRepository = tipoFechaJpaRepository;
	}

	public TipoFechaServiceMapper getTipoFechaServiceMapper() {
		return tipoFechaServiceMapper;
	}

	public void setTipoFechaServiceMapper(TipoFechaServiceMapper tipoFechaServiceMapper) {
		this.tipoFechaServiceMapper = tipoFechaServiceMapper;
	}

}