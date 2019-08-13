import static org.junit.Assert.*;

import org.junit.Test;

import com.banking.menus.CustomerMenu;

public class TransactionTesting {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	
	
	CustomerMenu cmenu = new CustomerMenu();
	
	@Test
	public void isNotNegative() {
		assertEquals("should return true",true,cmenu.isPositive(10));
	}
	
	@Test
	public void inRangeOfBalance() {
		assertEquals("should return true", true,cmenu.inRangeOfBalance(2, 20)); 
	}
	
	
	

}
