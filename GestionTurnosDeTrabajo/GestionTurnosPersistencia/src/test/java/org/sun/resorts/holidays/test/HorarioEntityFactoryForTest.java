package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.jpa.HorarioEntity;

public class HorarioEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public HorarioEntity newHorarioEntity() {

		Integer idhorario = mockValues.nextInteger();

		HorarioEntity horarioEntity = new HorarioEntity();
		horarioEntity.setIdhorario(idhorario);
		return horarioEntity;
	}
	
}
