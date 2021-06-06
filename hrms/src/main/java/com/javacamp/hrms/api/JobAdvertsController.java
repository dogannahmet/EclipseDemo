package com.javacamp.hrms.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacamp.hrms.business.abstracts.JobAdvertService;
import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobAdverts")
public class JobAdvertsController {

	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvert>> getAll(){
		return this.jobAdvertService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvert jobAdvert){
		return ResponseEntity.ok(jobAdvertService.add(jobAdvert));
	}
	
	@GetMapping("/findByIsOpenTrue")
	public DataResult<List<JobAdvert>> findByIsOpenTrue() {
		return this.jobAdvertService.findByIsOpenTrue();
	}
	
	@GetMapping("/findByEmployerId")
	public DataResult<List<JobAdvert>> findByEmployerId(int employerId){
		return this.jobAdvertService.findByEmployerId(employerId);
	}
	
	@GetMapping("/findByReleaseDate")
	public DataResult<List<JobAdvert>> findByReleaseDate(){
		return this.jobAdvertService.findByReleaseDate();
	}
	
	@GetMapping("/setValueJobAdvert")
	public Result setValueJobAdvert(int id) {
		return this.jobAdvertService.setValueJobAdvert(id);
	}
	
}
