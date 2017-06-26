package com.hitema.devops.dto;

public class User {
	
	private int id;
	private String mail;
	private String pseudo;
	private String password;

	public User() {}

	public User(String mail, String pseudo, String password) {
		this.mail = mail;
		this.pseudo = pseudo;
		this.password = password;
	}

	public User(int id, String mail, String pseudo, String password) {
		this.id = id;
		this.mail = mail;
		this.pseudo = pseudo;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", mail=" + mail + ", pseudo=" + pseudo + ", password=" + password + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
