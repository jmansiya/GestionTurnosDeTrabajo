package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.sun.resorts.holidays.data.model.DireccionEntity;

/**
 * Repository : Direccion.
 */
public interface DireccionJpaRepository extends PagingAndSortingRepository<DireccionEntity, Integer> {

}
