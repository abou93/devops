package com.hitema.devops.dao.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hitema.devops.config.SqlRequest;
import com.hitema.devops.dao.UserDAO;
import com.hitema.devops.dto.User;
import com.hitema.devops.mapper.UserMapper;

@Repository
public class UserJDBCTemplate implements UserDAO{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public int addUser(User user) {
		 return jdbcTemplate.update(SqlRequest.INSERT_USER ,user.getMail(), user.getPseudo(), user.getPassword());
	}

	public User findUerByMailAndPassword(String mail, String password) {
	      return jdbcTemplate.queryForObject(SqlRequest.GET_USER_BY_MAIL_AND_PWD, 
	         new Object[]{mail, password}, new UserMapper());
	}

	public User findUerByPseudoAndPassword(String pseudo, String password) {
	      return jdbcTemplate.queryForObject(SqlRequest.GET_USER_BY_PSEUDO_AND_PWD, 
	 	         new Object[]{pseudo, password}, new UserMapper());
	}

}
