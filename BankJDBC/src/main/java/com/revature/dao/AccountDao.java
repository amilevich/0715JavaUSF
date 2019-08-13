package com.revature.dao;


import java.util.List;

import com.revature.model.Accounts;

public interface AccountDao {
	
	//The purpose of the DAO interface
	//is to provide us with the guideline for our
	//CRUD operations to be performed on objects of type Bean (Pet)
	
	//CREATE
	public int insertAccounts(Accounts p);
	
	//READ
	public Accounts selectByAccountsId(int name);
	public List<Accounts> selectAllAccounts();
	
	//UPDATE
	public Accounts updateAccounts(Accounts p);
	
	//DELETE
	public int deleteAccounts(Accounts p);

}


