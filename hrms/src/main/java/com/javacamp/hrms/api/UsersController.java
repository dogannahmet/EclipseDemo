package com.javacamp.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacamp.hrms.business.abstracts.UserService;
import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<User>> getAll(){
		return this.userService.getAll();
	}
	
	@GetMapping("/add")
	public Result add(@RequestBody User user) {
		return this.userService.add(user);
	}
	
}
