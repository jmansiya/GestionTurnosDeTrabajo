package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.PuestoDeTrabajo;

public class PuestoDeTrabajoFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public PuestoDeTrabajo newPuestoDeTrabajo() {

		Integer idpuestoDeTrabajo = mockValues.nextInteger();

		PuestoDeTrabajo puestoDeTrabajo = new PuestoDeTrabajo();
		puestoDeTrabajo.setIdpuestoDeTrabajo(idpuestoDeTrabajo);
		return puestoDeTrabajo;
	}
	
}
