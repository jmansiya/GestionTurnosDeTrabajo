package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.sun.resorts.holidays.model.jpa.TipoFechaEntity;

/**
 * Repository : TipoFecha.
 */
public interface TipoFechaJpaRepository extends PagingAndSortingRepository<TipoFechaEntity, Integer> {

}
