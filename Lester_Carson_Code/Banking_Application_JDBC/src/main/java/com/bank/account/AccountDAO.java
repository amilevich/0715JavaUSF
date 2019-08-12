package com.bank.account;

public interface AccountDAO {
	public void insertAccount(Account a, String name);
	public void insertUsernameToAccount(Account a, String name);
	public Account selectAccountByID(int id);
	public void updateAccountBalance(Account a);
	public void updateAccountisapproved(Account a);
}