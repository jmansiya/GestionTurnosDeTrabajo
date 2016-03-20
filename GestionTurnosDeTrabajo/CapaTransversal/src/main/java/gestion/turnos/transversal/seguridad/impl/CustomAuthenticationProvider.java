package gestion.turnos.transversal.seguridad.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.sun.resorts.holidays.model.Empleados;
import org.sun.resorts.holidays.model.Perfiles;
import org.sun.resorts.holidays.model.Usuarios;
import org.sun.resorts.holidays.persistence.service.EmpleadosService;
import org.sun.resorts.holidays.persistence.service.PerfilesService;
import org.sun.resorts.holidays.persistence.service.UsuariosService;

import gestion.turnos.transversal.seguridad.dto.UsuarioDTO;
import gestion.turnos.transversal.seguridad.dto.assambler.UsuarioDTOAssambler;


public class CustomAuthenticationProvider implements AuthenticationProvider, Serializable {
 
	@Autowired
	private UsuariosService servicioUsuarioPersistence;
	
	@Autowired
	private EmpleadosService servicioEmpleadosPersistence;
	
	@Autowired
	private PerfilesService servicioPerfiles;
	
	
	public UsuarioDTO comprobarUsuario(String nombre, String password) {
		// TODO Auto-generated method stub
		UsuarioDTO user = null;
		
		Usuarios userBBDD = servicioUsuarioPersistence.findByNameAndPassword(nombre, password);
		if (userBBDD != null){
			Empleados empleado = servicioEmpleadosPersistence.findById(userBBDD.getEmpleadosIdempleados());
			
			if(empleado != null){
				List<GrantedAuthority> authoroties = new ArrayList<GrantedAuthority>();
				Perfiles perfilesPersona = servicioPerfiles.findById(empleado.getPerfilesIdperfiles());
				GrantedAuthority role = new SimpleGrantedAuthority(perfilesPersona.getDescripcion());
				authoroties.add(role);

				user = UsuarioDTOAssambler.toDTO(empleado, authoroties);
				user.setCredenciales(password);
				System.out.println("Empleado obtenido : " + user.toString());

			}
		}
		
		return user;
	}

	
	public Authentication authenticate(Authentication arg0) throws AuthenticationException {
        UsuarioDTO usuarioDTO = null;
        UsernamePasswordAuthenticationToken usuario = null;
        
		try {
			usuario = (UsernamePasswordAuthenticationToken) arg0;
			usuarioDTO = comprobarUsuario((String) usuario.getPrincipal(), (String) usuario.getCredentials());
			
			if (usuarioDTO == null) {
				throw new BadCredentialsException("Error el usuario no existe en el sistema.");
			}
			
			usuario = new UsernamePasswordAuthenticationToken(usuarioDTO, usuario.getCredentials(), usuarioDTO.getAuthorities());
        }catch (Exception e) {
        	throw new BadCredentialsException("Error el usuario no existe en el sistema.", e);
		}

        return usuario;
	}

    public boolean supports(Class<? extends Object> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}