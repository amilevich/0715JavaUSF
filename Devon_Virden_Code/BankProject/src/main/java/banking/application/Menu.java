package banking.application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

import org.apache.log4j.Logger;

public class Menu implements Serializable {

	private static final long serialVersionUID = -5880092821355035791L;
	protected final static Logger ibis = Logger.getLogger(Account.class);
	private Storage<String, User> users = new Storage<String, User>();
	Storage<Integer, Account> accounts = new Storage<Integer, Account>();
	Storage<Integer, Account> pendingAccounts = new Storage<Integer, Account>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu = menu.open();
		if (menu == null) {
			menu = new Menu();
			menu.addAdmin("Devon", 6842);
		}
		menu.mainMenu();
	}

	private void save() {
		{
			try {
				ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("./Serialization\\menu.txt"));
				writer.writeObject(this);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private Menu open() {
		try {
			ObjectInputStream reader = new ObjectInputStream(new FileInputStream("./Serialization\\menu.txt"));
			Menu menu = (Menu) reader.readObject();
			reader.close();
			return menu;
		} catch (IOException | ClassNotFoundException e) {
			return null;
		}
	}

	void mainMenu() {
		System.out.println(
				"\rWelcome to the Bank\nPlease enter one of the following:\n\t1) Sign In\n\t2) Register New\n\t3) Exit");
		String entry = sc.nextLine();
		sc = new Scanner(System.in);
		if (entry.equals("1") || entry.equalsIgnoreCase("Sign In")) {
			signIn();
		} else if (entry.equals("2") || entry.equalsIgnoreCase("Register") || entry.equalsIgnoreCase("Register New")) {
			register();
		} else if (entry.equals("3") || entry.equalsIgnoreCase("Exit")) {
			System.out.println("Goodbye");
			save();
			System.exit(0);
		} else {
			System.out.println("Invalid Entry");
			mainMenu();
		}
	}

	private void register() {
		System.out.println("\rPlease Choose a Username:");
		String uName = sc.nextLine();
		sc = new Scanner(System.in);
		boolean exists = users.containsKey(uName);
		while (exists) {
			System.out.println("Username taken, try a different username:");
			uName = sc.nextLine();
			sc = new Scanner(System.in);
			exists = users.containsKey(uName);
		}
		System.out.println("Please Enter your Name");
		String name = sc.nextLine();
		sc = new Scanner(System.in);
		Customer newCustomer = new Customer(name, uName);
		newCustomer.setPassword();
		System.out.println("Now please sign in.");
		users.put(uName, newCustomer);
		signIn();
	}

	private void signIn() {
		System.out.println("\rPlease enter Username/ID number:");
		String id = sc.nextLine();
		sc = new Scanner(System.in);
		if (users.containsKey(id)) {
			ibis.info(users.get(id).getName() + " signed in.");
			users.get(id).signIn(this);
		} else {
			System.out.println("User not found.");
			mainMenu();
		}

	}

	void employeeMenu(Employee emp) {
		System.out.println(
				"\rPlease Select from the list:\n\t1) View personal information\n\t2) View all accounts\n\t3) View pending accounts\n\t4) View individual account\n\t5) Approve account\n\t"
						+ "6) Deny Account+\n\t7) Sign out");
		String input = sc.nextLine();
		sc = new Scanner(System.in);
		if (input.equals("1") || input.equalsIgnoreCase("View Personal")
				|| input.equalsIgnoreCase("View Personal Information")) {
			emp.printUser();
		} else if (input.equals("2") || input.equalsIgnoreCase("View all")
				|| input.equalsIgnoreCase("View all accounts")) {
			if (accounts.size() == 0) {
				System.out.println("There are currently no accounts");
			} else {
				ArrayList<Integer> aKey = accounts.allKeys();
				for (int x : aKey) {
					System.out.println(accounts.get(x).identifier());
				}
			}
		} else if (input.equals("3") || input.equalsIgnoreCase("View pending")
				|| input.equalsIgnoreCase("View Pending Accounts")) {
			if (pendingAccounts.size() == 0) {
				System.out.println("No pending accounts");
			} else {
				ArrayList<Integer> aKey = pendingAccounts.allKeys();
				for (int x : aKey) {
					System.out.println(pendingAccounts.get(x).identifier());
				}
			}
		} else if (input.equals("4") || input.equalsIgnoreCase("View individual")
				|| input.equalsIgnoreCase("View inividual account")) {
			System.out.println("Please enter account number");
			try {
				int num = sc.nextInt();
				sc = new Scanner(System.in);
				if (!accounts.containsKey(num)) {
					System.out.println("That account doesn't exist");
				} else {
					accounts.get(num).viewAccount(emp);
				}
			} catch (java.util.InputMismatchException ex) {
				System.out.println("Account numbers should be numbers.");
				employeeMenu(emp);
			}
		} else if (input.equals("5") || input.equalsIgnoreCase("Approve")
				|| input.equalsIgnoreCase("Approve account")) {
			System.out.println("Please enter account number");
			try {
				int num = sc.nextInt();
				sc = new Scanner(System.in);
				if (!accounts.containsKey(num)) {
					System.out.println("That account doesn't exist");
				} else {
					accounts.get(num).approveAccount(emp);
					pendingAccounts.removePending(num);
					ibis.info(emp.getName() + " approved account: " + accounts.get(num));
				}
			} catch (java.util.InputMismatchException ex) {
				System.out.println("Account numbers should be numbers.");
				employeeMenu(emp);
			}
		} else if (input.equals("6") || input.equalsIgnoreCase("Deny") || input.equalsIgnoreCase("Deny account")) {
			System.out.println("Please enter account number");
			try {
				int num = sc.nextInt();
				sc = new Scanner(System.in);
				if (!accounts.containsKey(num)) {
					System.out.println("That account doesn't exist");
				} else {
					if (pendingAccounts.containsKey(num)) {
						ibis.info(emp.getName() + " denied account: " + accounts.get(num));
						pendingAccounts.removePending(num);
						accounts.get(num).purge();
						accounts.remove(num);
					} else {
						System.out.println("This account is not pending.");
					}
				}
			} catch (java.util.InputMismatchException ex) {
				System.out.println("Account numbers should be numbers.");
				employeeMenu(emp);
			}
		} else if (input.equals("7") || input.equalsIgnoreCase("Sign out")) {
			emp.signOut(this);
		} else {
			System.out.println("Invalid Entry");
		}

		employeeMenu(emp);
	}

	void adminMenu(Admin admin) {
		System.out.println(
				"\rPlease Select from the list:\n\t1) View personal information\n\t2) View all accounts\n\t3) View pending accounts\n\t4) View individual account\n\t5) Approve account\n\t6) Close/Deny Account\n\t"
						+ "7) Transactions\n\t8) Add Staff\n\t9) Sign out");
		String input = sc.nextLine();
		sc = new Scanner(System.in);
		if (input.equals("1") || input.equalsIgnoreCase("View Personal")
				|| input.equalsIgnoreCase("View Personal Information")) {
			admin.printUser();
		} else if (input.equals("2") || input.equalsIgnoreCase("View all")
				|| input.equalsIgnoreCase("View all accounts")) {
			if (accounts.size() == 0) {
				System.out.println("There are currently no accounts");
			} else {
				ArrayList<Integer> aKey = accounts.allKeys();
				for (int x : aKey) {
					System.out.println(accounts.get(x).identifier());
				}
			}
		} else if (input.equals("3") || input.equalsIgnoreCase("View pending")
				|| input.equalsIgnoreCase("View Pending Accounts")) {
			if (pendingAccounts.size() == 0) {
				System.out.println("No pending accounts");
			} else {
				ArrayList<Integer> aKey = pendingAccounts.allKeys();
				for (int x : aKey) {
					System.out.println(pendingAccounts.get(x).identifier());
				}
			}
		} else if (input.equals("4") || input.equalsIgnoreCase("View individual")
				|| input.equalsIgnoreCase("View inividual account")) {
			System.out.println("Please enter account number");
			try {
				int num = sc.nextInt();
				sc = new Scanner(System.in);
				if (!accounts.containsKey(num)) {
					System.out.println("That account doesn't exist");
				} else {
					accounts.get(num).viewAccount(admin);
				}
			} catch (java.util.InputMismatchException ex) {
				System.out.println("Account numbers should be numbers.");
				adminMenu(admin);
			}
		} else if (input.equals("5") || input.equalsIgnoreCase("Approve")
				|| input.equalsIgnoreCase("Approve account")) {
			System.out.println("Please enter account number");
			try {
				int num = sc.nextInt();
				sc = new Scanner(System.in);
				if (!accounts.containsKey(num)) {
					System.out.println("That account doesn't exist");
				} else if (!pendingAccounts.containsKey(num)) {
					System.out.println("Account already approved");
				} else {
					accounts.get(num).approveAccount(admin);
					pendingAccounts.removePending(num);
					ibis.info(admin.getName() + " approved account: " + accounts.get(num));
				}
			} catch (java.util.InputMismatchException ex) {
				System.out.println("Account numbers should be numbers.");
				adminMenu(admin);
			}
		} else if (input.equals("6") || input.equalsIgnoreCase("Close") || input.equalsIgnoreCase("Close account")
				|| input.equalsIgnoreCase("Deny") || input.equalsIgnoreCase("Deny account")
				|| input.equalsIgnoreCase("Close/deny") || input.equalsIgnoreCase("Close/deny account")) {
			System.out.println("Please enter account number");
			try {
				int num = sc.nextInt();
				sc = new Scanner(System.in);
				if (!accounts.containsKey(num)) {
					System.out.println("That account doesn't exist");
				} else {
					if (pendingAccounts.containsKey(num)) {
						pendingAccounts.removePending(num);
						ibis.info(admin.getName() + " denied account: " + accounts.get(num));
					} else {
						ibis.info(admin.getName() + " canceled account: " + accounts.get(num));
					}
					accounts.get(num).purge();
					accounts.remove(num);
				}
			} catch (java.util.InputMismatchException ex) {
				System.out.println("Account numbers should be numbers.");
				adminMenu(admin);
			}
		} else if (input.equals("7") || input.equalsIgnoreCase("Transactions")) {
			System.out.println("Please enter account number:");
			try {
				int num = sc.nextInt();
				sc = new Scanner(System.in);
				if (!accounts.containsKey(num)) {
					System.out.println("That account doesn't exist");
				} else {
					transaction(admin, num);
				}
			} catch (java.util.InputMismatchException ex) {
				System.out.println("Account numbers should be numbers.");
				adminMenu(admin);
			}
		} else if (input.equals("8") || input.equalsIgnoreCase("Add staff")) {
			addStaff(admin);
		} else if (input.equals("9") || input.equalsIgnoreCase("Sign out")) {
			admin.signOut(this);
		} else {
			System.out.println("Invalid Entry");
		}

		adminMenu(admin);
	}

	void customerMenu(Customer customer) {
		System.out.println(
				"\rPlease select from the list:\n\t1) View personal information\n\t2) View all accounts\n\t3) View individual account\n\t4) Transactions\n\t5) Open new account\n\t6) Close");
		String input = sc.nextLine();
		sc = new Scanner(System.in);
		if (input.equals("1") || input.equalsIgnoreCase("View Personal")
				|| input.equalsIgnoreCase("View Personal Information")) {
			customer.printUser();
		} else if (input.equals("2") || input.equalsIgnoreCase("View all")
				|| input.equalsIgnoreCase("View all accounts")) {
			ArrayList<Account> personalAccounts = customer.getAccounts();
			if (personalAccounts.size() == 0) {
				System.out.println("There are currently no accounts");
			} else {
				for (Account x : personalAccounts) {
					System.out.println(x.identifier());
				}
			}
		} else if (input.equals("3") || input.equalsIgnoreCase("View individual")
				|| input.equalsIgnoreCase("View inividual account")) {
			System.out.println("Please enter account number");
			try {
				int num = sc.nextInt();
				sc = new Scanner(System.in);
				ArrayList<Account> personalAccounts = customer.getAccounts();
				if (personalAccounts.size() == 0) {
					System.out.println("You have no open accounts yet.");
				} else {
					int x = 0;
					while (x < personalAccounts.size() && personalAccounts.get(x).getNumber() != num) {
						x++;
					}
					if (x == personalAccounts.size()) {
						System.out.println("Account not found");
					} else {
						personalAccounts.get(x).viewAccount(customer);
					}
				}
			} catch (java.util.InputMismatchException ex) {
				System.out.println("Account numbers should be numbers.");
				customerMenu(customer);
			}
		} else if (input.equals("4") || input.equalsIgnoreCase("Transactions")) {
			System.out.println("Please enter account number:");
			try {
				int num = sc.nextInt();
				sc = new Scanner(System.in);
				int x = 0;
				ArrayList<Account> personalAccounts = customer.getAccounts();
				while (x < personalAccounts.size() && personalAccounts.get(x).getNumber() != num) {
					x++;
				}
				if (x == personalAccounts.size()) {
					System.out.println("Account not found");
				} else {
					transaction(customer, personalAccounts.get(x).getNumber());
				}
			} catch (java.util.InputMismatchException ex) {
				System.out.println("Account numbers should be numbers.");
				customerMenu(customer);
			}
		} else if (input.equals("5") || input.equalsIgnoreCase("Open new")
				|| input.equalsIgnoreCase("Open new account")) {
			System.out.println("Please enter a name for the account:");
			String name = sc.nextLine();
			sc = new Scanner(System.in);
			System.out.println("Would you like you like to add anyone to the account? (y/n)");
			String reply = sc.nextLine();
			sc = new Scanner(System.in);
			int accs = 0;
			System.out.println("Please enter opening balance:");
			try {
				double ob = sc.nextDouble();
				sc = new Scanner(System.in);

				int accNum = accounts.size();
				Account newAccount = new Account(name, accNum, ob, customer);
				if (reply.equalsIgnoreCase("y") || reply.equalsIgnoreCase("Yes")) {
					System.out.println("How many would you like to add?");
					accs += sc.nextInt();
					sc = new Scanner(System.in);
				}
				int i = 0;
				while (i < accs) {
					System.out.println("\rPlease enter username of jointee:");
					String joint = sc.nextLine();
					sc = new Scanner(System.in);
					if (users.containsKey(joint)) {
						newAccount.addAccountee((Customer) users.get(joint));
						System.out.println(((Customer) users.get(joint)).getName() + " added.");
						i++;
					} else {
						System.out.println("User not found");
					}
				}
				accounts.put(accNum, newAccount);
				pendingAccounts.put(accNum, newAccount);
				System.out.println("Opened:\t" + newAccount.identifier());
			} catch (java.util.InputMismatchException ex) {
				System.out.println("That was not number. Returning to menu.");
				customerMenu(customer);
			}
		} else if (input.equals("6") || input.equalsIgnoreCase("Sign out")) {
			customer.signOut(this);
		} else {
			System.out.println("Invalid Entry");
		}

		customerMenu(customer);
	}

	private void transaction(User user, int accountNumber) {
		if (!accounts.get(accountNumber).pending()) {
			System.out.println("\rPlease choose one:\n\t1) Withdraw\n\t2) Deposit\n\t3) Transfer\n\t4) Cancel");
			String act = sc.nextLine();
			sc = new Scanner(System.in);
			try {
				if (act.equals("1") || act.equalsIgnoreCase("Withdraw")) {
					System.out.println("Please enter the ammount you would like to withdraw:");
					double withdraw = sc.nextDouble();
					sc = new Scanner(System.in);
					accounts.get(accountNumber).withdraw(withdraw, user);
				} else if (act.equals("2") || act.equalsIgnoreCase("Deposit")) {
					System.out.println("Please enter the ammount you would like to deposit:");
					double deposit = sc.nextDouble();
					sc = new Scanner(System.in);
					accounts.get(accountNumber).deposit(deposit);
				} else if (act.equals("3") || act.equalsIgnoreCase("Tranfer")) {
					System.out.println("Please enter account number you are transferring to:");
					int trans = sc.nextInt();
					sc = new Scanner(System.in);
					if (!accounts.containsKey(trans)) {
						System.out.println("Invalid account.");
					} else {
						System.out.println("Please enter transfer ammount:");
						double transfer = sc.nextDouble();
						sc = new Scanner(System.in);
						accounts.get(accountNumber).transferTo(accounts.get(trans), transfer, user);
					}
				} else if (act.equals("4") || act.equalsIgnoreCase("Cancel")) {
					System.out.println("Returning to user menu");
					if (user.type.equals("ADMIN")) {
						adminMenu((Admin) user);
					} else if (user.type.equals("CUSTOMER")) {
						customerMenu((Customer) user);
					} else {
						System.out.println("Wait, how did YOU get here?\rNo matter.\rGOODBYE.");
						users.remove(((Employee) user).getID());
					}
				} else {
					System.out.println("Invalid entry.");
				}
			} catch (java.util.InputMismatchException ex) {
				System.out.println("That was not a number.");
			} finally {
				transaction(user, accountNumber);
			}
		} else {
			System.out.println("Account pending, cannot edit.");
			if (user.type.equals("ADMIN")) {
				adminMenu((Admin) user);
			} else if (user.type.equals("CUSTOMER")) {
				customerMenu((Customer) user);
			} else {
				System.out.println("Wait, how did YOU get here?\rNo matter.\rGOODBYE.");
				users.remove(((Employee) user).getID());
			}
		}
	}

	public Admin addAdmin(String name, int pin) {
		String id = "@" + users.size();
		Admin newAdmin = new Admin(name, "@" + users.size(), pin);
		users.put(id, newAdmin);
		return newAdmin;
	}

	public Employee addEmployee(String name, int pin) {
		String id = "#" + users.size();
		Employee newEmployee = new Employee(name, "#" + users.size(), pin);
		users.put(id, newEmployee);
		return newEmployee;
	}

	private void addStaff(Admin admin) {
		System.out.println("\rPlease enter staff type: (Admin/Employee)");
		String staffType = sc.nextLine();
		sc = new Scanner(System.in);
		while (!(staffType.equalsIgnoreCase("Admin") || staffType.equalsIgnoreCase("Employee"))) {
			System.out.println("Invalid entry, try again:");
			staffType = sc.nextLine();
			sc = new Scanner(System.in);
		}
		System.out.println("Please Set Name:");
		String name = sc.nextLine();
		sc = new Scanner(System.in);
		boolean loop = true;
		int pin = 0;
		do {
			try {
				System.out.println("\nPlease Set Pin Number:");
				pin = sc.nextInt();
				sc = new Scanner(System.in);
				loop = false;
			} catch (java.util.InputMismatchException ex) {
				sc = new Scanner(System.in);
				System.out.println("That wasn't a number");
				loop = true;
			}
		} while (loop);

		if (staffType.equalsIgnoreCase("Admin")) {
			Admin newAdmin = addAdmin(name, pin);
			System.out.println("New admin added.");
			newAdmin.printUser();
		} else if (staffType.equalsIgnoreCase("Employee")) {
			Employee newEmployee = addEmployee(name, pin);
			System.out.println("New employee added.");
			newEmployee.printUser();

		}
		adminMenu(admin);
	}
}
