package model;

public class Applicant extends Person {
	protected String username;
	protected String password;
	
	public Applicant(String firstName, String lastName, String username, String password) {
		super(firstName, lastName);
		this.username = username;
		this.password = password;
	}
	
	public Applicant(String firstName, String lastName, String username) {
		super(firstName, lastName);
		this.username = username;
	}
	
	public Applicant(String username) {
		this.username = username;
	}
	
	public Applicant() {
		// TODO Auto-generated constructor stub
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
		return "Applicant [firstname="+ super.firstname + ", lastname="
				+ super.lastname +" ,username=" + username + ", password=" + password + "]";
	}
}
