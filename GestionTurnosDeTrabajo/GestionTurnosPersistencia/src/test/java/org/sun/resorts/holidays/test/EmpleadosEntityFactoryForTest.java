package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.jpa.EmpleadosEntity;

public class EmpleadosEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public EmpleadosEntity newEmpleadosEntity() {

		Integer idempleados = mockValues.nextInteger();

		EmpleadosEntity empleadosEntity = new EmpleadosEntity();
		empleadosEntity.setIdempleados(idempleados);
		return empleadosEntity;
	}
	
}
