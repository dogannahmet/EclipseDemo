package com.javacamp.hrms.core.utilities.concretes;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.javacamp.hrms.core.utilities.abstracts.CheckEmailService;

@Service
public class CheckEmailManager implements CheckEmailService {

	private static String EMAIL_PATTERN = 
			"^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
	
	@Override
	public boolean CheckEmail(String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(email).find();
	}

}
