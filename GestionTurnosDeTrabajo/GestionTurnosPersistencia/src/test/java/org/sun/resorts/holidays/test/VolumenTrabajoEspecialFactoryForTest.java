package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.VolumenTrabajoEspecial;

public class VolumenTrabajoEspecialFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public VolumenTrabajoEspecial newVolumenTrabajoEspecial() {

		Integer idvolumen = mockValues.nextInteger();

		VolumenTrabajoEspecial volumenTrabajoEspecial = new VolumenTrabajoEspecial();
		volumenTrabajoEspecial.setIdvolumen(idvolumen);
		return volumenTrabajoEspecial;
	}
	
}
