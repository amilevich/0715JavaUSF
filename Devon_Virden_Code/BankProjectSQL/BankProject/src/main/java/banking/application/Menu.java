package banking.application;

import java.util.ArrayList;
import java.util.Scanner;
import org.apache.log4j.Logger;
import banking.DAO.AccountDAOImpl;
import banking.DAO.Committer;
import banking.DAO.UserDAOImpl;

public class Menu {

	protected final static Logger ibis = Logger.getLogger(Account.class);
	private Storage<String, User> users = new Storage<String, User>();
	Storage<Integer, Account> accounts = new Storage<Integer, Account>();
	static Scanner sc = new Scanner(System.in);
	AccountDAOImpl adao = new AccountDAOImpl();
	UserDAOImpl udao = new UserDAOImpl();

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu = new Menu();
		menu.set();
		menu.mainMenu();
	}

	private void set() {
		users.setSize(udao.size());
		accounts.setSize(adao.size());
		if (users.size == 0) {
			this.addAdmin("Devon", "6842");
		}
	}

	void mainMenu() {
		System.out.println(
				"\rWelcome to Kayr/Bhaeros Bank\nPlease enter one of the following:\n\t1) Sign In\n\t2) Register New\n\t3) Exit");
		String entry = sc.nextLine();
		sc = new Scanner(System.in);
		if (entry.equals("1") || entry.equalsIgnoreCase("Sign In")) {
			signIn();
		} else if (entry.equals("2") || entry.equalsIgnoreCase("Register") || entry.equalsIgnoreCase("Register New")) {
			register();
		} else if (entry.equals("3") || entry.equalsIgnoreCase("Exit")) {
			System.out.println("Goodbye");
			Committer.commit();
			System.exit(0);
		} else {
			System.out.println("Invalid Entry");
			mainMenu();
		}
	}

	private void register() {

		String uName = "";
		while (uName.length() > 15 || uName.length() < 5 || uName.charAt(0) == '@' || uName.charAt(0) == '#') {
			System.out.println(
					"\rPlease Choose a Username (Must be between 5 and 15 characters, cannot begin with \"@\" or\"#\"):");
			uName = sc.nextLine();
			sc = new Scanner(System.in);
		}
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
						+ "6) Deny Account\n\t7) Update name\n\t8) Sign out");
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
				ArrayList<Account> accs = adao.getAllAccounts();
				for (Account i : accs) {
					System.out.println(i.identifier());
				}
			}
		} else if (input.equals("3") || input.equalsIgnoreCase("View pending")
				|| input.equalsIgnoreCase("View Pending Accounts")) {
			if (!adao.findPending()) {
				System.out.println("No pending accounts");
			} else {
				ArrayList<Account> accs = adao.viewPending();
				for (Account i : accs) {
					System.out.println(i.identifier());
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
					if (accounts.containsKey(num)) {
						ibis.info(emp.getName() + " denied account: " + accounts.get(num));
						System.out.println("Account Denied.");
						accounts.get(num).purge();
					} else {
						System.out.println("This account is not pending.");
					}
				}
			} catch (java.util.InputMismatchException ex) {
				System.out.println("Account numbers should be numbers.");
				employeeMenu(emp);
			}
		}else if (input.equals("7") || input.equalsIgnoreCase("Update")|| input.equalsIgnoreCase("Update Name")) {
			emp.changeName(this);
		} else if (input.equals("8") || input.equalsIgnoreCase("Sign out")) {
			emp.signOut(this);
		} else {
			System.out.println("Invalid Entry");
		}
		employeeMenu(emp);
	}

	void adminMenu(Admin admin) {
		System.out.println(
				"\rPlease Select from the list:\n\t1) View personal information\n\t2) View all accounts\n\t3) View pending accounts\n\t4) View individual account\n\t5) Approve account\n\t6) Close/Deny Account\n\t"
						+ "7) Transactions\n\t8) Add Staff\n\t9) Update name\n\t10) Sign out");
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
				ArrayList<Account> accs = adao.getAllAccounts();
				for (Account i : accs) {
					System.out.println(i.identifier());
				}
			}
		} else if (input.equals("3") || input.equalsIgnoreCase("View pending")
				|| input.equalsIgnoreCase("View Pending Accounts")) {
			if (!adao.findPending()) {
				System.out.println("No pending accounts");
			} else {
				ArrayList<Account> accs = adao.viewPending();
				for (Account i : accs) {
					System.out.println(i.identifier());
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
				} else if (!adao.findPending(num)) {
					System.out.println("Account already approved");
				} else {
					accounts.get(num).approveAccount(admin);
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
					if (adao.findPending(num)) {
						System.out.println("Account Denied.");
						ibis.info(admin.getName() + " denied account: " + accounts.get(num));
					} else {
						System.out.println("Account Closed.");
						ibis.info(admin.getName() + " closed account: " + accounts.get(num));
					}
					accounts.get(num).purge();
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
		}else if (input.equals("9") || input.equalsIgnoreCase("Update")|| input.equalsIgnoreCase("Update Name")) {
			admin.changeName(this);
		} else if (input.equals("10") || input.equalsIgnoreCase("Sign out")) {
			admin.signOut(this);
		} else {
			System.out.println("Invalid Entry");
		}
		adminMenu(admin);
	}

	void customerMenu(Customer customer) {
		System.out.println(
				"\rPlease select from the list:\n\t1) View personal information\n\t2) View all accounts\n\t3) View individual account\n\t4) Transactions\n\t5) Open new account\n\t6) Update name\n\t7) Change password\n\t8) Close");
		String input = sc.nextLine();
		sc = new Scanner(System.in);
		if (input.equals("1") || input.equalsIgnoreCase("View Personal")
				|| input.equalsIgnoreCase("View Personal Information")) {
			customer.printUser();
		} else if (input.equals("2") || input.equalsIgnoreCase("View all")
				|| input.equalsIgnoreCase("View all accounts")) {
			ArrayList<Account> personalAccounts = adao.getTiedAccounts(customer);
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
				Account account = accounts.get(num);
				if (account.canView(customer)) {
					account.viewAccount(customer);
				} else {
					System.out.println("Account not found");
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
				Account account = accounts.get(num);
				if (!accounts.containsKey(num)) {
					System.out.println("Account does not exist.");
				} else if (account.canEdit(customer)) {
					transaction(customer, account.getNumber());
				} else {
					System.out.println("Unable to perform transaction");
				}
			} catch (java.util.InputMismatchException ex) {
				System.out.println("Account numbers should be numbers.");
				customerMenu(customer);
			}
		} else if (input.equals("5") || input.equalsIgnoreCase("Open new")
				|| input.equalsIgnoreCase("Open new account"))

		{
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
				while (((ob * 100) % 1) >= 1 || ob < 0) {
					System.out.println("Please enter a valid value to deposit:");
					ob = sc.nextDouble();
					sc = new Scanner(System.in);
				}
				Account newAccount = new Account(ob, name);
				accounts.put(newAccount);
				newAccount.increment(adao.retrieve());
				int custs = (udao.getCustomers() - 1);
				if (reply.equalsIgnoreCase("y") || reply.equalsIgnoreCase("Yes")) {
					int add = 0;
					do {
						System.out.println("How many would you like to add? (Maximum: " + custs + ")");
						add = sc.nextInt();
						sc = new Scanner(System.in);
					} while (add > custs);
					accs += add;
				}
				newAccount.addAccountee(customer);
				int i = 0;
				ArrayList<User> added = new ArrayList<User>();
				while (i < accs) {
					System.out.println("\rPlease enter username of jointee:");
					String joint = sc.nextLine();
					sc = new Scanner(System.in);
					if (users.containsKey(joint)) {
						User user = users.get(joint);
						if ((!added.contains(user)) && user.getType().equals("CUSTOMER")) {
							newAccount.addAccountee(user);
							added.add(user);
							System.out.println(user.getName() + " added.");
							i++;
						} else {
							System.out.println("Cannot add user");
						}
					} else {
						System.out.println("User not found");
					}
				}
				System.out.println("Opened:\t" + newAccount.identifier());
			} catch (java.util.InputMismatchException ex) {
				System.out.println("That was not number. Returning to menu.");
				customerMenu(customer);
			}
		} else if (input.equals("6") || input.equalsIgnoreCase("Update")|| input.equalsIgnoreCase("Update Name")) {
			customer.changeName(this);
		}else if (input.equals("7") || input.equalsIgnoreCase("Change")|| input.equalsIgnoreCase("Change Password")) {
			customer.changePassword(this);
		}else if (input.equals("8") || input.equalsIgnoreCase("Sign out")) {
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
			}
		}
	}

	public void addAdmin(String name, String pin) {
		String id = "@" + users.size();
		Admin newAdmin = new Admin(name, "@" + users.size(), pin, "New");
		users.put(id, newAdmin);
		newAdmin.printUser();
		;
	}

	public void addEmployee(String name, String pin) {
		String id = "#" + users.size();
		Employee newEmployee = new Employee(name, "#" + users.size(), pin, "New");
		users.put(id, newEmployee);
		newEmployee.printUser();
		;
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
		String pinS = new String();
		do {
			try {
				System.out.println("\nPlease Set Four Digit Pin Number:");
				pin = sc.nextInt();
				sc = new Scanner(System.in);
				loop = false;
				Integer i = pin;
				pinS = i.toString();
				if (pinS.length() != 4) {
					System.out.println("Pin number must be four digits");
					loop = true;
				}
			} catch (java.util.InputMismatchException ex) {
				sc = new Scanner(System.in);
				System.out.println("That wasn't a number");
				loop = true;
			}
		} while (loop);

		if (staffType.equalsIgnoreCase("Admin")) {
			addAdmin(name, pinS);
			System.out.println("New admin added.");
		} else if (staffType.equalsIgnoreCase("Employee")) {
			addEmployee(name, pinS);
			System.out.println("New employee added.");
		}
		adminMenu(admin);
	}
}
