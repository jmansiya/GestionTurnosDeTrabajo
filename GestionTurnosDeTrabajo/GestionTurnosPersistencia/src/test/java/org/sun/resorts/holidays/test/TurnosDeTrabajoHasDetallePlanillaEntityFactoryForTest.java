package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.jpa.TurnosDeTrabajoHasDetallePlanillaEntity;

public class TurnosDeTrabajoHasDetallePlanillaEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public TurnosDeTrabajoHasDetallePlanillaEntity newTurnosDeTrabajoHasDetallePlanillaEntity() {

		Integer turnosDeTrabajoIdturnosDeTrabajo = mockValues.nextInteger();
		Integer detallePlanillaIdDetalle = mockValues.nextInteger();

		TurnosDeTrabajoHasDetallePlanillaEntity turnosDeTrabajoHasDetallePlanillaEntity = new TurnosDeTrabajoHasDetallePlanillaEntity();
		turnosDeTrabajoHasDetallePlanillaEntity.setTurnosDeTrabajoIdturnosDeTrabajo(turnosDeTrabajoIdturnosDeTrabajo);
		turnosDeTrabajoHasDetallePlanillaEntity.setDetallePlanillaIdDetalle(detallePlanillaIdDetalle);
		return turnosDeTrabajoHasDetallePlanillaEntity;
	}
	
}
