package com.uncertainty;

import java.io.Serializable;
import java.time.LocalDate;

public class Account extends Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4573616521656118278L;
	private String accountNumber;
	private LocalDate date;
	private double amount;
	private String id;
	
	private char status;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", date=" + date + ", amount=" + amount + ", id=" + id
				+ ", status=" + status + "]";
	}
	
	
	

}
