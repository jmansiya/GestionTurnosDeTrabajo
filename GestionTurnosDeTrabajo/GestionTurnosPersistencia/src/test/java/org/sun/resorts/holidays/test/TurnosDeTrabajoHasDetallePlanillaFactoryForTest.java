package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.TurnosDeTrabajoHasDetallePlanilla;

public class TurnosDeTrabajoHasDetallePlanillaFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public TurnosDeTrabajoHasDetallePlanilla newTurnosDeTrabajoHasDetallePlanilla() {

		Integer turnosDeTrabajoIdturnosDeTrabajo = mockValues.nextInteger();
		Integer detallePlanillaIdDetalle = mockValues.nextInteger();

		TurnosDeTrabajoHasDetallePlanilla turnosDeTrabajoHasDetallePlanilla = new TurnosDeTrabajoHasDetallePlanilla();
		turnosDeTrabajoHasDetallePlanilla.setTurnosDeTrabajoIdturnosDeTrabajo(turnosDeTrabajoIdturnosDeTrabajo);
		turnosDeTrabajoHasDetallePlanilla.setDetallePlanillaIdDetalle(detallePlanillaIdDetalle);
		return turnosDeTrabajoHasDetallePlanilla;
	}
	
}
