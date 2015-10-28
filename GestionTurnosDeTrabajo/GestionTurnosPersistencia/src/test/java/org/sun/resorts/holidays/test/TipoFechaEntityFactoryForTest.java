package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.jpa.TipoFechaEntity;

public class TipoFechaEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public TipoFechaEntity newTipoFechaEntity() {

		Integer idtipoFecha = mockValues.nextInteger();

		TipoFechaEntity tipoFechaEntity = new TipoFechaEntity();
		tipoFechaEntity.setIdtipoFecha(idtipoFecha);
		return tipoFechaEntity;
	}
	
}
