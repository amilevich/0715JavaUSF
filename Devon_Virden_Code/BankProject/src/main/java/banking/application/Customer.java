package banking.application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User {

	private static final long serialVersionUID = -1256323384300855628L;
	private String user;
	private String pass = "";
	private ArrayList<Account> accounts = new ArrayList<Account>();

	public Customer(String name, String username) {
		super(name, "CUSTOMER");
		user = username;
		ibis.info("Added new Customer:" + user + " " + name);
		save();
	}

	void addAccount(Account account) {
		accounts.add(account);
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	void setPassword() {
		Scanner sc = new Scanner(System.in);
		String nPass1 = new String();
		String nPass2 = new String();
		do {
			System.out.println("Please enter new password:");
			nPass1 = sc.nextLine();
			System.out.println("Please confirm new password:");
			nPass2 = sc.nextLine();
			if (!(nPass1.equals(nPass2))) {
				System.out.println("Passwords dont match, please try again.");
			}
		} while (!(nPass1.equals(nPass2)) && !(nPass1.equals("")));
		pass = nPass1;

	}

	void changePassword(Menu menu) {
		System.out.println("Please Confirm your password:");
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		int counter = 5;
		while (counter > 0) {
			if (!(temp.equals(pass))) {
				counter--;
				System.out.println(("Password incorrect, please try again: (" + counter + " tries remaining.)"));
				temp = sc.nextLine();
			}
		}

		if (temp.equals(pass)) {
			this.setPassword();
		} else {
			this.signOut(menu);
		}
	}

	@Override
	void printUser() {
		System.out.println("\rName:\t\t" + name + "\nUsername:\t" + user);
	}

	@Override
	void signIn(Menu menu) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter your password:");
		String temp = sc.nextLine();
		int counter = 5;
		while (counter > 0 && !(temp.equals(pass))) {
			counter--;
			System.out.println(("Password incorrect, please try again: (" + counter + " tries remaining.)"));
			temp = sc.nextLine();
		}

		if (temp.equals(pass)) {
			this.greeting();
			menu.customerMenu(this);
		} else {
			this.signOut(menu);
		}
	}

	void removeAccount(Account account) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getNumber() == account.getNumber()) {
				accounts.remove(i);
			}
		}
	}

	@Override
	protected void save() {
		{
			try {
				ObjectOutputStream writer = new ObjectOutputStream(
						new FileOutputStream("./Serialization\\user_" + name + "_" + user + ".txt"));
				writer.writeObject(this);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public String toString() {
		return ("[" + name + type + pass + user + "]");
	}
}
