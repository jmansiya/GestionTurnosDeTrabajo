package gestion.turnos.aplicacion.trabajador.impl;

import org.springframework.stereotype.Service;

import gestion.turnos.aplicacion.dataTransferObjects.TrabajadorDTO;
import gestion.turnos.aplicacion.trabajador.IgestionAplicacionTrabajadores;

@Service
public class gestionTrabajadorImpl implements IgestionAplicacionTrabajadores{

	@Override
	public TrabajadorDTO getTrabajador(Long idTrabajador) {
		// TODO Auto-generated method stub
		TrabajadorDTO trabajador = new TrabajadorDTO();
		trabajador.setApellido1("Mansilla");
		trabajador.setApellido2("García-Gil");
		trabajador.setNombre("Jose");
		
		return trabajador;
	}

}
