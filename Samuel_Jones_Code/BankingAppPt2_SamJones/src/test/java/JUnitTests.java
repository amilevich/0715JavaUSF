import static org.junit.Assert.assertEquals;

import org.junit.Test;

import beans.Account;
import beans.User;
import dao.Transaction;

public class JUnitTests {
	Transaction t = new Transaction();
	Account a = new Account(1000.0,0);
	User u = new User("Pam","pw");
	
}
