package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.sun.resorts.holidays.data.model.TurnosDeTrabajoEntity;
import org.sun.resorts.holidays.data.model.TurnosDeTrabajoEntityKey;

/**
 * Repository : TurnosDeTrabajo.
 */
public interface TurnosDeTrabajoJpaRepository extends PagingAndSortingRepository<TurnosDeTrabajoEntity, TurnosDeTrabajoEntityKey> {

}
