/*
 * Created on 31 oct 2015 ( Time 10:51:35 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.sun.resorts.holidays.persistence.service;

import java.util.List;

import org.sun.resorts.holidays.model.Vacaciones;

/**
 * Business Service Interface for entity Vacaciones.
 */
public interface VacacionesService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param idvacaciones
	 * @return entity
	 */
	Vacaciones findById( Integer idvacaciones  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Vacaciones> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Vacaciones save(Vacaciones entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Vacaciones update(Vacaciones entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Vacaciones create(Vacaciones entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param idvacaciones
	 */
	void delete( Integer idvacaciones );


}