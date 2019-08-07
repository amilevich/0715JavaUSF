package com.banking.accounts;

import java.util.HashMap;

public class CustomerAccount {
	private String status;
	private String name;
	private String phoneNumber;
	private int age;
	private int accountNumber;
	private double accountBalance;
	
//	 public static HashMap customerAccounts = new HashMap();
	
	public CustomerAccount(String name, String phoneNumber, int age, int accountNumber, double accountBalance) {
		super();
		this.status = "active";
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}
	
	public String getStatus() {
		return status;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public int getAge() {
		return age;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}
	
	
	
//	 public static HashMap customerAccounts = new HashMap();
	
	

}
