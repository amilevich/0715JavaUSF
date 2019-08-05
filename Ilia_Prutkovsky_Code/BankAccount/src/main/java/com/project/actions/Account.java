package com.project.actions;

public class Account {

	private double balance;
	private int accountNumber;

	public Account(int accountNumber) {
		this.balance = 0;
		this.accountNumber = accountNumber;
	}

	public Account(double balance, int accountNumber) {
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public double withdraw(double withdrawlAmount) {
		if (this.balance > withdrawlAmount) {
			this.balance -= withdrawlAmount;
		} else {
			System.out.println("Your balance is to low");
		}
		return this.balance;
	}

	public double deposit(double depositAmount) {
		this.balance += depositAmount;

		return this.balance;
	}

	public void setBalance(double newBalance) {
		this.balance = newBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int number) {
		this.accountNumber = number;
	}
}
