package com.example.demo.database;


import com.example.demo.events.Event;
import com.example.demo.events.Subscriber;
import com.example.demo.model.Account;

import java.util.ArrayList;

public class AccountDAO implements Insert<Account>, Select<Account>, Delete<Account>, Subscriber
{
	private Accounts accountData = Accounts.getInstance();

	@Override
	public void delete(int id)
	{
		accountData.deleteAccount(id);
	}

	@Override
	public Account selectOne(int id)
	{
		return accountData.getAccount(id);
	}

	@Override
	public ArrayList<Account> selectAll()
	{
		return accountData.getAllAccounts();
	}

	@Override
	public void insert(Account obj)
	{
		accountData.addAccount(obj);
	}

	@Override
	public void notify(Event event)
	{
		// TODO Auto-generated method stub
		
	}

}
