package com.banking.accounts;

import java.io.Serializable;

public class JointAccount extends PendingAccount implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8053516299671255441L;
	private String status = "joint";
	private String username1;
	private String username2;
	private double accountBalance;
	private double accountNumber;
	private String jointAccess;
	private String username;
	
	
	public JointAccount(String username1, String username2, String jointAccess) {
		super();
		
		this.username1 = username1;
		this.username2 = username2;
		accountBalance = 0;
		this.jointAccess = jointAccess;
		username=jointAccess;
		
	}


	public String getUsername1() {
		return username1;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}


	public void setUsername1(String username1) {
		this.username1 = username1;
	}


	public String getUsername2() {
		return username2;
	}


	public void setUsername2(String username2) {
		this.username2 = username2;
	}


	public double getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}


	public double getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getJointAccess() {
		return jointAccess;
	}


	public void setJointAccess(String jointAccess) {
		this.jointAccess = jointAccess;
	}


	@Override
	public String toString() {
		return "JointAccount [status=" + status + ", username1=" + username1 + ", username2=" + username2
				+ ", accountBalance=" + accountBalance + ", accountNumber=" + accountNumber + ", jointAccess="
				+ jointAccess + "]";
	}
	
	
	

	
}
