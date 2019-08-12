package src.com.john.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import src.com.john.core.Customer;
import src.com.john.core.User;
import src.com.john.core.UserManager;

public class UserManagerTest
{
	@Test
	public void testAddUser()
	{
		UserManager um = new UserManager();
		
		assertEquals(um.addUser("test", "test", 1), true);
		assertNotEquals(um.addUser("test", "test", 1), true);
		
		System.out.println("Method to test add user completed.");
	}
	
	@Test
	public void testGetUser()
	{
		UserManager um = new UserManager();
		um.addUser("test", "test", 1);
		
		User get_User = um.getUser("test");
		User get_null = um.getUser("asdf");
		
		assertEquals(get_User == null, false);
		assertNotEquals(get_null == null, false);
		
		System.out.println("Method to test get user completed.");
	}
	
	@Test
	public void testDoesUserExist()
	{
		UserManager um = new UserManager();
		User new_user = new Customer("test","test");
		um.users.add(new_user);
		
		assertEquals(um.doesUserExist("test"), true);
		assertNotEquals(um.doesUserExist("asdf"), true);
		
		System.out.println("Method to test does user exist completed.");
	}
	
	@Test
	public void testIsCorrectCombination()
	{
		UserManager um = new UserManager();
		User new_user = new Customer("test","test");
		um.users.add(new_user);
		
		assertEquals(um.isCorrectCombination("test", "test"), true);
		assertNotEquals(um.isCorrectCombination("test", "asdf"), true);
		
		System.out.println("Method to test if is correct combination completed.");
	}
}