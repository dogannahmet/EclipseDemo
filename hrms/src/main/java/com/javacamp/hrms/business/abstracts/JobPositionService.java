package com.javacamp.hrms.business.abstracts;

import java.util.List;

import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();
	Result add(JobPosition jobTitle);
}
