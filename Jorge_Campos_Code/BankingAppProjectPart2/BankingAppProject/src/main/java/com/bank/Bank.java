package com.bank;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.dao.UserDaoImpl;

public class Bank {
	
	protected final static Logger tracker = Logger.getLogger(Bank.class);
	
	protected static HashMap<String, User> users = new HashMap<String,User>();
	private static Admin admin;
	
	
	
	public static void main(String[] args) throws Exception {

		admin = new Admin("admin","adminpass");
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.insertUser(admin);
//		String username, password, acctNum2;
//		int select;
//		double amount;
		if(users != null)
			User.load();
		User customer = new User();
		
		
		// Place in while loop to repeat menu( user -> create/apply -> wait(for approval) -> exit) 
		//									 (		-> login -> approved(if not display wait message) -> get account options -> logout/update info -> exit)
		//									 (		         -> get account options(check if employee acct) -> logout/update info -> exit)
		//									 (
		//									 (
		while(true) {
			customer.menu();
			
		}
		//input.close();
	}
}
