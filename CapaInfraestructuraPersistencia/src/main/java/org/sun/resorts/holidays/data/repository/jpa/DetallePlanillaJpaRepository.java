package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.sun.resorts.holidays.model.jpa.DetallePlanillaEntity;

/**
 * Repository : DetallePlanilla.
 */
public interface DetallePlanillaJpaRepository extends PagingAndSortingRepository<DetallePlanillaEntity, Integer> {

}
