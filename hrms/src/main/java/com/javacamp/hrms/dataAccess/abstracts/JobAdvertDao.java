package com.javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javacamp.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {

	@Query("From JobAdvert where isOpen = true")
	List<JobAdvert> findByIsOpenTrue();
	
	List<JobAdvert> findByIsOpenTrueAndEmployerId(int employerId);
	
	JobAdvert findById(int id);	
}
