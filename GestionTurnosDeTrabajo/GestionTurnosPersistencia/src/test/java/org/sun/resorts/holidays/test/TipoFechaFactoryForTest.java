package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.TipoFecha;

public class TipoFechaFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public TipoFecha newTipoFecha() {

		Integer idtipoFecha = mockValues.nextInteger();

		TipoFecha tipoFecha = new TipoFecha();
		tipoFecha.setIdtipoFecha(idtipoFecha);
		return tipoFecha;
	}
	
}
