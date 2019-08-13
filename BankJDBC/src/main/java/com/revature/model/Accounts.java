package com.revature.model;

public class Accounts {

int accountId; 
int balance; 
int status;
String accountType;

public Accounts() {
	
}

public Accounts(int accountId, int balance, int status, String accountType) {
	super();
	this.accountId = accountId;
	this.balance = balance;
	this.status = status;
	this.accountType = accountType;
}



public int getAccountId() {
	return accountId;
}

public void setAccountId(int accountId) {
	this.accountId = accountId;
}

public int getBalance() {
	return balance;
}

public void setBalance(int balance) {
	this.balance = balance;
}

public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}

public String getAccountType() {
	return accountType;
}

public void setAccountType(String accountType) {
	this.accountType = accountType;
}

@Override
public String toString() {
	return "Accounts [accountId=" + accountId + ", balance=" + balance + ", status=" + status + ", accountType="
			+ accountType + "]";
}




}
