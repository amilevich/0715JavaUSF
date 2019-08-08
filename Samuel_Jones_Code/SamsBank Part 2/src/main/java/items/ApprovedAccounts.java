package items;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import Menus.AdminMenu;
import Menus.CustomerMenu;
import Menus.EmployeeMenu;
import Menus.MainMenu;
import Users.Admin;
import Users.Employee;

public class ApprovedAccounts implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5878601051619539591L;
	static HashMap<String, Account> approvedAccounts = new HashMap<String, Account>();
	private static Scanner sc = new Scanner(System.in);
	private static final Admin admin = new Admin();
	private static final Employee emp = new Employee();

	
	public static void addAll(ArrayList<Account> data) {
		for (Account a : data) {
			approvedAccounts.put(a.getUsername(), a);
		}
	}

	public static void deserialize() throws FileNotFoundException {
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts.addAll(Persistence.readData("./approvedaccounts.txt"));
		addAll(accounts);
	}

	public static void serializeAll() {
		ArrayList<Account> accounts = fetchAll();
		Persistence.writeList(accounts, "approvedaccounts");
	}

	// methods for approved accounts hashmap
	public static void addOne(String username, Account account) {
		approvedAccounts.put(username, account); // put it into the hashmap
		serializeAll();
	}
// method to display all approved accounts
	public static void displayAll() {
		ArrayList<Account> all = fetchAll();
		for(Account a: all) {
			System.out.println(a.toString());
		}
	}
	public static ArrayList<Account> fetchAll() {
		ArrayList<Account> list = new ArrayList<Account>();
		Set<String> keys = approvedAccounts.keySet();
		for (String key : keys) {
			Account a = approvedAccounts.get(key);
			list.add(a);
		}
		if (approvedAccounts.isEmpty()) {
			System.out.println("No approved accounts.");
		}

		return list;
	}

	public static Account fetchOne(String username) {
		Set<String> keys = approvedAccounts.keySet();
		Account account = null;
		for (String u : keys) {
			if (username.equals(u)) {
				account = approvedAccounts.get(u);
			}
		}
		return account;
	}

	public static void updateOne(Account a) {
		approvedAccounts.replace(a.getUsername(), a);
		serializeAll(); 
	}

	public static void removeOne(String username) {
		Account a = fetchOne(username);
		if (a == null) {
			AdminMenu.mainMenu();
		} else {
			approvedAccounts.remove(username);
			serializeAll();
		}
	}

	// login methods

	public static void customerLogin() {
		Account a = null;

		sc = new Scanner(System.in);
		System.out.println("Enter username.");
		String u = sc.nextLine();
		System.out.println("Enter password");
		String pw = sc.nextLine();
		a = fetchOne(u);
		if (a == null) {
			System.out.println("Account does not exist.");
			MainMenu.mainMenu();
		} else if (pw.equals(a.getPassword())) {
			CustomerMenu.actionMenu(a);
		} else {
			System.out.println("Incorrect password. Entered " + pw + "On file: " + a.getPassword());
			System.out.println(a.toString());
			MainMenu.mainMenu();
		}
	}

	public static void employeeLogin() {
		sc = new Scanner(System.in);
		System.out.println("Enter username.");
		String u = sc.nextLine();
		System.out.println("Enter password");
		String pw = sc.nextLine();

		if (u.equals(emp.getUsername()) && pw.equals(emp.getPassword())) {
			System.out.println("Login success");
			EmployeeMenu.actionMenu();
		} else {
			System.out.println("Incorrect login creds");
			MainMenu.firstLoginMenu();
		}
	}

	public static void adminLogin() {
		sc = new Scanner(System.in);
		System.out.println("Enter username.");
		String u = sc.nextLine();
		System.out.println("Enter password");
		String pw = sc.nextLine();
		if (u.equals(admin.getUsername()) && pw.equals(admin.getPassword())) {
			System.out.println("Login success");
			AdminMenu.mainMenu();
		} else {
			System.out.println("Incorrect login creds");
			MainMenu.firstLoginMenu();
		}
	}
	// New code for altering user information (unimplemented) *********************************************
//		public static Account edit(Account a, String changeMe, String changeTo) {
//			if(changeMe.equals("firstname")) {
//				a.setFirstname(changeTo);
//			}
//			else if(changeMe.equals("lastname")) {
//				a.setLastname(changeTo);
//			}
//			else if(changeMe.equals("jointFirst")) {
//				a.setJointFirst(changeTo);
//			}
//			else if(changeMe.equals("jointLast")) {
//				a.setJointLast(changeTo);
//			}
//			else {
//				System.out.println("Please pick from the menu.");
//			}
//			updateOne(a);
//			return a;
//		}
}
