package com.hitema.devops.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hitema.devops.dao.UserDAO;
import com.hitema.devops.dto.User;
import com.hitema.devops.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;
	
	public int createUser(User user) {
		return userDao.addUser(user);
	}

	public User getUserByPseudoOrMailAndPassword(String pseudoOrMail, String password) {
		if(pseudoOrMail.matches("(.*)@(.*)")){
			return userDao.findUerByMailAndPassword(pseudoOrMail, password);
		} else {
			return userDao.findUerByPseudoAndPassword(pseudoOrMail, password);
		}
		
	}

}
