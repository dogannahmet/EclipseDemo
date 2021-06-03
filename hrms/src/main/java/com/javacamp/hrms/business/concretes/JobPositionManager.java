package com.javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacamp.hrms.business.abstracts.JobPositionService;
import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.core.utilities.results.SuccessDataResult;
import com.javacamp.hrms.core.utilities.results.SuccessResult;
import com.javacamp.hrms.dataAccess.abstracts.JobPositionDao;
import com.javacamp.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositionDao.findAll(),"Data listelendi.");
	
	}

	@Override
	public Result add(JobPosition jobTitle) {
		this.jobPositionDao.save(jobTitle);
		return new SuccessResult("İş pozisyonu eklendi.");
	}

}
