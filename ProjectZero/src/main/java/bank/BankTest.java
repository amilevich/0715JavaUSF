//package bank;
//
//import static org.junit.Assert.assertEquals;
//import bank.User;
//import bank.Bank;
//import bank.Admin;
//
//import org.junit.Test;
//
//public class BankTest {
//
//	User bank = new User();
//	//change login back to default(set as public for JUnit test)
//	//change findAccount back to protected after(set as public for JUnit test)
//	//change load back to 
//	
//	@Test
//	public void loginTest() {
//		User.load();
//		assertEquals("Should return true", true, bank.login("tom","t"));
//		System.out.println("method to check if correct username and password");
//	}
//	
//	@Test
//	public void findAccountTest() {
//		User.load();
//		assertEquals("Should return true", true, bank.findAccount("admin"));
//		System.out.println("method to check if account is created");
//	}
//
//}
