package com.revature.dao;

import java.util.List;

import com.revature.model.Junction;


public interface JunctionDao {
	
	
	
	//CREATE
	public int createNewJunction(String newusername, int newaccountnumber);
	
	//READ
	public int getAccountNumberByUserName(String username1);
	
	public int getBalanceByUsername(String username1);
	
	public List<Junction> seeUnapprovedAccountsbyJunctiontable();
	
	public String getUsernameByAccountNumber(int accountnumber);
	
	//UPDATE
	public int setAccountnumberByuserName(String usertracker, int newaccountnumber);
	
	
	
	//DELETE
	
	public int deleteByAccountNumber(int oldaccount);

}
