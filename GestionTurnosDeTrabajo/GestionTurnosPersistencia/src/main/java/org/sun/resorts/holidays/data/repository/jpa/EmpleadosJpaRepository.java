package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sun.resorts.holidays.model.jpa.EmpleadosEntity;

/**
 * Repository : Empleados.
 */
public interface EmpleadosJpaRepository extends JpaRepository<EmpleadosEntity, Integer> {

}
