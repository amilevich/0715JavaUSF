package model;

import java.io.Serializable;

public class Applicant extends Person implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7816742921145102392L;
	protected String username;
	protected String password;
	
	public Applicant(String firstName, String lastName, String username, String password) {
		super(firstName, lastName);
		this.username = username;
		this.password = password;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Applicant [firstname="+ super.firstName + ", lastname="+ super.lastName +" ,username=" + username + ", password=" + password + "]";
	}
	
	
}
