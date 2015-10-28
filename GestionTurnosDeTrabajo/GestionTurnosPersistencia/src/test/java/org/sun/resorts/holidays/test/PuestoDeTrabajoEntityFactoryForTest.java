package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.jpa.PuestoDeTrabajoEntity;

public class PuestoDeTrabajoEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public PuestoDeTrabajoEntity newPuestoDeTrabajoEntity() {

		Integer idpuestoDeTrabajo = mockValues.nextInteger();

		PuestoDeTrabajoEntity puestoDeTrabajoEntity = new PuestoDeTrabajoEntity();
		puestoDeTrabajoEntity.setIdpuestoDeTrabajo(idpuestoDeTrabajo);
		return puestoDeTrabajoEntity;
	}
	
}
