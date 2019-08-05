package data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Application;
import model.BankAccount;

public class CounterTest {
	@Test
	public void testReadApplication() {
		assertEquals("file counters equals class counters",true,Counter.readTest("Application") == Application.getCounter());
	}
	@Test
	public void testReadBankAccount() {
		assertEquals("file counters equals class counters",true,Counter.readTest("BankAccount") == BankAccount.getCounter());
	}
}
