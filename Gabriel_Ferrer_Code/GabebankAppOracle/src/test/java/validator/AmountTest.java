package validator;

import utility.validator.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class AmountTest {
	@Test
	public void nonNegativeAmounts() {
		assertEquals("nonNegativeAmounts not allowed", false, AmountValidator.isValid(100) == AmountValidator.isValid(-100));
	}
	@Test
	public void noMoreThanTwoDecimals() {
		assertEquals("noMoreThanTwoDecimals ok", false, AmountValidator.isValid(100.9087));
	}

}
