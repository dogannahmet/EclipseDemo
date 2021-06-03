package com.javacamp.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacamp.hrms.business.abstracts.VerificationCodeService;
import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.core.utilities.results.SuccessResult;
import com.javacamp.hrms.dataAccess.abstracts.VerificationCodeDao;
import com.javacamp.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService{

	private VerificationCodeDao verificationCodeDao;
	
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
		
	}

	@Override
	public Result add(VerificationCode code) {
		
		this.verificationCodeDao.save(code);
		return new SuccessResult("Kullanıcı kodu kaydedildi.");
	}

	@Override
	public DataResult<VerificationCode> findByCode(String code) {
		
		return null;
	}
}
