package com.javacamp.hrms.core.utilities.concretes;

import org.springframework.stereotype.Service;

import com.javacamp.hrms.core.utilities.abstracts.EmailService;
import com.javacamp.hrms.emailService.EmailManager;

@Service
public class EmailManagerAdapter implements EmailService{

	EmailManager emailManager = new EmailManager();
	
	@Override
	public void hrmsSendEmail(String email) {
		emailManager.sendEmail(email);
		
	}

}
