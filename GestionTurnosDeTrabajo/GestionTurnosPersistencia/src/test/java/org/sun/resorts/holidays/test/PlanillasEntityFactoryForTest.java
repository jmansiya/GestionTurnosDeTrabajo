package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.jpa.PlanillasEntity;

public class PlanillasEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public PlanillasEntity newPlanillasEntity() {

		Integer idplanillas = mockValues.nextInteger();

		PlanillasEntity planillasEntity = new PlanillasEntity();
		planillasEntity.setIdplanillas(idplanillas);
		return planillasEntity;
	}
	
}
