package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sun.resorts.holidays.model.jpa.PlanillasHasEmpleadosEntity;
import org.sun.resorts.holidays.model.jpa.PlanillasHasEmpleadosEntityKey;

/**
 * Repository : PlanillasHasEmpleados.
 */
public interface PlanillasHasEmpleadosJpaRepository extends JpaRepository<PlanillasHasEmpleadosEntity, PlanillasHasEmpleadosEntityKey> {

}
