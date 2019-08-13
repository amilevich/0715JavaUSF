package com.bankdb.project.model;

public class JointAccount {
	
	private String username;
	private String accountnumber;
	private String status;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "JointAccount [username=" + username + ", accountnumber=" + accountnumber + ", status=" + status + "]";
	}
	
}
