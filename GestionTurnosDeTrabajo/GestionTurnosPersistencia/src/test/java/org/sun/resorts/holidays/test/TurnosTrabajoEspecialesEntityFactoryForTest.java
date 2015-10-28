package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.jpa.TurnosTrabajoEspecialesEntity;

public class TurnosTrabajoEspecialesEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public TurnosTrabajoEspecialesEntity newTurnosTrabajoEspecialesEntity() {

		Integer empleadosIdempleados = mockValues.nextInteger();
		Integer turnosDeTrabajoIdturnosDeTrabajo = mockValues.nextInteger();

		TurnosTrabajoEspecialesEntity turnosTrabajoEspecialesEntity = new TurnosTrabajoEspecialesEntity();
		turnosTrabajoEspecialesEntity.setEmpleadosIdempleados(empleadosIdempleados);
		turnosTrabajoEspecialesEntity.setTurnosDeTrabajoIdturnosDeTrabajo(turnosDeTrabajoIdturnosDeTrabajo);
		return turnosTrabajoEspecialesEntity;
	}
	
}
