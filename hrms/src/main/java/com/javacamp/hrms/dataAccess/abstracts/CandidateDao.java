package com.javacamp.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.javacamp.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	Candidate findByIdentityNumber(String identityNumber);
	Candidate findByEmail(String email);
	
}
