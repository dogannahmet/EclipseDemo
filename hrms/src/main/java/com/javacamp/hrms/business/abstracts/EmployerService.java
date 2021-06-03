package com.javacamp.hrms.business.abstracts;

import java.util.List;
import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	DataResult<Employer> findByEmail(String email);
	Result add(Employer employer);
}
