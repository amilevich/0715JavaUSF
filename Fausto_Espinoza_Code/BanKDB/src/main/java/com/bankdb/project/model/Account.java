package com.bankdb.project.model;

import java.sql.Date;
import java.time.LocalDateTime;

public class Account {

	private String accountNumber;
	private String kindAccount; // checking or saving
	private double amount;
	private Date date;
	private String status;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getKindAccount() {
		return kindAccount;
	}
	public void setKindAccount(String kindAccount) {
		this.kindAccount = kindAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", kindAccount=" + kindAccount + ", amount=" + amount
				+ ", date=" + date + ", status=" + status + "]";
	}
	
	
}
