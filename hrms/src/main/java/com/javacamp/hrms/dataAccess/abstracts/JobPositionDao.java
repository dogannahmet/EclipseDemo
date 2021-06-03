package com.javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import com.javacamp.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	
}
