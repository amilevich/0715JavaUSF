package com.project.bank;

public interface accountDAO {

	public void insertAccount(account a1);
	
	public account selectAccount(int acc_No);
	public account selectAccountUserName(String userName);
	public void insertJunctionTable(account acc1);
	public void employeeSeeAccountDetails(int acc_No);
	public void cancelAccount(int acc_No);
}
