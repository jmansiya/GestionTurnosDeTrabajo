package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.sun.resorts.holidays.data.model.PlanillasEntity;

/**
 * Repository : Planillas.
 */
public interface PlanillasJpaRepository extends PagingAndSortingRepository<PlanillasEntity, Integer> {

}
