package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.TurnosDeTrabajo;

public class TurnosDeTrabajoFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public TurnosDeTrabajo newTurnosDeTrabajo() {

		Integer idturnosDeTrabajo = mockValues.nextInteger();

		TurnosDeTrabajo turnosDeTrabajo = new TurnosDeTrabajo();
		turnosDeTrabajo.setIdturnosDeTrabajo(idturnosDeTrabajo);
		return turnosDeTrabajo;
	}
	
}
