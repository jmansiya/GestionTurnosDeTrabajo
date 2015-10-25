package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.sun.resorts.holidays.data.model.PlanillasHasEmpleadosEntity;
import org.sun.resorts.holidays.data.model.PlanillasHasEmpleadosEntityKey;

/**
 * Repository : PlanillasHasEmpleados.
 */
public interface PlanillasHasEmpleadosJpaRepository extends PagingAndSortingRepository<PlanillasHasEmpleadosEntity, PlanillasHasEmpleadosEntityKey> {

}
