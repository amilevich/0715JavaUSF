package com.revature.dao;



import java.util.List;


import com.revature.model.Account;



public interface AccountDao {
	
	//CREATE
	public int createNewAccount();
	
	//READ
	public List<Account> selectAllAccount();
	
	public int gethighestAccountNumber();
	
	
	
	public boolean checkForaccount(int accountnumber); 
	
	public int getBalanceByAccountNumber(int accountnumber);
	
	public int getStatusByAccountNumber(int accountnumber);
	
	
	public boolean checkIfJoinable(String usertacker);
	
	public int getThirdAccountByAccountnumber(int tempaccountnumber);
	
	
	
	
	
	//UPDATE 
	
	public int setBalacne(int accountnumber, int newbalance);
	
	public int setStatus(int accountnumber, int newstatus);
	
	public int setThirdAccount(int accountnumber, int thirdaccountnumber);
	
	
	//DELETE
	
	public int deleteAccountbyAccountNumber(int accountnumber);
}
