package com.javacamp.hrms.core.utilities.concretes;

import org.springframework.stereotype.Service;

import com.javacamp.hrms.core.utilities.abstracts.MernisService;

@Service
public class FakeMernisManagerAdapter implements MernisService {

	@Override
	public boolean checkIfRealPerson(String identityNumber) {
		if (identityNumber.length() < 11)  {
			return false;
		}
		return true;
	}

	

}
