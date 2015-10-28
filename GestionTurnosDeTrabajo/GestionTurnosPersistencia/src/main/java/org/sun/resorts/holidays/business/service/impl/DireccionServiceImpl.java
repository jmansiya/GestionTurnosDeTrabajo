/*
 * Created on 28 oct 2015 ( Time 21:40:09 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.sun.resorts.holidays.model.Direccion;
import org.sun.resorts.holidays.model.jpa.DireccionEntity;
import java.util.List;
import org.sun.resorts.holidays.business.service.DireccionService;
import org.sun.resorts.holidays.business.service.mapping.DireccionServiceMapper;
import org.sun.resorts.holidays.data.repository.jpa.DireccionJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of DireccionService
 */
@Component
@Transactional
public class DireccionServiceImpl implements DireccionService {

	@Resource
	private DireccionJpaRepository direccionJpaRepository;

	@Resource
	private DireccionServiceMapper direccionServiceMapper;
	
	
	public Direccion findById(Integer iddireccion) {
		DireccionEntity direccionEntity = direccionJpaRepository.findOne(iddireccion);
		return direccionServiceMapper.mapDireccionEntityToDireccion(direccionEntity);
	}

	
	public List<Direccion> findAll() {
		Iterable<DireccionEntity> entities = direccionJpaRepository.findAll();
		List<Direccion> beans = new ArrayList<Direccion>();
		for(DireccionEntity direccionEntity : entities) {
			beans.add(direccionServiceMapper.mapDireccionEntityToDireccion(direccionEntity));
		}
		return beans;
	}

	
	public Direccion save(Direccion direccion) {
		return update(direccion) ;
	}

	
	public Direccion create(Direccion direccion) {
		DireccionEntity direccionEntity = direccionJpaRepository.findOne(direccion.getIddireccion());
		if( direccionEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		direccionEntity = new DireccionEntity();
		direccionServiceMapper.mapDireccionToDireccionEntity(direccion, direccionEntity);
		DireccionEntity direccionEntitySaved = direccionJpaRepository.save(direccionEntity);
		return direccionServiceMapper.mapDireccionEntityToDireccion(direccionEntitySaved);
	}

	
	public Direccion update(Direccion direccion) {
		DireccionEntity direccionEntity = direccionJpaRepository.findOne(direccion.getIddireccion());
		direccionServiceMapper.mapDireccionToDireccionEntity(direccion, direccionEntity);
		DireccionEntity direccionEntitySaved = direccionJpaRepository.save(direccionEntity);
		return direccionServiceMapper.mapDireccionEntityToDireccion(direccionEntitySaved);
	}

	
	public void delete(Integer iddireccion) {
		direccionJpaRepository.delete(iddireccion);
	}

	public DireccionJpaRepository getDireccionJpaRepository() {
		return direccionJpaRepository;
	}

	public void setDireccionJpaRepository(DireccionJpaRepository direccionJpaRepository) {
		this.direccionJpaRepository = direccionJpaRepository;
	}

	public DireccionServiceMapper getDireccionServiceMapper() {
		return direccionServiceMapper;
	}

	public void setDireccionServiceMapper(DireccionServiceMapper direccionServiceMapper) {
		this.direccionServiceMapper = direccionServiceMapper;
	}

}