package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.jpa.DetallePlanillaHasEmpleadosEntity;

public class DetallePlanillaHasEmpleadosEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public DetallePlanillaHasEmpleadosEntity newDetallePlanillaHasEmpleadosEntity() {

		Integer detallePlanillaIdDetalle = mockValues.nextInteger();
		Integer empleadosIdempleados = mockValues.nextInteger();

		DetallePlanillaHasEmpleadosEntity detallePlanillaHasEmpleadosEntity = new DetallePlanillaHasEmpleadosEntity();
		detallePlanillaHasEmpleadosEntity.setDetallePlanillaIdDetalle(detallePlanillaIdDetalle);
		detallePlanillaHasEmpleadosEntity.setEmpleadosIdempleados(empleadosIdempleados);
		return detallePlanillaHasEmpleadosEntity;
	}
	
}
