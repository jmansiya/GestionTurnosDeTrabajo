package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.Usuarios;

public class UsuariosFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Usuarios newUsuarios() {

		Integer idusuarios = mockValues.nextInteger();

		Usuarios usuarios = new Usuarios();
		usuarios.setIdusuarios(idusuarios);
		return usuarios;
	}
	
}
