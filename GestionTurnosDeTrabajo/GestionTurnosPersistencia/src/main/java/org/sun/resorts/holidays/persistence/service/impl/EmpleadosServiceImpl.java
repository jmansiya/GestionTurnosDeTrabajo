/*
 * Created on 31 oct 2015 ( Time 10:51:34 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.persistence.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.sun.resorts.holidays.model.Empleados;
import org.sun.resorts.holidays.model.jpa.EmpleadosEntity;
import java.util.Date;
import java.util.List;
import org.sun.resorts.holidays.persistence.service.EmpleadosService;
import org.sun.resorts.holidays.persistence.service.mapping.EmpleadosServiceMapper;
import org.sun.resorts.holidays.data.repository.jpa.EmpleadosJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of EmpleadosService
 */
@Component
@Transactional
public class EmpleadosServiceImpl implements EmpleadosService {

	@Resource
	private EmpleadosJpaRepository empleadosJpaRepository;

	@Resource
	private EmpleadosServiceMapper empleadosServiceMapper;
	
	@Override
	public Empleados findById(Integer idempleados) {
		EmpleadosEntity empleadosEntity = empleadosJpaRepository.findOne(idempleados);
		return empleadosServiceMapper.mapEmpleadosEntityToEmpleados(empleadosEntity);
	}

	@Override
	public List<Empleados> findAll() {
		Iterable<EmpleadosEntity> entities = empleadosJpaRepository.findAll();
		List<Empleados> beans = new ArrayList<Empleados>();
		for(EmpleadosEntity empleadosEntity : entities) {
			beans.add(empleadosServiceMapper.mapEmpleadosEntityToEmpleados(empleadosEntity));
		}
		return beans;
	}

	@Override
	public Empleados save(Empleados empleados) {
		return update(empleados) ;
	}

	@Override
	public Empleados create(Empleados empleados) {
		EmpleadosEntity empleadosEntity = empleadosJpaRepository.findOne(empleados.getIdempleados());
		if( empleadosEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		empleadosEntity = new EmpleadosEntity();
		empleadosServiceMapper.mapEmpleadosToEmpleadosEntity(empleados, empleadosEntity);
		EmpleadosEntity empleadosEntitySaved = empleadosJpaRepository.save(empleadosEntity);
		return empleadosServiceMapper.mapEmpleadosEntityToEmpleados(empleadosEntitySaved);
	}

	@Override
	public Empleados update(Empleados empleados) {
		EmpleadosEntity empleadosEntity = empleadosJpaRepository.findOne(empleados.getIdempleados());
		empleadosServiceMapper.mapEmpleadosToEmpleadosEntity(empleados, empleadosEntity);
		EmpleadosEntity empleadosEntitySaved = empleadosJpaRepository.save(empleadosEntity);
		return empleadosServiceMapper.mapEmpleadosEntityToEmpleados(empleadosEntitySaved);
	}

	@Override
	public void delete(Integer idempleados) {
		empleadosJpaRepository.delete(idempleados);
	}

	public EmpleadosJpaRepository getEmpleadosJpaRepository() {
		return empleadosJpaRepository;
	}

	public void setEmpleadosJpaRepository(EmpleadosJpaRepository empleadosJpaRepository) {
		this.empleadosJpaRepository = empleadosJpaRepository;
	}

	public EmpleadosServiceMapper getEmpleadosServiceMapper() {
		return empleadosServiceMapper;
	}

	public void setEmpleadosServiceMapper(EmpleadosServiceMapper empleadosServiceMapper) {
		this.empleadosServiceMapper = empleadosServiceMapper;
	}

}
