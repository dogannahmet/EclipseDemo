package com.javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacamp.hrms.business.abstracts.EmployerService;
import com.javacamp.hrms.business.abstracts.VerificationCodeService;
import com.javacamp.hrms.core.utilities.helpers.CodeGenerator;
import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.ErrorResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.core.utilities.results.SuccessDataResult;
import com.javacamp.hrms.core.utilities.results.SuccessResult;
import com.javacamp.hrms.dataAccess.abstracts.EmployerDao;
import com.javacamp.hrms.entities.concretes.Employer;
import com.javacamp.hrms.entities.concretes.VerificationCode;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private VerificationCodeService verificationCodeService;
	private CodeGenerator codeGenerator;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, CodeGenerator codeGenerator,
			VerificationCodeService verificationCodeService) {
		super();
		this.employerDao = employerDao;
		this.verificationCodeService = verificationCodeService;
		this.codeGenerator = codeGenerator;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(), "İşveren kayıtları listelendi.");
	}

	@Override
	public DataResult<Employer> findByEmail(String email) {
		return new SuccessDataResult<Employer>
		(this.employerDao.findByEmail(email));
	}

	@Override
	public Result add(Employer employer) {
		if (findByEmail(employer.getEmail()).getData() != null) {
			return new ErrorResult(employer.getEmail() + " sistemde kayıtlı.");
		}
		
		if (!checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebAddress())) {
			return new ErrorResult("Uyumsuz mail ve domain adresi.");
		}
		
		employer.setVerified(true);
		this.employerDao.save(employer);
		String employerCode = this.codeGenerator.CodeGenerate();
		verificationCodeRecord(employerCode, employer.getId(), employer.getEmail());
		return new SuccessResult("Kayıt işlemi başarılı.");
	}
	
		
	private boolean checkIfEqualEmailAndDomain(String email, String website) {
		String[] emailAddress = email.split("@");
		String webAddress = website.substring(4,website.length());

		if (emailAddress[1].equals(webAddress)) {

			return true;
		}

		return false;
	}
	
	private void verificationCodeRecord(String code, int id, String email) {
		
		VerificationCode verificationCode = new VerificationCode(id, code);
		this.verificationCodeService.add(verificationCode);
		System.out.println(email + " adresine doğrulama kodu gönderildi" );
	
	}

}
