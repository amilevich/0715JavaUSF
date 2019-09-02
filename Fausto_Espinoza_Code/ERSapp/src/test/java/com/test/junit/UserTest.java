package com.test.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ers.project.model.Users;

public class UserTest {
	
	Users user = new Users();
	
	@Test
	public void testUsusers() {
		
		user.setUserName("frer1972");
		String expected = "frer1972";
		
		assertEquals(expected,user.getUserName());
	}

}
