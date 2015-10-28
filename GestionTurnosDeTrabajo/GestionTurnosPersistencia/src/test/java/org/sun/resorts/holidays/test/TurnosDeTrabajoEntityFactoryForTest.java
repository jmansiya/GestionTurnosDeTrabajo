package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.jpa.TurnosDeTrabajoEntity;

public class TurnosDeTrabajoEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public TurnosDeTrabajoEntity newTurnosDeTrabajoEntity() {

		Integer idturnosDeTrabajo = mockValues.nextInteger();

		TurnosDeTrabajoEntity turnosDeTrabajoEntity = new TurnosDeTrabajoEntity();
		turnosDeTrabajoEntity.setIdturnosDeTrabajo(idturnosDeTrabajo);
		return turnosDeTrabajoEntity;
	}
	
}
