package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.PlanillasHasEmpleados;

public class PlanillasHasEmpleadosFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public PlanillasHasEmpleados newPlanillasHasEmpleados() {

		Integer planillasIdplanillas = mockValues.nextInteger();
		Integer empleadosIdempleados = mockValues.nextInteger();

		PlanillasHasEmpleados planillasHasEmpleados = new PlanillasHasEmpleados();
		planillasHasEmpleados.setPlanillasIdplanillas(planillasIdplanillas);
		planillasHasEmpleados.setEmpleadosIdempleados(empleadosIdempleados);
		return planillasHasEmpleados;
	}
	
}
