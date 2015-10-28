package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.Estados;

public class EstadosFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Estados newEstados() {

		Integer idestados = mockValues.nextInteger();

		Estados estados = new Estados();
		estados.setIdestados(idestados);
		return estados;
	}
	
}
