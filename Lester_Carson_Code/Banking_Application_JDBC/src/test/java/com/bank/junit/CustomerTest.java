package com.bank.junit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.bank.account.AccountImpl;

public class CustomerTest {
	
	AccountImpl a = new AccountImpl();
	
	@Test
	public void desposit() {
		a.Open(1);
		assertEquals("should return balance + deposit", 100.00, a.Deposit(100.00), 0);
	}
	
	@Test
	public void withdraw() {
		a.Open(1);
		a.Deposit(100.00);
		assertEquals("should return balance - withdraw", 0, a.Withdraw(100.00), 0);
	}
	
	@Test
	public void transfer() {
		a.Open(1);
		a.Withdraw(50.00);
		assertEquals("should return balance of originals account", 0.00, a.Transfer(2, 50.00), 0);
	}	
}