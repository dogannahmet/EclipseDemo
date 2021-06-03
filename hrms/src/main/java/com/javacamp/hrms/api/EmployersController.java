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

import com.javacamp.hrms.business.abstracts.EmployerService;
import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Employer employer) {
		return ResponseEntity.ok(this.employerService.add(employer));
	}
	
	@PostMapping("/findByEmail")
	public ResponseEntity<?> findByEmail(String email){
		return ResponseEntity.ok(this.employerService.findByEmail(email));
	}
	
}
