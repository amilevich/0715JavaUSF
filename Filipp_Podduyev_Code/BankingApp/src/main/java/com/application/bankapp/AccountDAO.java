package com.application.bankapp;

import java.util.List;

public interface AccountDAO {
	//CREATE
	public int createAccount(Account acc);
	
	//READ
	public Account selectAccByUsername(String userName);
	public List<Account> selectAllAccounts();
//	public void createJunctiontable(Account acc1);
	
	//UPDATE
	public int updateAccount(double balance, String userName);
	
	//DELETE
	public int deleteAccount(Account acc);


}
