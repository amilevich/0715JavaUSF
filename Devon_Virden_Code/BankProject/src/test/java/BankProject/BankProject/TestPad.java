package BankProject.BankProject;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import banking.application.Account;
import banking.application.Admin;
import banking.application.Customer;
import banking.application.Employee;
import banking.application.Menu;
import banking.application.Storage;

public class TestPad {

	Admin ad = new Admin("Bob", "@4", 6589);
	Employee emp = new Employee("Rob", "#5", 5945);
	Customer cust = new Customer("Edward", "fullMetal");
	Account acc = new Account("Checking", 11545, 4445.45, cust);
	Storage<Integer, Admin> store = new Storage<Integer, Admin>();

	@Test
	public void empNameTest() {
		assertEquals("Employee Name Test", "Rob", emp.getName());
	}

	@Test
	public void customerNameTest() {
		assertEquals("Customer Name Test", "Edward", cust.getName());
	}

	@Test
	public void adminNameTest() {
		assertEquals("Admin Name Test", "Bob", ad.getName());
	}

	@Test
	public void getAccoutsTest() {
		ArrayList<Account> acList = new ArrayList<Account>();
		acList.add(acc);
		assertEquals("Customer Get Accounts Test", acList, cust.getAccounts());
	}

	@Test
	public void printBalanceTest() {
		assertEquals("Account Print Balance Test", "$4445.45", acc.printBalance());
	}

	@Test
	public void canViewEmployeeTest() {
		assertEquals("Employee Can View Test", true, acc.canView(emp));
	}

	@Test
	public void canViewAdminTest() {
		assertEquals("Admin Can View Test", true, acc.canView(ad));
	}

	@Test
	public void canViewCustomerTest() {
		assertEquals("Customer Can View Test", true, acc.canView(cust));
	}

	@Test
	public void canEditEmployeeTest() {
		assertEquals("Employee Can View Test", false, acc.canEdit(emp));
	}

	@Test
	public void canEditAdminTest() {
		assertEquals("Admin Can View Test", true, acc.canEdit(ad));
	}

	@Test
	public void canEditCustomerTest() {
		assertEquals("Customer Can View Test", true, acc.canEdit(cust));
	}

	@Test
	public void identifierTest() {
		assertEquals("Account Identifier Test", "Checking\t-\t11545 (Pending)", acc.identifier());
	}

	@Test
	public void pendingTest() {
		assertEquals("Account Pending Test", true, acc.pending());
	}

	@Test
	public void addEmployeeTest() {
		Menu menu = new Menu();
		Employee e1m1 = new Employee("Abaddon", "#0", 0666);
		assertEquals("Menu Add Employee Test", e1m1.toString(), menu.addEmployee("Abaddon", 0666).toString());
	}

	@Test
	public void addAdminTest() {
		Menu menu = new Menu();
		Admin a1SteakSauce = new Admin("Abaddon", "@0", 0666);
		assertEquals("Menu Add Admin Test", a1SteakSauce.toString(), menu.addAdmin("Abaddon", 0666).toString());
	}

	@Test
	public void employeeToString() {
		assertEquals("Employee To String Test", "[RobEMPLOYEE5945#5]", emp.toString());
	}

	@Test
	public void adminToString() {
		assertEquals("Admin To String Test", "[BobADMIN6589@4]", ad.toString());
	}

	@Test
	public void customerToString() {
		assertEquals("Customer To String Test", "[EdwardCUSTOMERfullMetal]", cust.toString());
	}

	@Test
	public void containsTest() {
		store.put(42, ad);
		assertEquals("Storage Contains Test", true, store.containsKey(42));
	}

	@Test
	public void getTest() {
		store.put(42, ad);
		assertEquals("Storage Get Test", ad, store.get(42));
	}

	@Test
	public void allKeysTest() {
		store.put(42, ad);
		ArrayList<Integer> key = new ArrayList<Integer>();
		key.add(42);
		assertEquals("Storage All Keys Test", key, store.allKeys());
	}

	@Test
	public void sizeTest() {
		store.put(42, ad);
		assertEquals("Storage Size Test", 1, store.size());
	}
}
