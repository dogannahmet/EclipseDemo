package com.javacamp.hrms.business.abstracts;

import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	Result add(VerificationCode verificationCode);
	
	DataResult<VerificationCode> findByCode(String code);
}
