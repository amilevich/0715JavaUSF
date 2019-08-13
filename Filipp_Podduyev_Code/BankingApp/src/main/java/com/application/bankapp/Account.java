package com.application.bankapp;

public class Account {
	static String userName;
	static double balance;
//	String userName1;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String userName, double balance) {
		super();
		Account.userName= userName;
		Account.balance = balance;

	}
	
//	public Account(String userName1, int accountId) {
//		super();
//		userName1 = userName1;
//		this.accountId = accountId;
//	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		Account.balance = balance;
	}

	public String getAccountUsername() {
		return userName;
	}

	public void setAccountUser(String userName) {
		Account.userName = userName;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + userName + ", balance=" + balance;
	}


}
