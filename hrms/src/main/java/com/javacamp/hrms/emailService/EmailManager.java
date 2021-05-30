package com.javacamp.hrms.emailService;

import org.springframework.stereotype.Service;

@Service
public class EmailManager {
	public void sendEmail(String email) {
		System.out.println(email + " " + "adresine doğrulama kodu gönderildi.");
	}
}
