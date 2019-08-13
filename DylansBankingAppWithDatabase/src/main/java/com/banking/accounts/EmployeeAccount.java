package com.banking.accounts;

public class EmployeeAccount {

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String phonenumber;
	private int type;
	private int employeeID;
	
	public EmployeeAccount() {
	}
	
	
	
	public EmployeeAccount(String username, int type, int employeeID) {
		super();
		this.username = username;
		this.type = type;
		this.employeeID = employeeID;
	}



	public EmployeeAccount(String username, String password, String firstName, String lastName, String phonenumber) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phonenumber = phonenumber;
		this.type = 2;
		this.employeeID=0;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	@Override
	public String toString() {
		return "EmployeeAccount [username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phonenumber=" + phonenumber + ", type=" + type + ", employeeID="
				+ employeeID + "]";
	}

	
	
	
}
