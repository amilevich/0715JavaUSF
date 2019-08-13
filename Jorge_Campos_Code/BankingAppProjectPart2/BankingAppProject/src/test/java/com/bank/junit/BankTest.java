package com.bank.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bank.User;

public class BankTest {

	User bank = new User();
	//change login back to default(set as public for JUnit test)
	//change findAccount back to protected after(set as public for JUnit test)
	//change load back to 
	
	@Test
	public void loginTest() {
		User.load();
		assertEquals("Should return true", true, bank.login("tom","t"));
		System.out.println("method to check if correct username and password");
	}
	
	@Test
	public void findAccountTest() {
		User.load();
		assertEquals("Should return true", true, bank.findAccount("admin"));
		System.out.println("method to check if account is created");
	}
	
	@Test
	public void getBalanceCheck() {
		User.load();
		assertEquals("Should return 28.0", 28.0, bank.getBalance("tom"),0);
		System.out.println("method to check if correct balance is returned");
	}

}
