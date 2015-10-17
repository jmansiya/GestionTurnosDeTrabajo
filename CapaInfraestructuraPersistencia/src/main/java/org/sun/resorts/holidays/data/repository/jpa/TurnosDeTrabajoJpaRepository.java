package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.sun.resorts.holidays.model.jpa.TurnosDeTrabajoEntity;
import org.sun.resorts.holidays.model.jpa.TurnosDeTrabajoEntityKey;

/**
 * Repository : TurnosDeTrabajo.
 */
public interface TurnosDeTrabajoJpaRepository extends PagingAndSortingRepository<TurnosDeTrabajoEntity, TurnosDeTrabajoEntityKey> {

}
