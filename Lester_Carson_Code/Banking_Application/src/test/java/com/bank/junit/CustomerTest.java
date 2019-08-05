package com.bank.junit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.bank.customer.Customer;
import com.bank.customer.CustomerDAOImpl;
import com.bank.employee.EmployeeDAOImpl;

public class CustomerTest {
	
	CustomerDAOImpl test = new CustomerDAOImpl("test", "test", 1);
	EmployeeDAOImpl em = new EmployeeDAOImpl();
	
	@Test
	public void desposit() {
		em.Approve("test", "test", true);
		test.Open("test", "test");
		assertEquals("should return balance + deposit", 100.00, test.Deposit(50.00), 0);
	}
	
	@Test
	public void withdraw() {
		em.Approve("test", "test", true);
		test.Open("test", "test");
		test.Deposit(100.00);
		assertEquals("should return balance - withdraw", 50.00, test.Withdraw(50.00), 0);
	}
	
	@Test
	public void transfer() {
		CustomerDAOImpl.customers.add(new Customer("test2", "test2", 1));
		em.Approve("test", "test", true);
		em.Approve("test2", "test2", true);
		test.Open("test", "test");
		assertEquals("should return balance of originals account", 50.00, test.Transfer("test2", "test2", 50.00, "to"), 0);
	}
	
}
