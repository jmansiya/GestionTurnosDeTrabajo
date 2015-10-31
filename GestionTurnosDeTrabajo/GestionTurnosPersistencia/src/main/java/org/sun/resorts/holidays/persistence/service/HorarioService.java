/*
 * Created on 31 oct 2015 ( Time 10:51:34 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.persistence.service;

import java.util.List;

import org.sun.resorts.holidays.model.Horario;

/**
 * Business Service Interface for entity Horario.
 */
public interface HorarioService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param idhorario
	 * @return entity
	 */
	Horario findById( Integer idhorario  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Horario> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Horario save(Horario entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Horario update(Horario entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Horario create(Horario entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param idhorario
	 */
	void delete( Integer idhorario );


}