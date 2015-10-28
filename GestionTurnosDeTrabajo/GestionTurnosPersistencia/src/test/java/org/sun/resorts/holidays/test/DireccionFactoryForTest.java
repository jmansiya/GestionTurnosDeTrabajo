package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.Direccion;

public class DireccionFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Direccion newDireccion() {

		Integer iddireccion = mockValues.nextInteger();

		Direccion direccion = new Direccion();
		direccion.setIddireccion(iddireccion);
		return direccion;
	}
	
}
