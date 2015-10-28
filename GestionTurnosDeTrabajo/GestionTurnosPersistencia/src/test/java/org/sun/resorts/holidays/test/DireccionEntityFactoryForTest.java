package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.jpa.DireccionEntity;

public class DireccionEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public DireccionEntity newDireccionEntity() {

		Integer iddireccion = mockValues.nextInteger();

		DireccionEntity direccionEntity = new DireccionEntity();
		direccionEntity.setIddireccion(iddireccion);
		return direccionEntity;
	}
	
}
