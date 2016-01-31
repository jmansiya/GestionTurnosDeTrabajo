package gestion.turnos.transversal.seguridad;

import gestion.turnos.transversal.seguridad.dto.UsuarioDTO;

public interface IJWTwebTokens {
	
	/** Generamos nuestro TOKEN **/
	public String createJWT(UsuarioDTO usuario, long tiempoExpiracion);
	
	/** Decodificamos el TOKEN que nos llega. **/
	public UsuarioDTO parseJWT(String jwt);
}
