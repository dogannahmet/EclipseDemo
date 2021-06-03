package com.javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacamp.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer>  {
	VerificationCode findById(int id);
}
