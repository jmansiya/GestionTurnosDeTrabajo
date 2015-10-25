package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.sun.resorts.holidays.data.model.TipoFechaEntity;

/**
 * Repository : TipoFecha.
 */
public interface TipoFechaJpaRepository extends PagingAndSortingRepository<TipoFechaEntity, Integer> {

}
