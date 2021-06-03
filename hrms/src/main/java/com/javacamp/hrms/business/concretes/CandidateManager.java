package com.javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacamp.hrms.business.abstracts.CandidateService;
import com.javacamp.hrms.business.abstracts.VerificationCodeService;
import com.javacamp.hrms.core.utilities.helpers.CodeGenerator;
import com.javacamp.hrms.core.utilities.helpers.ValidationService;
import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.ErrorDataResult;
import com.javacamp.hrms.core.utilities.results.ErrorResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.core.utilities.results.SuccessDataResult;
import com.javacamp.hrms.core.utilities.results.SuccessResult;
import com.javacamp.hrms.dataAccess.abstracts.CandidateDao;
import com.javacamp.hrms.entities.concretes.Candidate;
import com.javacamp.hrms.entities.concretes.VerificationCode;

@Service 
public class CandidateManager implements CandidateService {
		
	
	private CandidateDao candidateDao;
	private VerificationCodeService verificationCodeService;
	private ValidationService validationService;
	private CodeGenerator codeGenerator;
		
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,
			VerificationCodeService verificationCodeService, ValidationService validationService,
			CodeGenerator codeGenerator) {
		
		super();
		this.candidateDao = candidateDao;
		this.verificationCodeService = verificationCodeService;
		this.validationService = validationService;
		this.codeGenerator = codeGenerator;
		
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findAll());
	}
	
	@Override
	public DataResult<Candidate> findByEmail(String email) {
		return new SuccessDataResult<Candidate>
		(this.candidateDao.findByEmail(email));
	}
	
	@Override
	public DataResult<Candidate> findByIdentityNumber(String identityNumber) {
		return new ErrorDataResult<Candidate>
		(this.candidateDao.findByIdentityNumber(identityNumber));
	}

	@Override
	public Result add(Candidate candidate) {
		if (checkIfMernis(Long.parseLong(candidate.getIdentityNumber()), candidate.getFirstName(),
				
			candidate.getLastName(), candidate.getBirthYear()) == false) {
				
			return new ErrorResult("Bilgilerinizi kontrol ediniz.");
		}
		if (findByIdentityNumber(candidate.getIdentityNumber()).getData() != null) {

			return new ErrorResult(candidate.getIdentityNumber() + " sistemde kayıtlı!..");
		}
		if (findByEmail(candidate.getEmail()).getData() != null) {
			return new ErrorResult(candidate.getEmail() + " sistemde kayıtlı!..");
		}
		
		candidate.setVerified(true);
		this.candidateDao.save(candidate);
		String candidateCode = this.codeGenerator.CodeGenerate();
		verificationCodeRecord(candidateCode, candidate.getId(), candidate.getEmail());
		return new SuccessResult("Kayıt işlemi başarılı.");
	}
	
	private boolean checkIfMernis(long identityNumber, String firstName, String lastName, String birthYear) {

		if (validationService.checkIfRealPerson(identityNumber, firstName, lastName, birthYear)) {
			return true;
		}
		return false;
	}
	
	
	private void verificationCodeRecord(String code, int id, String email) {
		
		VerificationCode verificationCode = new VerificationCode(id, code, false);
		this.verificationCodeService.add(verificationCode);
		System.out.println(email + " adresine doğrulama kodu gönderildi" );
	
	}

}
