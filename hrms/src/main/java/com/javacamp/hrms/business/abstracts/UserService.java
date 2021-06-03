package com.javacamp.hrms.business.abstracts;

import java.util.List;

import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.entities.concretes.User;

public interface UserService {
	DataResult<List<User>> getAll();
	DataResult<User> findByEmail(String email);
			
	Result add(User user);
	
		
}
