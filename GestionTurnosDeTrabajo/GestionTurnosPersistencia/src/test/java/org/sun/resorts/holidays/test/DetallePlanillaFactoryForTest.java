package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.DetallePlanilla;

public class DetallePlanillaFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public DetallePlanilla newDetallePlanilla() {

		Integer iddetallePlanilla = mockValues.nextInteger();

		DetallePlanilla detallePlanilla = new DetallePlanilla();
		detallePlanilla.setIddetallePlanilla(iddetallePlanilla);
		return detallePlanilla;
	}
	
}
