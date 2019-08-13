package banking.application;

import java.util.ArrayList;
import java.util.Scanner;
import org.apache.log4j.Logger;
import banking.DAO.AccountDAOImpl;
import banking.DAO.UserDAOImpl;

public class Account {

	protected final static Logger ibis = Logger.getLogger(Account.class);
	private double balance = 0;
	private String name = new String();
	private int number;
	private String status;
	AccountDAOImpl adao = new AccountDAOImpl();
	UserDAOImpl udao = new UserDAOImpl();

	public Account(String name, int number, double balance, String status) {
		super();
		this.balance = balance;
		this.name = name;
		this.number = number;
		this.status = status;
		ibis.info("Account " + name + number + "Opened.\n\tBalance: " + printBalance());
	}

	public Account(double balance, String name) {
		this(name, 0, balance, "Pending");
	}

	public Account(double balance, String name, int number, String status) {
		super();
		this.balance = balance;
		this.name = name;
		this.number = number;
		this.status = status;
	}

	public Account() {
		super();
	}

	public void increment(int index) {
		number = index;
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public boolean canView(User user) {
		if (user.type.equals("ADMIN") || user.type.equals("EMPLOYEE")) {
			return true;
		} else if (adao.isTied(this, user)) {
			return true;

		} else {
			System.out.println("Access Denied.");
			return false;
		}
	}

	public boolean canEdit(User user) {
		if (status.equals("Closed")) {
			System.out.println("Account Closed, Cannot Edit");
			return false;
		} else if (user.type.equals("ADMIN")) {
			return true;
		} else if(adao.isTied(this, user)) {
			return true;
		}
		else {
			System.out.println("Access Denied.");
			return false;
		}
	}

	private void save() {
		adao.updateAccount(this);
	}

	public String identifier() {
		String ident = (number + "\t-\t" + name);
		if (status.equals("Pending")) {
			ident += " (Pending)";
		} else if (status.equals("Closed")) {
			ident += " (Closed)";
		}
		return ident;
	}

	void approveAccount(User user) {
		if (user.type.equals("EMPLOYEE") || user.type.equals("ADMIN")) {
			if (status.equals("Pending")) {
				System.out.println("Account approved.");
				ibis.info("Account " + name + number + "Approved by " + user.getName());
				status = "Open";
				save();
			} else {
				System.out.println("Account already approved.");
				ibis.info(user.getName() + " attempted to reapprove account " + name + number);
				System.out.println();
			}
		} else {
			System.out.println("Access Denied");
			ibis.info(user.getName() + " attempted to approve account " + name + number);
		}
	}

	void deposit(double deposit) {
		if (status.equals("Open")) {
			Scanner scan = new Scanner(System.in);
			while ((deposit * 100) % 1 != 0 || deposit < 0) {
				System.out.println("Please enter a valid value to deposit:");
				try {
					deposit = scan.nextDouble();
					save();
				} catch (java.util.InputMismatchException ex) {
					System.out.println("That is not a number.");
					deposit = -1;
				}
			}
			balance += deposit;
			System.out.println("Account number " + number + "\nCurrent Balance:\t" + printBalance());
			ibis.info("Deposited $" + deposit + " into account " + name + number + ".\n\tBalance: " + printBalance());
		} else if (status.equals("Pending")) {
			System.out.println("Account pending, cannot edit");
		}
	}

	public boolean pending() {
		return status.equals("Pending");
	}

	void withdraw(double withdraw, User user) {

		if (this.canEdit(user)) {
			if ((withdraw * 100) % 1 != 0 && status.equals("Open")) {
				Scanner scan = new Scanner(System.in);
				while ((withdraw * 100) % 1 != 0) {
					System.out.println("Please enter a valid value to deposit:");
					try {
						withdraw = scan.nextDouble();
						save();
					} catch (java.util.InputMismatchException ex) {
						System.out.println("That is not a number.");
						withdraw = -1;
					}
				}
			} else if (balance >= withdraw && status.equals("Open") && withdraw >= 0) {
				balance -= withdraw;
				ibis.info(user.getName() + " withdrew $" + withdraw + " from account " + name + number
						+ ".\n\tBalance: " + printBalance());
				System.out.println("Account number " + number + "\nCurrent Balance:\t" + printBalance());
			} else if (status.equals("Pending")) {
				System.out.println("Account pending, cannot edit");
			} else {
				ibis.info(user.getName() + " attempted to withdraw $" + withdraw + " from account " + name + number
						+ ".\n\tBalance: " + printBalance());
				System.out.println("Withdrawl value exceeds account balance.\nCurrent Balance:\t" + printBalance());
			}
		}
	}

	public String printBalance() {
		String balanceS = new String();
		int tInt = (int) Math.floor(100 * balance);
		balanceS = "$" + ((int) Math.floor(tInt / 100)) + "." + ((int) Math.floor(tInt % 100));
		save();
		return balanceS;
	}

	void addAccountee(User user) {
		adao.tieAccount(this, user);
		save();
	}

	void viewAccount(User user) {
		ArrayList<User> accountees = udao.getTiedUsers(this);
		if (canView(user)) {
			System.out.println("\rNames on account:");
			for (int x = 0; x < accountees.size(); x++) {
				System.out.println("\t" + accountees.get(x).getName());
			}
			System.out.println("\nAccount Name:\t\t" + name + "\nAccount Number:\t\t" + number);
			if (status.equals("Pending")) {
				System.out.println("Account Pending");
			} else if (status.equals("Closed")) {
				System.out.println("Account Closed");
			} else {
				System.out.println("Account balance:\t" + balance);
			}
		}
	}

	void purge() {
		status = "Closed";
		adao.closeAccount(this.number);
		save();
	}

	void transferTo(Account account, double ammount, User user) {
		if (canEdit(user)) {
			if (balance >= ammount && status.equals("Open") && ammount >= 0) {
				this.withdraw(ammount, user);
				account.deposit(ammount);
				ibis.info(user.getName() + " transferred $" + ammount + " from account " + name + number + "to account "
						+ account.getNumber() + account.getNumber() + ".");
			} else if (status.equals("Pending")) {
				System.out.println("Account pending, cannot edit");
			} else if (ammount < 0) {
				System.out.println("Please enter a valid ammount to transfer");
				ibis.info(user.getName() + " attempted to transfer $" + ammount + " from account " + name + number
						+ "to account " + account.getNumber() + account.getNumber() + ".");
			} else {

				ibis.info(user.getName() + " attempted to transfer $" + ammount + " from account " + name + number
						+ "to account " + account.getNumber() + account.getNumber() + ".");
				System.out
						.println("Transfer value exceeds account balance.\nCurrent Balance:\t\"\r\n" + printBalance());
			}
		}
		save();
	}

	public String getStatus() {
		return status;
	}

	public double getBalance() {
		return balance;
	}
}
