package main;

import static org.junit.Assert.assertEquals;

import java.util.TreeMap;

import org.junit.*;

public class FormTest {
	@Test
	public void zeroUsersTest() {
		Form.clearUsers();
		assertEquals(new Integer(0), Form.userCount());
	}
	@Test
	public void userTaken() {
		Form.addUsers("gabriel");
		Form.addUsers("fausto");
		Form.addUsers("melissa");
		assertEquals(true, Form.userTaken("melissa"));
	}
}
