package gestion.turnos.servicios.distribuidos;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gestion.turnos.aplicacion.dataTransferObjects.TrabajadorDTO;
import gestion.turnos.aplicacion.trabajador.IgestionAplicacionTrabajadores;

@RestController
@RequestMapping(value="/SunHolidaysAPI")
public class TrabajadorController {
	@Resource
	private IgestionAplicacionTrabajadores aplicacionTrabajadoresService;
	
	@RequestMapping(value="/trabajador/{idTrabajador}", method= RequestMethod.GET)
	public TrabajadorDTO getInfoTrabajador(@PathVariable Long idTrabajador){
		return aplicacionTrabajadoresService.getTrabajador(idTrabajador);
	}
}
