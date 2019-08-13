package com.project.members;

import java.io.IOException;

import com.project.db.ScanReader;

public class Customer1 {
	static ScanReader sc = new ScanReader(System.in);
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private int customerID;
	private double accountBalance;
	private String status;
	int count;
	static int instCount = 100000;
	public Customer1(String username, String password, String firstName, String lastName, String phoneNumber,
			int customerID, double accountBalance, String status) throws IOException {	
		instCount++;
		count = instCount;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.customerID = customerID;
		this.accountBalance = accountBalance;
		this.status = "pending";
		this.newCustomer();
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void newCustomer() throws IOException {

		System.out.println("-=Please create *username* for your account=-");
		this.username = sc.scanString();

		System.out.println("-=Please create *password* for your account=-");
		this.password = sc.scanString();

		System.out.println("-=Input your First Name=-");
		this.firstName = sc.scanString();

		System.out.println("-=Input your Last Name=-");
		this.lastName = sc.scanString();

		System.out.println("-=Input your phone number(#)=-");
		this.phoneNumber = sc.scanString();
	}
	
	

}
