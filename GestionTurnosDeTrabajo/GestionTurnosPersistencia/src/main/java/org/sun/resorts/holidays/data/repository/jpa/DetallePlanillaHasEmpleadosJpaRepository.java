package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sun.resorts.holidays.model.jpa.DetallePlanillaHasEmpleadosEntity;
import org.sun.resorts.holidays.model.jpa.DetallePlanillaHasEmpleadosEntityKey;

/**
 * Repository : DetallePlanillaHasEmpleados.
 */
public interface DetallePlanillaHasEmpleadosJpaRepository extends JpaRepository<DetallePlanillaHasEmpleadosEntity, DetallePlanillaHasEmpleadosEntityKey> {

}
