package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.sun.resorts.holidays.model.jpa.TurnosTrabajoEspecialesEntity;
import org.sun.resorts.holidays.model.jpa.TurnosTrabajoEspecialesEntityKey;

/**
 * Repository : TurnosTrabajoEspeciales.
 */
public interface TurnosTrabajoEspecialesJpaRepository extends PagingAndSortingRepository<TurnosTrabajoEspecialesEntity, TurnosTrabajoEspecialesEntityKey> {

}
