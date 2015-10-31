package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.DetallePlanillaHasEmpleados;

public class DetallePlanillaHasEmpleadosFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public DetallePlanillaHasEmpleados newDetallePlanillaHasEmpleados() {

		Integer detallePlanillaIdDetalle = mockValues.nextInteger();
		Integer empleadosIdempleados = mockValues.nextInteger();

		DetallePlanillaHasEmpleados detallePlanillaHasEmpleados = new DetallePlanillaHasEmpleados();
		detallePlanillaHasEmpleados.setDetallePlanillaIdDetalle(detallePlanillaIdDetalle);
		detallePlanillaHasEmpleados.setEmpleadosIdempleados(empleadosIdempleados);
		return detallePlanillaHasEmpleados;
	}
	
}
