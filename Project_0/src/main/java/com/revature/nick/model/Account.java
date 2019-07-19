package com.revature.nick.model;

public class Account
{
	private int accountNumber;
	
	private double balance;
	
	public Account(int accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public double getBalance()
	{
		return balance;
	}

	public void withdraw(double amount)
	{
		if (this.balance > amount)
		{
			this.balance -= amount;
		}
	}
	
	public void deposit(double amount)
	{
		this.balance += amount;
	}
}
