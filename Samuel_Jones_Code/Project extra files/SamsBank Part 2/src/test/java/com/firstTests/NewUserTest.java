package com.firstTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import items.Account;
import items.Actions;
import items.Transaction;

public class NewUserTest {
//	@Test
//	
//	public void createNewUser() {
//		assertEquals("create new user", new Account("sam","sam",10000,"sam","sam","sam","sam"), MainMenu.createNewUser());
//		
//	}
	
	@Test
	public void transfer() {
		Account a = new Account("sam","sam",10000,"sam","sam","sam","sam");
		Account t = new Account("spa","sam",10000,"sam","sam","sam","sam");
		Account e = new Account("sam","sam",6000,"sam","sam","sam","sam");
		assertEquals("transfer", e.toString(), Actions.transfer(a, 4000, t).toString());
//		assertEquals("Adding 4 and 4.. should be 8", 8, add(4,4));
	}
	
	public void deposit() {
		Transaction t = new Transaction("deposit", 1000);
		
				
				Actions.deposit(a, 1000).toString()
	}
}
