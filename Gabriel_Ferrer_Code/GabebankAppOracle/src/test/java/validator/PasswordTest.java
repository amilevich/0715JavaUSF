package validator;

import utility.validator.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PasswordTest {
	@Test
	public void atLeast8Characters() {
		assertEquals("password must have at least 8 characters", true, PasswordValidator.isMoreThan(8,"gHTvd$2!".length()));
	}
	@Test
	public void hasSpecialCharacters() {
		assertEquals("password must have special characters", true, PasswordValidator.hasSpecialCharacters("gHTvd$2!"));
	}
	
	@Test
	public void hasLowerCase() {
		assertEquals("password must have lowercase letters", true, PasswordValidator.hasSmallLetters("gHTvd$2!"));
	}
	@Test
	public void hasUpperCase() {
		assertEquals("password must have uppercase letters", true, PasswordValidator.hasCapitalLetters("gHTvd$2!"));
	}
}
