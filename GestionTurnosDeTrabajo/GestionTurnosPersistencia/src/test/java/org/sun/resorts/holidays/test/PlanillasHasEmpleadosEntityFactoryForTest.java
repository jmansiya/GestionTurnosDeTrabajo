package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.jpa.PlanillasHasEmpleadosEntity;

public class PlanillasHasEmpleadosEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public PlanillasHasEmpleadosEntity newPlanillasHasEmpleadosEntity() {

		Integer planillasIdplanillas = mockValues.nextInteger();
		Integer empleadosIdempleados = mockValues.nextInteger();

		PlanillasHasEmpleadosEntity planillasHasEmpleadosEntity = new PlanillasHasEmpleadosEntity();
		planillasHasEmpleadosEntity.setPlanillasIdplanillas(planillasIdplanillas);
		planillasHasEmpleadosEntity.setEmpleadosIdempleados(empleadosIdempleados);
		return planillasHasEmpleadosEntity;
	}
	
}
