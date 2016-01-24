/**
 * 
 */
package gestion.turnos.aplicacion.controlAcceso;

import gestion.turnos.aplicacion.fachada.dto.UsuarioDTO;

/**
 * @author JoseMansilla
 *
 * Descripci�n: Interfaces del servicio de la capa de aplicaci�n a trav�s del cual se podr� consultar
 * su un usuario existe o no en el sistema.
 */
public interface ControlAcceso {
	public UsuarioDTO comprobarUsuario(String nombre, String password);
}
