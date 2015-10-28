package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.Perfiles;

public class PerfilesFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Perfiles newPerfiles() {

		Integer idperfiles = mockValues.nextInteger();

		Perfiles perfiles = new Perfiles();
		perfiles.setIdperfiles(idperfiles);
		return perfiles;
	}
	
}
