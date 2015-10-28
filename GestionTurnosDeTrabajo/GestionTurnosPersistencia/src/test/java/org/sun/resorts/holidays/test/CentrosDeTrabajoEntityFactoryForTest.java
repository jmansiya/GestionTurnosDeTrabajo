package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.jpa.CentrosDeTrabajoEntity;

public class CentrosDeTrabajoEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public CentrosDeTrabajoEntity newCentrosDeTrabajoEntity() {

		Integer idcentrosDeTrabajo = mockValues.nextInteger();

		CentrosDeTrabajoEntity centrosDeTrabajoEntity = new CentrosDeTrabajoEntity();
		centrosDeTrabajoEntity.setIdcentrosDeTrabajo(idcentrosDeTrabajo);
		return centrosDeTrabajoEntity;
	}
	
}
