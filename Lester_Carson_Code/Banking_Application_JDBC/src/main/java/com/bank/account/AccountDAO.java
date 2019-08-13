package com.bank.account;

import java.util.ArrayList;

public interface AccountDAO {
	public void insertAccount(Account a, String name);
	public void insertUsernameToAccount(Account a, String name);
	public Account selectAccountByID(int id);
	public ArrayList<String> selectUsernamesLinkedToAccount(int id);
	public void updateAccountBalance(Account a);
	public void updateAccountisapproved(Account a);
}