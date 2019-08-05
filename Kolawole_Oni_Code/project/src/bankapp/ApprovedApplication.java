package bankapp;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//import org.apache.log4j.Logger;
import Menus.AdminMenu;
import Menus.CustomerMenu;
import Menus.EmployeeMenu;
import Menus.MainMenu;
import Users.Admin;
import Users.Employee;
	//public class ApprovedApplication implements Serializable {
	/**
	 * 
	 */
	public class ApprovedApplication implements Serializable{
		
		
	private static final long serialVersionUID = -5987654345354788L;
	static HashMap<String, Account> approvedapplications = new HashMap<String, Account>();
	private static Scanner sc = new Scanner(System.in);
	private static final Admin admin = new Admin();
	private static final Employee emp = new Employee();
	//private static Logger log = Logger.getLogger(ApprovedAccounts.class);

	// add test peoples
	public static void addDummies() {
		addOne("testa", new Account("testa","testa",10000,"testa","testa"));
		PendingApplication.addOne("testp", new Account("testp","testp",10000,"testp","testp"));
	}
	public static void addAll(Object obj) {
		List<Object> approvedList = new ArrayList<>();
		approvedList.add(obj);
		
		for(Object object: approvedList) {
			Account cast = (Account) object;
			approvedapplications.put(cast.getUsername(), cast);
		}
		
	}
	
	public static void deserialize() throws FileNotFoundException {
		List<Account> accounts = new ArrayList<>();
		System.out.println("deserialize inside of approved.");
		accounts.add((Account)Login.readData("./approvedaccounts.txt"));
		
		//For each account in the list of account you add each of account
		for(Account a : accounts) {
			addAll(a);
		}
	}
	// methods for approved accounts hashmap
	public static void addOne(String username, Account account) {
		approvedapplications.put(username, account);
		Login.writeData(account, "approvedaccounts");
		System.out.println("Put into approved accounts.");
	}
	public static void fetchAll(){
		Set<String> keys = approvedapplications.keySet();
		for(String u: keys) {
			System.out.println("All Users");
			System.out.println("Username: " + u);
		}
	}
	
	public static void serializeAll() {
		//List<Account> accounts = fetchAll();
		//Login.writeList(accounts, "approvedapplications");
	}
	public static Account fetchOne(String username) {
		Set<String> keys = approvedapplications.keySet();
		Account account = null;
		for (String u: keys) {
			if(username.equals(u)) {
				 account = approvedapplications.get(u);
			}
			else {
				System.out.println("Account not found.");
				MainMenu.mainMenu();
			}
			}
		return account;
		
	}
	
	public static void updateOne(Account a) {
		approvedapplications.replace(a.getUsername(), a);
		System.out.println("New balance for " + a.getUsername() + " is " + a.getBalance());
		//serializeAll(); // calls fetchAll, which creates an arraylist of current accounts, and then
						// calls writeList and writes them to a file
	}
	public static void removeOne(String username) {
		Account a = fetchOne(username);
		if(a!=null) {
			approvedapplications.remove(username);
			Login.updateApprovedData(a);
		}
			else {
				System.out.println("Account not found");
				AdminMenu.mainMenu();
			}
		}
	public static void CustomerLogin() {
		String u = "";
		String pw ="";
		System.out.println("Enter a username and password separated by a space");
		String usernamePW[] = sc.nextLine().split("\\s+");
		try {
			u += usernamePW[0];
			pw += usernamePW[1];
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Enter username + space + password");
		}
			if(u.equals(admin.getUsername()) && pw.equals(admin.getPassword())) {
			System.out.println("Login success");
			CustomerMenu.loginMenu();
		}
		else {
			System.out.println("Incorrect login creds");
			MainMenu.LoginMenu();
		}
	}
	// login methods
	/*public static void customerLogin() {
		Account a = null;
		sc.nextLine();
		System.out.println("Enter a username and password separated by a space");
		String usernamePW[] = sc.nextLine().split("\\s+");

		String u = " ";
		String pw = "  ";
		
			try {
				u += usernamePW[0];
				pw += usernamePW[1];
				a = fetchOne(u);
				if(a==null) {
					System.out.println("No user found.");
					MainMenu.mainMenu();
				}
				else if(pw.equals(a.getPassword())){
					CustomerMenu.actionMenu(a);
				}
				else {
					System.out.println("Incorrect password.");
					MainMenu.mainMenu();
				}
			} catch(ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
				System.out.println("Enter username + space + password");
			} 
		}
		*/
	public static void employeeLogin() {
		sc.nextLine();
		System.out.println("Enter a username and password separated by a space");
		String usernamePW[] = sc.nextLine().split("\\s+");

		//setting username and password to one one
		String u = " ";
		String pw = " ";
		try {
			u += usernamePW[0];
			pw += usernamePW[1];
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Enter username + space + password");
		}
		
		
		if(u.equals(emp.getUsername()) && pw.equals(emp.getPassword())) {
			System.out.println("Login success");
			EmployeeMenu.actionMenu();
		}
		else {
			System.out.println("Incorrect login creds");
			MainMenu.LoginMenu();
		}
	}
	public static void adminLogin() {
		String u = "";
		String pw ="";
		System.out.println("Enter a username and password separated by a space");
		String usernamePW[] = sc.nextLine().split("\\s+");
		try {
			u += usernamePW[0];
			pw += usernamePW[1];
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Enter username + space + password");
		}
			if(u.equals(admin.getUsername()) && pw.equals(admin.getPassword())) {
			System.out.println("Login success");
			AdminMenu.mainMenu();
		}
		else {
			System.out.println("Incorrect login creds");
			MainMenu.LoginMenu();
		}
	}


	}
