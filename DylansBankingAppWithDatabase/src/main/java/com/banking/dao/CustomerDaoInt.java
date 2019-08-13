package com.banking.dao;

import java.util.List;

import com.banking.accounts.CustomerAccount;

public interface CustomerDaoInt {
	
	//CREATE
	public void insertCustomerAccount(CustomerAccount client);
	
	//READ
	public CustomerAccount selectCustomerByUsername(String userName);
	public List<CustomerAccount> selectAllCustomers();
	public String validateUsername(String username);
	
	//UPDATE
	public CustomerAccount updateAccountInfo(CustomerAccount client);
	
	//DELETE
	public void deleteCustomerAccount(CustomerAccount client);

}
