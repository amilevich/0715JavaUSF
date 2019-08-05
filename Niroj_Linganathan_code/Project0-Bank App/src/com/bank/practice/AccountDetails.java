package com.bank.practice;

import java.io.Serializable;

public class AccountDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private int accNumber;
	private String accNumber;
	private double balance;

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountDetails(String accNumber, double balance) {
		super();
		this.accNumber = accNumber;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return Double.toString(getBalance());
	}

	public AccountDetails() {
		super();
	}

	


	
}
