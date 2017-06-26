package com.hitema.devops.service;

import com.hitema.devops.dto.User;

public interface UserService {

	int createUser(User user);

	User getUserByPseudoOrMailAndPassword(String pseudo, String password);

}
