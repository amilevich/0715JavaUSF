package com.banking.dao;

import java.util.List;

import com.banking.accounts.BankAccount;

public interface BankDaoInt {
	
	//CREATE
		public void insertBankAccount(BankAccount client,String username);
		
		//READ
		public BankAccount selectBankByID(int accountID);
		public List<BankAccount> selectAllBankAccounts();
		public double getAccountBalance(int accountid);
		public int getAccountId(String username);
		
		//UPDATE
		public void updateAccountBalance(int accountid, double cash);
		
		//DELETE
		public void deleteBankAccount(BankAccount client);

}
