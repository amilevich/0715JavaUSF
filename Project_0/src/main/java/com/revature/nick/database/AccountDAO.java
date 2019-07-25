package com.revature.nick.database;

import java.util.ArrayList;

import com.revature.nick.events.Event;
import com.revature.nick.events.Subscriber;
import com.revature.nick.model.Account;

public class AccountDAO implements Insert<Account>, Select<Account>, Delete<Account>, Subscriber
{
	Accounts accountData = Accounts.getInstance();
	
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
