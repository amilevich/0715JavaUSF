package com.bank.project.model;


import java.io.Serializable;
import java.time.LocalDateTime;

public class Account extends Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3640321184356140093L;
	private String accountNumber;
	private char kindAccount; // checking or saving
	private double amount;
	private LocalDateTime date;
	private char status;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public char getKindAccount() {
		return kindAccount;
	}

	public void setKindAccount(char kindAccount) {
		this.kindAccount = kindAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", kindAccount=" + kindAccount + ", amount=" + amount
				+ ", date=" + date + ", status=" + status + ", getNmCustomer()=" + getNmCustomer() + ", getAddress()="
				+ getAddress() + ", getPhone()=" + getPhone() + ", toString()=" + super.toString() + ", getId()="
				+ getId() + ", getUser()=" + getUser() + ", getPwd()=" + getPwd() + ", getKindPerson()="
				+ getKindPerson() + "]";
	}

	
	
	
	

}
