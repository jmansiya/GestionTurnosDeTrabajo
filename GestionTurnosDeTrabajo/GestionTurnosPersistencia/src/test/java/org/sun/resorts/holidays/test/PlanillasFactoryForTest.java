package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.Planillas;

public class PlanillasFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Planillas newPlanillas() {

		Integer idplanillas = mockValues.nextInteger();

		Planillas planillas = new Planillas();
		planillas.setIdplanillas(idplanillas);
		return planillas;
	}
	
}
