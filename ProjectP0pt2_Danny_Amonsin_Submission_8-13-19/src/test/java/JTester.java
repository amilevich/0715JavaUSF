import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bank.running.AccountsM;

public class JTester 
{
	
	AccountsM acc = new AccountsM();
	
	@Test
	public void findAccID()
	{
		assertEquals("should return an true or false", false, acc.findAccID(100));
	}
	
	@Test
	public void finduName()
	{
		acc.createAccountE("Kelly", "Jayden", "KJ", "2");
		assertEquals("should return an true or false", true, acc.finduName("KJ", 101));
	}
}

	
