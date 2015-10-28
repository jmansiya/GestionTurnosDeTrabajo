package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.Empleados;

public class EmpleadosFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Empleados newEmpleados() {

		Integer idempleados = mockValues.nextInteger();

		Empleados empleados = new Empleados();
		empleados.setIdempleados(idempleados);
		return empleados;
	}
	
}
