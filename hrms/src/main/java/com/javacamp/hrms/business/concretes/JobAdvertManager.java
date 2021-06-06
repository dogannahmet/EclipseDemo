package com.javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.javacamp.hrms.business.abstracts.JobAdvertService;
import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.ErrorResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.core.utilities.results.SuccessDataResult;
import com.javacamp.hrms.core.utilities.results.SuccessResult;
import com.javacamp.hrms.dataAccess.abstracts.JobAdvertDao;
import com.javacamp.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService{

	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}
	
	@Override
	public DataResult<JobAdvert> findById(int id) {
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.findById(id));
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.findAll(), "İş ilanları listelendi");
	}
	
	@Override
	public DataResult<List<JobAdvert>> findByIsOpenTrue() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.findByIsOpenTrue(), "Açık iş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvert>> findByEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.findByIsOpenTrueAndEmployerId(employerId), 
				"İşveren bilgisine göre listelendi.");
	}

	@Override
	public DataResult<List<JobAdvert>> findByReleaseDate() {
		Sort sort  = Sort.by(Sort.Direction.DESC, "deadline");
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.findAll(sort), "Tarih bilgisine göre listelendi.");
	}
	
	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş ilanı eklendi.");
	}

	@Override
	public Result setValueJobAdvert(int id) {
		return changeOpenToClose(id);
				
	}
	
	private Result changeOpenToClose(int id) {
		if (!findById(id).getData().isOpen()) {
			return new ErrorResult("İş pozisyonu zaten kapalı. İlan bilgisini kontrol ediniz.");
		}
		JobAdvert jobAdvert = findById(id).getData();
		jobAdvert.setOpen(false);
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş ilanı bilgisi güncellendi");
				
	}
}
