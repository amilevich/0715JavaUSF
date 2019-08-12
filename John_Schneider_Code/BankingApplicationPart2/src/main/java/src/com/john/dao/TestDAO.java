package src.com.john.dao;

import java.util.ArrayList;

import src.com.john.core.Account;
import src.com.john.core.Admin;
import src.com.john.core.CheckingsAccount;
import src.com.john.core.Customer;
import src.com.john.core.Employee;
import src.com.john.core.SavingsAccount;
import src.com.john.core.User;

public class TestDAO
{
	public static void main(String[] args)
	{
		AccountDAOImpl a = new AccountDAOImpl();
		UserDAOImpl u = new UserDAOImpl();
		
		//Account acc = new CheckingsAccount(0, "john", null, 1000000, 10, false, false);
		//Account acs = new SavingsAccount(0, "john", null, 1000000, 10, 0, 0, false, false);
		//Account acs2 = new SavingsAccount(0, "john", null, 1000000, 10, 0, 0, true, false);
		//Account acs3 = new SavingsAccount(0, "john", null, 1000000, 10, 0, 0, true, false);
		
		//User usa = new Admin("john", "password");
		//User use = new Employee("johne", "password");
		//User usc = new Customer("johnc", "password");
		
		//u.insert(use);
		//u.insert(usc);
		
		//ArrayList<User> users = u.selectAllUsers();
		
		//a.insert(acs3);
		
		//ArrayList<Account> accounts = a.selectAllAccounts();
		
		//System.out.println(accounts.size());
		
		//for(Account x : accounts)
		//	System.out.println(x);
		
		//a.insert(acs);
	}
}