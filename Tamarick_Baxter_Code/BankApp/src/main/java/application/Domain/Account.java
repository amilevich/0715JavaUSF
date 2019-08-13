package main.java.application.Domain;

import java.io.Serializable;

public class Account implements Serializable {
	
	// Serial Version
	private static final long serialVersionUID = -12345977733L;
	
	private int accountNumber;
	private double balance;
	private String status;
	
	// Add two users user1 mandatory, user2 mandatory for joint account
	private String user1;
	private String user2;
	
	public Account() {
		super();
	}

	public Account(int accountNumber, double balance, String status) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.status = status;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the user1
	 */
	public String getUser1() {
		return user1;
	}

	/**
	 * @param user1 the user1 to set
	 */
	public void setUser1(String user1) {
		this.user1 = user1;
	}

	/**
	 * @return the user2
	 */
	public String getUser2() {
		return user2;
	}

	/**
	 * @param user2 the user2 to set
	 */
	public void setUser2(String user2) {
		this.user2 = user2;
	}
}
