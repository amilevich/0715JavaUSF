package com.project.bank;

public class account {
	int acc_No;
	String UName;
	double balance;
	
	
	public String getUName() {
		return UName;
	}

	public void setUName(String uName) {
		UName = uName;
	}

	public account() {
		super();
	}

	public int getacc_No() {
		return acc_No;
	}

	

	public void setAcc_No(int acc_No) {
		this.acc_No = acc_No;
	}

	public double getBalance() {
		return balance;
	}

	public account(int acc_No, String uName) {
		super();
		this.acc_No = acc_No;
		UName = uName;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	public account(String uName, double balance) {
		super();
		UName = uName;
		this.balance = balance;
	}

	public account(int acc_No, String uName, double balance) {
		super();
		this.acc_No = acc_No;
		UName = uName;
		this.balance = balance;
	}
	public account(int acc_No, double balance) {
		super();
		this.acc_No = acc_No;
		this.balance = balance;
	}
	

	@Override
	public String toString() {
		return "account [acc_No=" + acc_No + ", balance=" + balance + "]";
	}

	
}
