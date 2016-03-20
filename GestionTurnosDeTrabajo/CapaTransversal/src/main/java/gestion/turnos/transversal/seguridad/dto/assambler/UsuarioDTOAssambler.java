package gestion.turnos.transversal.seguridad.dto.assambler;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.sun.resorts.holidays.model.Empleados;

import gestion.turnos.transversal.seguridad.dto.UsuarioDTO;

public class UsuarioDTOAssambler {
	public static UsuarioDTO toDTO(Empleados user, List<GrantedAuthority> roles){
		if (user == null){
			return null;
		}
		
		UsuarioDTO usuarioDTO = new UsuarioDTO(user.getIdempleados(), user.getNombre(), user.getApellido1(), user.getApellido2(), user.getPerfilesIdperfiles());
		usuarioDTO.setAuthorities(roles);
		
		return usuarioDTO;
	}
}
