package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.jpa.UsuariosEntity;

public class UsuariosEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public UsuariosEntity newUsuariosEntity() {

		Integer idusuarios = mockValues.nextInteger();

		UsuariosEntity usuariosEntity = new UsuariosEntity();
		usuariosEntity.setIdusuarios(idusuarios);
		return usuariosEntity;
	}
	
}
