package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.sun.resorts.holidays.model.jpa.PlanillasEntity;
import org.sun.resorts.holidays.model.jpa.PlanillasEntityKey;

/**
 * Repository : Planillas.
 */
public interface PlanillasJpaRepository extends PagingAndSortingRepository<PlanillasEntity, PlanillasEntityKey> {

}
