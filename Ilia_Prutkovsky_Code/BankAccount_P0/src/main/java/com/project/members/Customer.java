package com.project.members;

import java.io.IOException;
import java.io.Serializable;
import com.project.db.ScanReader;

public class Customer implements Serializable {
	static ScanReader sc = new ScanReader(System.in);

	private static final long serialVersionUID = -8911322715995313318L;

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private int customerID;
	private double accountBalance;
	int count;
	static int instCount = 100000;

	public Customer(String username, String password, String firstName, String lastName, String phoneNumber,
			int customerID, double accountBalance) throws IOException {
		instCount++;
		count = instCount;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.customerID = count;
		this.accountBalance = accountBalance;
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

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double balanceAmount) {
		this.accountBalance = balanceAmount;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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

	@Override
	public String toString() {
		return "Customer [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", customerID=" + customerID + ", accountBalance=" + accountBalance
				+ "]";
	}
}
