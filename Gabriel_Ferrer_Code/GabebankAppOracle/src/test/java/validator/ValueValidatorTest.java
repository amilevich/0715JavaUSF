package validator;

import utility.validator.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ValueValidatorTest {
	@Test
	public void lowerCaseCurrency() {
		assertEquals("eur is a valid input", true, ValueValidator.isCurrencyValid("eur"));
		assertEquals("usd is a valid input", true, ValueValidator.isCurrencyValid("usd"));
		assertEquals("jpy is an invalid input", false, ValueValidator.isCurrencyValid("jpy"));
	}
}
