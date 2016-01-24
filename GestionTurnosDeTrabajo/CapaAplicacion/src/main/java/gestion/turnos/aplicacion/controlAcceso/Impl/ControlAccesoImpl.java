package gestion.turnos.aplicacion.controlAcceso.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sun.resorts.holidays.model.Empleados;
import org.sun.resorts.holidays.model.Usuarios;
import org.sun.resorts.holidays.persistence.service.EmpleadosService;
import org.sun.resorts.holidays.persistence.service.UsuariosService;

import gestion.turnos.aplicacion.controlAcceso.ControlAcceso;
import gestion.turnos.aplicacion.fachada.dto.UsuarioDTO;
import gestion.turnos.aplicacion.fachada.dto.assambler.UsuarioDTOAssambler;

@Service
public class ControlAccesoImpl implements ControlAcceso{

	@Autowired
	private UsuariosService servicioUsuarioPersistence;
	
	@Autowired
	private EmpleadosService servicioEmpleadosPersistence;
	
	
	public UsuarioDTO comprobarUsuario(String nombre, String password) {
		// TODO Auto-generated method stub
		UsuarioDTO user = null;
		
		System.out.println("Has llegado hasta la capa de aplicación del sistema. Enhorabuena!!!");
		Usuarios userBBDD = servicioUsuarioPersistence.findByNameAndPassword(nombre, password);
		if (userBBDD != null){
			Empleados empleado = servicioEmpleadosPersistence.findById(userBBDD.getEmpleadosIdempleados());
			
			user = UsuarioDTOAssambler.toDTO(empleado);
			
			System.out.println("Empleado obtenido : " + user.toString());
		}
		
		return user;
	}

}
