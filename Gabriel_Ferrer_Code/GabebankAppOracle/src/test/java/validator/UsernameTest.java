package validator;

import utility.validator.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UsernameTest {
	@Test
	public void usernameHasNoSpecialCharacters() {
		assertEquals("special characters are not allowed in usernames", false, UsernameValidator.isValid("gHTvd$2!"));
	}
	@Test
	public void usernameHasNoUppercaseLetters() {
		assertEquals("uppercase letters are not allowed in usernames", false, UsernameValidator.isValid("CatIsCute"));
	}
	
	@Test
	public void cantStartWithNumber() {
		assertEquals("usernames should not start with numbers", false, UsernameValidator.isValid("99cents"));
	}
}
