package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.jpa.VacacionesEntity;

public class VacacionesEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public VacacionesEntity newVacacionesEntity() {

		Integer idvacaciones = mockValues.nextInteger();

		VacacionesEntity vacacionesEntity = new VacacionesEntity();
		vacacionesEntity.setIdvacaciones(idvacaciones);
		return vacacionesEntity;
	}
	
}
