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

import com.javacamp.hrms.business.abstracts.JobPositionService;
import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobtitles")
public class JobPositionsController {
	
	private JobPositionService jobTitleService;

	@Autowired
	public JobPositionsController(JobPositionService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return this.jobTitleService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobPosition jobPosition) {
		return ResponseEntity.ok(this.jobTitleService.add(jobPosition));
	}
	
}
