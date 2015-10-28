package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sun.resorts.holidays.model.jpa.HorarioEntity;

/**
 * Repository : Horario.
 */
public interface HorarioJpaRepository extends JpaRepository<HorarioEntity, Integer> {

}
