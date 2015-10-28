package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sun.resorts.holidays.model.jpa.VacacionesEntity;

/**
 * Repository : Vacaciones.
 */
public interface VacacionesJpaRepository extends JpaRepository<VacacionesEntity, Integer> {

}
