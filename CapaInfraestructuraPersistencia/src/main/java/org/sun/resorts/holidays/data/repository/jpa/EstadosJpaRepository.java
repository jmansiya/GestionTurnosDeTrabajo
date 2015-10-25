package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.sun.resorts.holidays.data.model.EstadosEntity;

/**
 * Repository : Estados.
 */
public interface EstadosJpaRepository extends PagingAndSortingRepository<EstadosEntity, Integer> {

}
