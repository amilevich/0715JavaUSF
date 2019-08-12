package com.bank.account;

public class Account {
	
	private int accountID, isapproved;
	private double balance;

	public Account(int accountID, int isapproved, double balance) {
		super();
		this.accountID = accountID;
		this.isapproved = isapproved;
		this.balance = balance;
	}
	
	public Account() {
		super();
		this.isapproved = 0;
		this.balance = 0;
	}
	
	public int getAccountID() {return accountID;}
	public void setAccountID(int accountID) {this.accountID = accountID;}
	public int getIsapproved() {return isapproved;}
	public void setIsapproved(int isapproved) {this.isapproved = isapproved;}
	public double getBalance() {return balance;}
	public void setBalance(double balance) {this.balance = balance;}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", isapproved=" + isapproved + ", balance=" + balance + "]";
	}
}