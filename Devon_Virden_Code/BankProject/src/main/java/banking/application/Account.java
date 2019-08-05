package banking.application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Account implements Serializable {

	private static final long serialVersionUID = 5128099606350422345L;
	protected final static Logger ibis = Logger.getLogger(Account.class);
	private double balance = 0;
	private boolean pending = true;
	private String name = new String();
	private ArrayList<Customer> accountees = new ArrayList<Customer>();
	private int number;

	public Account(String accountName, int accountNumber, double openingBalance, Customer user) {
		while ((openingBalance * 100) % 1 != 0 || openingBalance < 0) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter a valid value to deposit:");
			openingBalance = sc.nextDouble();
		}
		name = accountName;
		balance = openingBalance;
		number = accountNumber;
		this.addAccountee(user);
		save();
		ibis.info("Account " + name + number + "Opened.\n\tBalance: " + printBalance());
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public boolean canView(User user) {
		if (accountees.contains(user) || user.type.equals("ADMIN") || user.type.equals("EMPLOYEE")) {
			return true;
		} else {
			System.out.println("Access Denied.");
			return false;
		}
	}

	public boolean canEdit(User user) {
		if (accountees.contains(user) || user.type.equals("ADMIN")) {
			return true;
		} else {
			System.out.println("Access Denied.");
			return false;
		}
	}

	private void save() {
		try {
			ObjectOutputStream writer = new ObjectOutputStream(
					new FileOutputStream("./Serialization\\acc_" + name + "_" + number + ".txt"));
			writer.writeObject(this);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String identifier() {
		String ident = (name + "\t-\t" + number);
		if (pending) {
			ident += " (Pending)";
		}
		return ident;
	}

	void approveAccount(User user) {
		if (user.type.equals("EMPLOYEE") || user.type.equals("ADMIN")) {
			if (pending) {
				System.out.println("Account approved.");
				ibis.info("Account " + name + number + "Approved by " + user.getName());
				pending = false;
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
		if (!pending) {
			while ((deposit * 100) % 1 != 0 || deposit < 0) {
				System.out.println("Please enter a valid value to deposit:");
				try {
					Scanner sc = new Scanner(System.in);
					deposit = sc.nextDouble();

				} catch (java.util.InputMismatchException ex) {
					System.out.println("That is not a number.");
					deposit = -1;
				}
			}
			balance += deposit;
			System.out.println("Account number " + number + "\nCurrent Balance:\t" + printBalance());
			ibis.info("Deposited $" + deposit + " into account " + name + number + ".\n\tBalance: " + printBalance());
		} else if (pending) {
			System.out.println("Account pending, cannot edit");
		}
	}

	public boolean pending() {
		return pending;
	}

	void withdraw(double withdraw, User user) {

		if (this.canEdit(user)) {
			if ((withdraw * 100) % 1 != 0 && !pending) {
				while ((withdraw * 100) % 1 != 0) {
					System.out.println("Please enter a valid value to deposit:");
					try {
						Scanner sc = new Scanner(System.in);
						withdraw = sc.nextDouble();

					} catch (java.util.InputMismatchException ex) {
						System.out.println("That is not a number.");
						withdraw = -1;
					}
				}
			} else if (balance >= withdraw && !pending && withdraw >= 0) {
				balance -= withdraw;
				ibis.info(user.getName() + " withdrew $" + withdraw + " from account " + name + number
						+ ".\n\tBalance: " + printBalance());
				System.out.println("Account number " + number + "\nCurrent Balance:\t" + printBalance());
			} else if (pending) {
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

	void addAccountee(Customer user) {
		accountees.add(user);
		user.addAccount(this);

	}

	void viewAccount(User user) {
		if (canView(user)) {
			System.out.print("\rNames on account:");
			for (int x = 0; x < accountees.size(); x++) {
				System.out.println("\t" + accountees.get(x).getName());
			}
			System.out.println("Account Name:\t\t" + name + "\nAccount Number:\t\t" + number);
			if (pending) {
				System.out.println("Account Pending");
			} else {
				System.out.println("Account balance:\t" + balance);
			}
		}
	}

	void purge() {
		for (Customer i : accountees) {
			i.removeAccount(this);
		}
	}

	void transferTo(Account account, double ammount, User user) {
		if (canEdit(user)) {
			if (balance >= ammount && !pending && ammount >= 0) {
				this.withdraw(ammount, user);
				account.deposit(ammount);
				ibis.info(user.getName() + " transferred $" + ammount + " from account " + name + number + "to account "
						+ account.getNumber() + account.getNumber() + ".");
			} else if (pending) {
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
	}
}
