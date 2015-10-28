package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.Horario;

public class HorarioFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Horario newHorario() {

		Integer idhorario = mockValues.nextInteger();

		Horario horario = new Horario();
		horario.setIdhorario(idhorario);
		return horario;
	}
	
}
