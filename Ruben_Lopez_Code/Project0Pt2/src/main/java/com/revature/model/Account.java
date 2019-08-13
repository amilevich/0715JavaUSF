package com.revature.model;

public class Account {
	
	
	int accountnumber = 0;
	int balance = 0 ;
	int status = 0;
	int thirdaccount = 0;
	
	
	
	
	
	
	
	
	
	
	public Account(int accountnumber, int balance, int status, int thirdaccount) {
		super();
		this.accountnumber = accountnumber;
		this.balance = balance;
		this.status = status;
		this.thirdaccount = thirdaccount;
	}
	
	public Account() {
		
	}


	
	
	
	@Override
	public String toString() {
		return "Account [accountnumber=" + accountnumber + ", balance=" + balance + ", status=" + status
				+ ", thirdaccount=" + thirdaccount + "]";
	}

	public int getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}
	
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	
	
	
	
	
	
	
}
