package com.banking.accounts;



public class CustomerAccount {
	private int customerID;
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private int age;
	private String username;
	private String password;
	private String jointAccess;
	
	
	public CustomerAccount() {
	}

	public CustomerAccount(int customerID, String firstName, String lastName, long phoneNumber, int age,
			String username) {//this constructor used for printing out single accounts to employee's
		super();
		this.customerID= customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.username = username;
		this.jointAccess = jointAccess;
	}
	
	public CustomerAccount(String firstName, String lastName, long phoneNumber, int age,
			String username, String password) {
		super();
		this.customerID= 0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.username = username;
		this.password = password;
		
	}


	public int getCustomerID() {
		return customerID;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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


	public long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
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


	public String getJointAccess() {
		return jointAccess;
	}


	public void setJointAccess(String jointAccess) {
		this.jointAccess = jointAccess;
	}


	@Override
	public String toString() {
		return "CustomerAccount [CustomerID = " + customerID + ", FirstName = " + firstName + ", LastName = " + lastName
				+ ", PhoneNumber = " + phoneNumber + ", Age = " + age + ", Username = " + username + "]";
	}
	
	
	
	
}
