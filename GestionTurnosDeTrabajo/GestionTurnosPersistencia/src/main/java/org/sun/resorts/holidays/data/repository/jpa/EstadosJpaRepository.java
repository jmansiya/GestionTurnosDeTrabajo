package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sun.resorts.holidays.model.jpa.EstadosEntity;

/**
 * Repository : Estados.
 */
public interface EstadosJpaRepository extends JpaRepository<EstadosEntity, Integer> {

}
