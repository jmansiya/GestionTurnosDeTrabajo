package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.jpa.EstadosEntity;

public class EstadosEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public EstadosEntity newEstadosEntity() {

		Integer idestados = mockValues.nextInteger();

		EstadosEntity estadosEntity = new EstadosEntity();
		estadosEntity.setIdestados(idestados);
		return estadosEntity;
	}
	
}
