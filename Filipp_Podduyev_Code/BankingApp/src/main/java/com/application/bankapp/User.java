package com.application.bankapp;

public class User {
	
	static String userName;
	String passWord;
	String firstName;
	String lastName;
	String status;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String userName, String passWord, String firstName, String lastname, String status) {
		super();
		User.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastname;
		this.status = status;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		User.userName = userName;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Username:" + userName + "\n passWord=" + passWord + "\n firstName=" + firstName + "\n lastName="
				+ lastName + "\n status=" + status;
	}

	
	
   
}
