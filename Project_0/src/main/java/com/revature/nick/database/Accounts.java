package com.revature.nick.database;

import java.util.HashMap;

import com.revature.nick.model.Account;

public class Accounts
{
	private static Accounts instance = null;
	
	private HashMap<Integer, Account> accountMap;
	
	private Accounts()
	{
		accountMap = new HashMap<Integer, Account>();
	}
	
	public Accounts getInstance()
	{
		if (instance == null)
		{
			instance = new Accounts();
		}
		return instance;
	}
	
	public void addAccount(Account account, int customerID)
	{
		this.accountMap.put(customerID, account);
	}
	
	public Account getAccount(int id)
	{
		return this.accountMap.get(id);
	}
}
