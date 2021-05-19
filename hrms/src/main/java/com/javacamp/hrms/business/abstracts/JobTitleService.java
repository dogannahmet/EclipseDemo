package com.javacamp.hrms.business.abstracts;

import java.util.List;

import com.javacamp.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	List<JobTitle> getAll();
}
