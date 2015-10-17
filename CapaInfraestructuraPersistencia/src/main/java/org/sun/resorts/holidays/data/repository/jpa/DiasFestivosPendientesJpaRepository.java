package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.sun.resorts.holidays.model.jpa.DiasFestivosPendientesEntity;

/**
 * Repository : DiasFestivosPendientes.
 */
public interface DiasFestivosPendientesJpaRepository extends PagingAndSortingRepository<DiasFestivosPendientesEntity, Integer> {

}
