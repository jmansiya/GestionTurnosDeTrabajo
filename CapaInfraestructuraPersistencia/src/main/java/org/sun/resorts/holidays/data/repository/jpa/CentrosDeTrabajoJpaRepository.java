package org.sun.resorts.holidays.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.sun.resorts.holidays.data.model.CentrosDeTrabajoEntity;

/**
 * Repository : CentrosDeTrabajo.
 */
public interface CentrosDeTrabajoJpaRepository extends JpaRepository<CentrosDeTrabajoEntity, Integer> {

	@Modifying
	@Query("update CentrosDeTrabajoEntity c set c.nombre= ?1, c.descripcion= ?2, c.parking= ?3, c.piscina = ?4, c.numHabitaciones= ?5, c.numEstrellas= ?6 where c.idcentrosDeTrabajo= ?7")
	public int setCentroTrabajoById(String nombre, String descripcion, boolean parking, boolean piscina, int numHabitaciones, int numEstralleas, Integer id);
	
	@Modifying
	@Query("update CentrosDeTrabajoEntity c set c.direccion=?1 where c.idcentrosDeTrabajo=?2")
	public int setDireccionCentroTrabajoById(DireccionJpaRepository direccion, Integer idCentro);
	
	/**
	 * @TODO
	 *  Pendiente crear administrador del centro de trabajo y comprobar como se pueden añadir Puestos de Trabajo a un Centro de trabajo indicado.
	 *  
	 * @return
	 */
	
}
