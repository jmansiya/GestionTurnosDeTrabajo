package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.sun.resorts.holidays.model.jpa.HorarioEntity;

/**
 * Repository : Horario.
 */
public interface HorarioJpaRepository extends PagingAndSortingRepository<HorarioEntity, Integer> {

}
