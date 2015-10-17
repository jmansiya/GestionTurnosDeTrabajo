package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.sun.resorts.holidays.model.jpa.PuestoDeTrabajoEntity;

/**
 * Repository : PuestoDeTrabajo.
 */
public interface PuestoDeTrabajoJpaRepository extends PagingAndSortingRepository<PuestoDeTrabajoEntity, Integer> {

}
