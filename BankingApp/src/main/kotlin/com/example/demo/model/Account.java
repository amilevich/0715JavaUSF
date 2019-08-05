package com.example.demo.model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Account implements Serializable
{
	private static final long serialVersionUID = 1L;

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

	public void setBalance(double newBalance)
	{
		this.balance = newBalance;
	}


}
