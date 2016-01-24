package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sun.resorts.holidays.model.jpa.UsuariosEntity;

/**
 * Repository : Usuarios.
 */
public interface UsuariosJpaRepository extends JpaRepository<UsuariosEntity, Integer> {
	/**
	 * Método que servirá para comprobar si un usuario que se intenta validar en el sistema
	 * existe o no.
	 */
	public UsuariosEntity findByNombreAndPassword(String name, String password);

}
