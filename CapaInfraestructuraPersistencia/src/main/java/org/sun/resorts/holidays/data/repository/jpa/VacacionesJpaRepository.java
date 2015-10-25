package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.sun.resorts.holidays.data.model.VacacionesEntity;

/**
 * Repository : Vacaciones.
 */
public interface VacacionesJpaRepository extends PagingAndSortingRepository<VacacionesEntity, Integer> {

}
