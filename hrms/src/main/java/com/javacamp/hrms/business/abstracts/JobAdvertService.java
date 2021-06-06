package com.javacamp.hrms.business.abstracts;

import java.util.List;

import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	
	DataResult<List<JobAdvert>> getAll();
	DataResult<JobAdvert> findById(int id);
	DataResult<List<JobAdvert>> findByIsOpenTrue();
	DataResult<List<JobAdvert>> findByReleaseDate();
	DataResult<List<JobAdvert>> findByEmployerId(int employerId);
	
	Result setValueJobAdvert(int id);
		
	Result add(JobAdvert jobAdvert);
}
