package com.hitema.devops.config;

public class SqlRequest {

	public static final String INSERT_USER = "INSERT INTO user(mail, pseudo, password) VALUES (?,?,?)";
	public static final String GET_USER_BY_MAIL_AND_PWD = "select * from user where mail = ? and password = ?";
	public static final String GET_USER_BY_PSEUDO_AND_PWD = "select * from user where pseudo = ? and password = ?";

}
