package com.javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacamp.hrms.business.abstracts.CandidateService;
import com.javacamp.hrms.core.utilities.abstracts.CheckEmailService;
import com.javacamp.hrms.core.utilities.abstracts.MernisService;
import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.ErrorResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.core.utilities.results.SuccessDataResult;
import com.javacamp.hrms.core.utilities.results.SuccessResult;
import com.javacamp.hrms.dataAccess.abstracts.CandidateDao;
import com.javacamp.hrms.entities.concretes.Candidate;

@Service 
public class CandidateManager implements CandidateService {

	CandidateDao candidateDao;
	MernisService mernisService;
	CheckEmailService checkEmailService;
	
		
	@Autowired
	public CandidateManager(CandidateDao candidateDao, MernisService mernisService,
			CheckEmailService checkEmailService) {
		super();
		this.candidateDao = candidateDao;
		this.mernisService = mernisService;
		this.checkEmailService = checkEmailService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findAll(), "Data listelendi.");
	}

	@Override
	public Result add(Candidate candidate) {
				
		if (!this.mernisService.checkIfRealPerson(candidate.getIdentityNumber())) {
			return new ErrorResult("Kimlik numaranız 11 haneli olmalıdır.");
		}
		
		return new SuccessResult("Eklendi");
		
	}
	
}
