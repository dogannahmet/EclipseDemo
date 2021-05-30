package com.javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacamp.hrms.business.abstracts.JobTitleService;
import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.core.utilities.results.SuccessDataResult;
import com.javacamp.hrms.core.utilities.results.SuccessResult;
import com.javacamp.hrms.dataAccess.abstracts.JobTitleDao;
import com.javacamp.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;
	
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}



	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>
		(this.jobTitleDao.findAll(),"Data listelendi.");
	
	}



	@Override
	public Result add(JobTitle jobTitle) {
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("İş pozisyonu eklendi.");
	}

}
