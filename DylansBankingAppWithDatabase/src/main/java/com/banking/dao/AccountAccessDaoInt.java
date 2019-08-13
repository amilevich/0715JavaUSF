package com.banking.dao;

import java.util.List;

import com.banking.accounts.CustomerAccount;



public interface AccountAccessDaoInt {
	
	//CREATE
		public void insertAccountJunction(int customerID, int bankID,String accounttype);
		
		//READ
		public int getAccountID(int customerID);
		public List<CustomerAccount> viewAllJunctionIds();
		
		
		//UPDATE
		public CustomerAccount updateJunctionInfo(CustomerAccount client);
		
		//DELETE
		public void deleteCustomerAccount(CustomerAccount client);

}
