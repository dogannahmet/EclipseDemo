package com.javacamp.hrms.business.abstracts;

import java.util.List;

import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.entities.concretes.Candidate;


public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> findByEmail(String email);
	DataResult<Candidate> findByIdentityNumber(String identityNumber);
	
	Result add(Candidate candidate);
	
}
