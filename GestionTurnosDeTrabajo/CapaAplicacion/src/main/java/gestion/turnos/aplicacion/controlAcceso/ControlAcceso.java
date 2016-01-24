/**
 * 
 */
package gestion.turnos.aplicacion.controlAcceso;

import gestion.turnos.aplicacion.fachada.dto.UsuarioDTO;

/**
 * @author JoseMansilla
 *
 * Descripción: Interfaces del servicio de la capa de aplicación a través del cual se podrá consultar
 * su un usuario existe o no en el sistema.
 */
public interface ControlAcceso {
	public UsuarioDTO comprobarUsuario(String nombre, String password);
}
