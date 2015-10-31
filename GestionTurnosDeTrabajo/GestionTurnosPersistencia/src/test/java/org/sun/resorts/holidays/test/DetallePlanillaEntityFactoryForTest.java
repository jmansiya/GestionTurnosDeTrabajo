package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.jpa.DetallePlanillaEntity;

public class DetallePlanillaEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public DetallePlanillaEntity newDetallePlanillaEntity() {

		Integer idDetalle = mockValues.nextInteger();

		DetallePlanillaEntity detallePlanillaEntity = new DetallePlanillaEntity();
		detallePlanillaEntity.setIdDetalle(idDetalle);
		return detallePlanillaEntity;
	}
	
}
