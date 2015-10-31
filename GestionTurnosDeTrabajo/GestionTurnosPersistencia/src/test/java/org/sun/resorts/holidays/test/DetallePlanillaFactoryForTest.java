package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.DetallePlanilla;

public class DetallePlanillaFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public DetallePlanilla newDetallePlanilla() {

		Integer idDetalle = mockValues.nextInteger();

		DetallePlanilla detallePlanilla = new DetallePlanilla();
		detallePlanilla.setIdDetalle(idDetalle);
		return detallePlanilla;
	}
	
}
