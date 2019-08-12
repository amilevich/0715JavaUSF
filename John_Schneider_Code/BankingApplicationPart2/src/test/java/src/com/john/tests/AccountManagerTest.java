package src.com.john.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.com.john.core.Account;
import src.com.john.core.AccountManager;
import src.com.john.core.CheckingsAccount;
import src.com.john.core.Customer;
import src.com.john.core.User;

public class AccountManagerTest
{	
	@Test
	public void testAddNewAccount()
	{
		AccountManager accountManager = new AccountManager();
		User primary = new Customer("primary", "1");
		User joint = new Customer("joint", "1");
		
		accountManager.addNewAccount(primary, 1, joint);
		
		boolean contains_Primary = accountManager.userAccounts.containsKey(primary.getUsername());
		boolean contains_Joint = accountManager.userAccounts.containsKey(joint.getUsername());
		
		boolean[] actual = {contains_Primary, contains_Joint};
		boolean[] expected = {true, true};
		
		assertArrayEquals(actual, expected);
		
		System.out.println("Method to test adding new account completed.");
	}
	
	@Test
	public void testGetTotalAccountNumber()
	{
		AccountManager accountManager = new AccountManager();
		User primary = new Customer("primary", "1");
		User joint = new Customer("joint", "1");
		
		accountManager.addNewAccount(primary, 1, joint);
		
		int count = accountManager.getTotalAccountNumber();
		
		assertEquals(count, 3);
		
		System.out.println("Method to test get total number of accounts completed.");
	}
	
	@Test
	public void testAddAccount()
	{
		AccountManager accountManager = new AccountManager();
		User primary = new Customer("primary", "1");
		Account account = new CheckingsAccount(accountManager.getTotalAccountNumber(), primary, null);
		
		accountManager.addAccount("primary", account);
		
		boolean equals = accountManager.userAccounts.get("primary").contains(account);
		
		assertEquals(equals, true);
		
		System.out.println("Method to test add account completed.");
	}
	
	@Test
	public void testGetAccounts()
	{
		AccountManager accountManager = new AccountManager();
		User primary = new Customer("primary", "1");
		Account account = new CheckingsAccount(accountManager.getTotalAccountNumber(), primary, null);
		accountManager.addAccount("primary", account);
		
		boolean equals = accountManager.getAccounts("primary").contains(account);
		
		assertEquals(equals, true);
		
		System.out.println("Method to test get accounts completed.");
	}
	
	@Test
	public void testGetKeySet()
	{
		AccountManager accountManager = new AccountManager();
		User primary = new Customer("primary", "1");
		User joint = new Customer("joint", "1");
		
		accountManager.addNewAccount(primary, 1, joint);
		
		boolean contains = accountManager.getKeySet().contains(primary.getUsername()) && accountManager.getKeySet().contains(joint.getUsername());
		
		assertEquals(contains, true);
		
		System.out.println("Method to test get keyset completed.");
	}
}