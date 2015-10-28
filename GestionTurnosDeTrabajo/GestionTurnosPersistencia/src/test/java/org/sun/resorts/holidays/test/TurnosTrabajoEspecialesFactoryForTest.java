package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.TurnosTrabajoEspeciales;

public class TurnosTrabajoEspecialesFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public TurnosTrabajoEspeciales newTurnosTrabajoEspeciales() {

		Integer empleadosIdempleados = mockValues.nextInteger();
		Integer turnosDeTrabajoIdturnosDeTrabajo = mockValues.nextInteger();

		TurnosTrabajoEspeciales turnosTrabajoEspeciales = new TurnosTrabajoEspeciales();
		turnosTrabajoEspeciales.setEmpleadosIdempleados(empleadosIdempleados);
		turnosTrabajoEspeciales.setTurnosDeTrabajoIdturnosDeTrabajo(turnosDeTrabajoIdturnosDeTrabajo);
		return turnosTrabajoEspeciales;
	}
	
}
