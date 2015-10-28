package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.Vacaciones;

public class VacacionesFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Vacaciones newVacaciones() {

		Integer idvacaciones = mockValues.nextInteger();

		Vacaciones vacaciones = new Vacaciones();
		vacaciones.setIdvacaciones(idvacaciones);
		return vacaciones;
	}
	
}
