package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.CentrosDeTrabajo;

public class CentrosDeTrabajoFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public CentrosDeTrabajo newCentrosDeTrabajo() {

		Integer idcentrosDeTrabajo = mockValues.nextInteger();

		CentrosDeTrabajo centrosDeTrabajo = new CentrosDeTrabajo();
		centrosDeTrabajo.setIdcentrosDeTrabajo(idcentrosDeTrabajo);
		return centrosDeTrabajo;
	}
	
}
