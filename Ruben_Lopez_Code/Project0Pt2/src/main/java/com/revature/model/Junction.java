package com.revature.model;

public class Junction {
	
	
	int accountnumber = 0;
	String username = "";
	
	
	
	public Junction(int accountnumber, String username) {
		super();
		this.accountnumber = accountnumber;
		this.username = username;
	}
	

	public int getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	

}
