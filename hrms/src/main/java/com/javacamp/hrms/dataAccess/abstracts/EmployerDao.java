package com.javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacamp.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	Employer findByCompanyName(String companyName);
	Employer findByEmail(String email);
}
