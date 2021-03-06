/*
 * Created on 31 oct 2015 ( Time 10:51:34 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.persistence.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.sun.resorts.holidays.model.Estados;
import org.sun.resorts.holidays.model.jpa.EstadosEntity;
import java.util.List;
import org.sun.resorts.holidays.persistence.service.EstadosService;
import org.sun.resorts.holidays.persistence.service.mapping.EstadosServiceMapper;
import org.sun.resorts.holidays.data.repository.jpa.EstadosJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of EstadosService
 */
@Component
@Transactional
public class EstadosServiceImpl implements EstadosService {

	@Resource
	private EstadosJpaRepository estadosJpaRepository;

	@Resource
	private EstadosServiceMapper estadosServiceMapper;
	
	@Override
	public Estados findById(Integer idestados) {
		EstadosEntity estadosEntity = estadosJpaRepository.findOne(idestados);
		return estadosServiceMapper.mapEstadosEntityToEstados(estadosEntity);
	}

	@Override
	public List<Estados> findAll() {
		Iterable<EstadosEntity> entities = estadosJpaRepository.findAll();
		List<Estados> beans = new ArrayList<Estados>();
		for(EstadosEntity estadosEntity : entities) {
			beans.add(estadosServiceMapper.mapEstadosEntityToEstados(estadosEntity));
		}
		return beans;
	}

	@Override
	public Estados save(Estados estados) {
		return update(estados) ;
	}

	@Override
	public Estados create(Estados estados) {
		EstadosEntity estadosEntity = estadosJpaRepository.findOne(estados.getIdestados());
		if( estadosEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		estadosEntity = new EstadosEntity();
		estadosServiceMapper.mapEstadosToEstadosEntity(estados, estadosEntity);
		EstadosEntity estadosEntitySaved = estadosJpaRepository.save(estadosEntity);
		return estadosServiceMapper.mapEstadosEntityToEstados(estadosEntitySaved);
	}

	@Override
	public Estados update(Estados estados) {
		EstadosEntity estadosEntity = estadosJpaRepository.findOne(estados.getIdestados());
		estadosServiceMapper.mapEstadosToEstadosEntity(estados, estadosEntity);
		EstadosEntity estadosEntitySaved = estadosJpaRepository.save(estadosEntity);
		return estadosServiceMapper.mapEstadosEntityToEstados(estadosEntitySaved);
	}

	@Override
	public void delete(Integer idestados) {
		estadosJpaRepository.delete(idestados);
	}

	public EstadosJpaRepository getEstadosJpaRepository() {
		return estadosJpaRepository;
	}

	public void setEstadosJpaRepository(EstadosJpaRepository estadosJpaRepository) {
		this.estadosJpaRepository = estadosJpaRepository;
	}

	public EstadosServiceMapper getEstadosServiceMapper() {
		return estadosServiceMapper;
	}

	public void setEstadosServiceMapper(EstadosServiceMapper estadosServiceMapper) {
		this.estadosServiceMapper = estadosServiceMapper;
	}

}
