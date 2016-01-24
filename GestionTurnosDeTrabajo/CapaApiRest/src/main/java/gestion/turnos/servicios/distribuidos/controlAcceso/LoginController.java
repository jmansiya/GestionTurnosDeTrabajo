package gestion.turnos.servicios.distribuidos.controlAcceso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gestion.turnos.aplicacion.controlAcceso.ControlAcceso;
import gestion.turnos.aplicacion.fachada.dto.UsuarioDTO;

/**
 * 
 * @author JoseMansilla
 * Clase que nos servirá para controlar las peticiones de acceso a nuestra aplicación de
 * gestión de turnos de trabajo de la cadena hotelera.
 * 
 */

@RestController
@RequestMapping(value="/SunHolidaysAPI")
public class LoginController {
	
	@Autowired
	private ControlAcceso controlAcceso;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public @ResponseBody UsuarioDTO login(@PathVariable final String name, @PathVariable final String pass){
		if(name == null || name.equals("")) return null;
		if(pass == null || pass.equals("")) return null;
		System.out.println("HOLA");
		return controlAcceso.comprobarUsuario(name, pass);
	}
}
