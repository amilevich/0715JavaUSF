package BankProject.BankProject;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import banking.DAO.AccountDAOImpl;
import banking.DAO.UserDAOImpl;
import banking.application.Account;
import banking.application.Admin;
import banking.application.Customer;
import banking.application.Employee;
import banking.application.Menu;
import banking.application.Storage;
import banking.application.User;

public class TestPad {

	UserDAOImpl udao = new UserDAOImpl();
	AccountDAOImpl adao = new AccountDAOImpl();
	User user = udao.getUser("Vandal");
	Account acc = adao.getAccount(1022);
	Storage<Integer, Admin> store = new Storage<Integer, Admin>();

	@Test
	public void printBalanceTest() {
		assertEquals("Account Print Balance Test", "$68679.78", acc.printBalance());
	}

	@Test
	public void canViewTest() {
		assertEquals("Can View Test", true, acc.canView(user));
	}

	@Test
	public void canEditTest() {
		assertEquals("Can View Test", true, acc.canEdit(user));
	}

	@Test
	public void identifierTest() {
		assertEquals("Account Identifier Test", "1022\t-\tJoint Checking", acc.identifier());
	}

	@Test
	public void pendingTest() {
		assertEquals("Account Pending Test", false, acc.pending());
	}

	@Test
	public void toStringTest() {
		assertEquals("To String Test", "[James StevensonCUSTOMERUntoDawnVandal]", user.toString());
	}

	@Test
	public void containsIntTest() {
		assertEquals("Storage Contains Test", false, store.containsKey(0));
	}

	@Test
	public void containsStringTest() {
		assertEquals("Storage Contains Test", true, store.containsKey("Vandal"));
	}


	@Test
	public void sizeTest() {
		store.setSize(udao.size());
		assertEquals("Storage Size Test (also tests dao size)", true, store.size() > 0);
	}

	@Test
	public void getAccountsTest() {
		assertEquals("Getting the list test", true, adao.getAllAccounts().size() > 0);
	}


	@Test
	public void getAccountTest() {
		assertEquals("Getting the account test", acc.getName(), adao.getAccount(1022).getName());
	}
	
	@Test
	public void getAccountName() {
		assertEquals("Getting the account name test", acc.getName(), adao.getAccount(1022).getName());
	}
	
	@Test
	public void getAccountNumber() {
		assertEquals("Getting the account number test", acc.getNumber(), adao.getAccount(1022).getNumber());
	}
	
	@Test
	public void getAccountBalance() {
		assertEquals("Getting the account balance test", true, adao.getAccount(1022).getBalance()==acc.getBalance());
	}
	
	@Test
	public void getAccountStatus() {
		assertEquals("Getting the account status test", acc.getStatus(), adao.getAccount(1022).getStatus());
	}
	
	@Test
	public void getPending() {
		assertEquals("Getting the pending list test", false, adao.viewPending().size() > 0);
	}
	
	@Test
	public void getArePending() {
		assertEquals("Getting whether there are pending accounts test", false, adao.findPending());
	}
}
