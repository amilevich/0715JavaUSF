package com.banking.accounts;

public class BankAccount {
	private String accountType;
	private String status;
	private int accountID;
	private double accountBalance;
	private String jointAccess;
	private String username;

	public BankAccount() {
		// TODO Auto-generated constructor stub
	}
	
	
	


	public BankAccount(String jointAccess) {
		super();
		this.jointAccess = jointAccess;
	}





	public BankAccount(String accountType,String status, double accountBalance, String jointAccess) {
		super();
		this.accountType = accountType;
		this.status=status;
		this.accountBalance = accountBalance;
		this.jointAccess = jointAccess;
	}



	public BankAccount(String accountType,String status, double accountBalance) {
		super();
		this.accountType = accountType;
		this.status=status;
		this.accountBalance = accountBalance;
	}
	
	

	public BankAccount(String accountType, int accountID, double accountBalance) {
		super();  //used to toString account info
		this.accountType = accountType;
		this.accountID = accountID;
		this.accountBalance = accountBalance;
	}


	public BankAccount(String accountType,String status,  int accountID, double accountBalance, String username, String jointAccess) {
		super();
		this.accountType = accountType;
		this.status=status;
		this.accountID = accountID;
		this.accountBalance = accountBalance;
		this.username = username;
		this.jointAccess=jointAccess;
	}



	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getJointAccess() {
		return jointAccess;
	}

	public void setJointAccess(String jointAccess) {
		this.jointAccess = jointAccess;
	}

	


	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	@Override
	public String toString() {
		if(jointAccess != null) {
		return "BankAccount [AccountType = " + accountType + ", AccountID = " + accountID + ", JointAccess = " + jointAccess
				+ ", Username = " + username + "]";
		}else {
			return "BankAccount [AccountType = " + accountType + ", AccountID = " + accountID + ", Username = " + username + "]";
		}
	}



	

	
}
