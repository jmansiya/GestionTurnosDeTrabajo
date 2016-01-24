package test.gestion.turnos.servicios.distribuidos.capaAplicacion;

import org.springframework.stereotype.Service;

import gestion.turnos.aplicacion.controlAcceso.ControlAcceso;
import gestion.turnos.aplicacion.fachada.dto.UsuarioDTO;

@Service
public class testControlAcceso implements ControlAcceso{

	public UsuarioDTO comprobarUsuario(String nombre, String password) {
		// TODO Auto-generated method stub
		// TODO Poner este test debería estar en la capa de aplicación en el apartado de test.!!
		System.out.println("Estoy creando un controlAcceso para probar sin necesidad de ir mas abajo en las capas.");
		return new UsuarioDTO(1, "José", "Mansilla", "García-Gil", 1);
	}

}
