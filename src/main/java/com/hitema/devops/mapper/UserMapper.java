package com.hitema.devops.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hitema.devops.dto.User;

public class UserMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setMail(rs.getString("mail"));
		user.setPseudo(rs.getString("pseudo"));
		user.setPassword(rs.getString("password"));
		return user;
	}

}