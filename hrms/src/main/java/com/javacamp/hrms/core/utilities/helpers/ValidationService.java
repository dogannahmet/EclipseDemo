package com.javacamp.hrms.core.utilities.helpers;

public interface ValidationService {
	
	boolean checkIfRealPerson(long identityNumber, String firstName, String lastName, String birthYear);
	
}
