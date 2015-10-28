package org.sun.resorts.holidays.test;

import org.sun.resorts.holidays.model.jpa.PerfilesEntity;

public class PerfilesEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public PerfilesEntity newPerfilesEntity() {

		Integer idperfiles = mockValues.nextInteger();

		PerfilesEntity perfilesEntity = new PerfilesEntity();
		perfilesEntity.setIdperfiles(idperfiles);
		return perfilesEntity;
	}
	
}
