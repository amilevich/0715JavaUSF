package main;

import static main.Command.Employee.Regular;
import static main.Command.Customer.Existing;
import utility.validator.AmountValidator;

import org.junit.Test;

import seed.PrimaryModels;

import static org.junit.Assert.assertEquals;

public class CommandTest {
	
	@Test
	public void userIsCustomer() {
		PrimaryModels.seed();
		assertEquals("The User is a Customer", true, Existing.Do.verify("gabriel", "gabrieL675"));
	}
	
	@Test
	public void userIsRegularEmployee() {
		assertEquals("The User is a Regular Employee", true, Regular.Do.isRegularEmployee("juana2", "juanA2!"));
	}
	
	@Test
	public void userIsAnAdminEmployee() {
		assertEquals("The User is an Admin Employee", true, Regular.Do.isAdmin("geneferr"));
	}
}
