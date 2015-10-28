package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.jpa.VolumenTrabajoEspecialEntity;

public class VolumenTrabajoEspecialEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public VolumenTrabajoEspecialEntity newVolumenTrabajoEspecialEntity() {

		Integer idvolumen = mockValues.nextInteger();

		VolumenTrabajoEspecialEntity volumenTrabajoEspecialEntity = new VolumenTrabajoEspecialEntity();
		volumenTrabajoEspecialEntity.setIdvolumen(idvolumen);
		return volumenTrabajoEspecialEntity;
	}
	
}
