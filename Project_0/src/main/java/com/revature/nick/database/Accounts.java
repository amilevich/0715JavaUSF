package com.revature.nick.database;

import java.util.ArrayList;
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
	
	public static Accounts getInstance()
	{
		if (instance == null)
		{
			instance = new Accounts();
		}
		return instance;
	}
	
	public void addAccount(Account account)
	{
		this.accountMap.put(account.getAccountNumber(), account);
	}
	
	public Account getAccount(int id)
	{
		return this.accountMap.get(id);
	}
	
	public ArrayList<Account> getAllAccounts()
	{
		ArrayList<Account> list = new ArrayList<Account>();
		
		for (int i : this.accountMap.keySet())
		{
			list.add(this.accountMap.get(i));
		}
		
		return list;
	}
	
	public void deleteAccount(int id)
	{
		this.accountMap.remove(id);
	}
	
	public void updateAccount(Account update)
	{
		this.accountMap.get(update.getAccountNumber()).setBalance(update.getBalance());
	}
}
