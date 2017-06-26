package com.hitema.devops.dao;

import com.hitema.devops.dto.User;

public interface UserDAO {

	int addUser(User user);

	User findUerByMailAndPassword(String pseudoOrMail, String password);

	User findUerByPseudoAndPassword(String pseudoOrMail, String password);

}
