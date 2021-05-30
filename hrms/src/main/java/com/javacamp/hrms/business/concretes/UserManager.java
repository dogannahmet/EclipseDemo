package com.javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacamp.hrms.business.abstracts.UserService;
import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.core.utilities.results.SuccessDataResult;
import com.javacamp.hrms.core.utilities.results.SuccessResult;
import com.javacamp.hrms.dataAccess.abstracts.UserDao;
import com.javacamp.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{

	UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>
		(this.userDao.findAll());
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kayıt eklendi");
	}

}
