package com.javacamp.hrms.fakeMernis;

import org.springframework.stereotype.Service;

@Service
public class FakeMernisService {
	public boolean check(String identityNumber, String firstName, String lastName, int birth_year ) {
		System.out.println(firstName + "" + lastName + " gerçek kişidir.");
		return true;
	} 

}

