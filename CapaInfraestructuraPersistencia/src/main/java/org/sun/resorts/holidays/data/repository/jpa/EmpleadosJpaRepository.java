package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.sun.resorts.holidays.model.jpa.EmpleadosEntity;

/**
 * Repository : Empleados.
 */
public interface EmpleadosJpaRepository extends PagingAndSortingRepository<EmpleadosEntity, Integer> {

}
