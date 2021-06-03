package com.javacamp.hrms.core.utilities.concretes;

import org.springframework.stereotype.Service;

import com.javacamp.hrms.core.utilities.helpers.ValidationService;

import FakeMernisService.FakeMernisService;

@Service
public class MernisServiceAdapter implements ValidationService {

	@Override
	public boolean checkIfRealPerson(long identityNumber, String firstName, String lastName, String birthYear) {
		FakeMernisService client = new FakeMernisService();
		
		boolean result = true;
		
		try {
			result = client.ValidatePersonal(identityNumber, firstName, lastName, birthYear);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

}
