package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.sun.resorts.holidays.model.jpa.UsuariosEntity;

/**
 * Repository : Usuarios.
 */
public interface UsuariosJpaRepository extends PagingAndSortingRepository<UsuariosEntity, Integer> {

}
