package com.bank.junit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.bank.account.Account;
import com.bank.account.AccountImpl;

public class CustomerTest {
	
	Account acc = new Account(1, 1, 100);
	Account acc2 = new Account(2, 1, 100);
	AccountImpl a = new AccountImpl();
	
	@Test
	public void desposit() {
		a.Open(1);
		assertEquals("should return balance + deposit", 100.00, a.Deposit(100.00), 0);
	}
	
	@Test
	public void withdraw() {
		a.Open(1);
		assertEquals("should return balance - withdraw", 0, a.Withdraw(100.00), 0);
	}
	
	@Test
	public void transfer() {
		a.Open(1);
		assertEquals("should return balance of originals account", 50.00, a.Transfer(2, 50.00), 0);
	}	
}