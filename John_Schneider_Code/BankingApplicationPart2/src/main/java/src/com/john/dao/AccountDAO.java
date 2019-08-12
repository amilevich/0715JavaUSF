package src.com.john.dao;

import java.util.ArrayList;

import src.com.john.core.Account;

public interface AccountDAO
{
	public void insert(Account account);
	
	public Account selectAccountByID(int ID);
	
	public ArrayList<Account> selectAllAccounts();
	
	public void updateAccount(Account account);
	
	public void deleteAccount(Account account);
}