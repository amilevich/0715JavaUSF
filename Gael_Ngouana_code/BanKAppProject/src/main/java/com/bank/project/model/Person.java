package com.bank.project.model;

import java.io.Serializable;

public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2153825365528893752L;
	private String id;
	private String user;
	private String pwd;
	private char KindPerson;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public char getKindPerson() {
		return KindPerson;
	}

	public void setKindPerson(char kindPerson) {
		KindPerson = kindPerson;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", user=" + user + ", pwd=" + pwd + ", KindPerson=" + KindPerson + "]";
	}

}
