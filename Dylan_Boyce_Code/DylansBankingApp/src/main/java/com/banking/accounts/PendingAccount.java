package com.banking.accounts;

import java.io.Serializable;

public class PendingAccount implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2924299955112081111L;
	private String status;
	private String name;
	private String phoneNumber;
	private String age;
	private String username;
	private String password;
	private double accountNumber;
	private double accountBalance;
	private String jointAccess;
	
	
	public PendingAccount(String name, String phoneNumber, String age, String username, String password) {
		super();
		this.status="pending";
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.username = username;
		this.password = password;
		accountBalance = 20;
	}
	
	


	public PendingAccount() {
	}




	public String getJointAccess() {
		return jointAccess;
	}




	public void setJointAccess(String jointAccess) {
		this.jointAccess = jointAccess;
	}




	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
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


	public double getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}


	public double getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}




	@Override
	public String toString() {
		return "PendingAccount [status=" + status + ", name=" + name + ", phoneNumber=" + phoneNumber + ", age=" + age
				+ ", username=" + username + ", accountNumber=" + accountNumber + ", accountBalance=" + accountBalance
				+ ", jointAccess=" + jointAccess + "]";
	}


	
	
	
	
	
	
	
	
}
