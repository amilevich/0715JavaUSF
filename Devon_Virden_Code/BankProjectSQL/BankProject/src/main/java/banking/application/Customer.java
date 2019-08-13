package banking.application;

import java.util.ArrayList;
import java.util.Scanner;
import banking.DAO.AccountDAOImpl;
import banking.DAO.UserDAOImpl;

public class Customer extends User {

	AccountDAOImpl adao = new AccountDAOImpl();
	UserDAOImpl udao = new UserDAOImpl();

	public Customer(String name, String username) {
		super(username, "t", name, "CUSTOMER");
		ibis.info("Added new Customer:" + username + " " + name);
	}

	public Customer(String name, String username, String password) {
		super(username, password, name, "CUSTOMER");
	}

	void setPassword() {
		Scanner scan = new Scanner(System.in);
		String nPass1 = new String();
		String nPass2 = new String();
		do {
			System.out.println("Please enter new password (must be between 5 and 15 characters):");
			nPass1 = scan.nextLine();
			System.out.println("Please confirm new password:");
			nPass2 = scan.nextLine();
			if (!(nPass1.equals(nPass2))) {
				System.out.println("Passwords dont match, please try again.");
			} else if (nPass1.length() > 15 || nPass1.length() < 5) {
				System.out.println("Password must be between 5 and 15 characters");
			}
		} while ((!(nPass1.equals(nPass2)) && !(nPass1.equals(""))) || (nPass1.length() >= 15 || nPass1.length() <= 5));
		pass = nPass1;
		save();
	}

	void changePassword(Menu menu) {
		System.out.println("Please Confirm your password:");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		scan = new Scanner(System.in);
		int counter = 5;
		while (counter > 0 && !temp.equals(pass)) {
			if (!(temp.equals(pass))) {
				System.out.println("in the if");
				counter--;
				System.out.println(("Password incorrect, please try again: (" + counter + " tries remaining.)"));
				temp = scan.nextLine();
				scan = new Scanner(System.in);
			}
		}
		if (temp.equals(pass)) {
			ibis.info(name+" changed their password.");
			this.setPassword();
		} else {
			System.out.println("Password incorrect, signing out");
			signOut(menu);
		}
	}

	@Override
	void signIn(Menu menu) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter your password:");
		String temp = scan.nextLine();
		int counter = 5;
		while (counter > 0 && !(temp.equals(pass))) {
			counter--;
			System.out.println(("Password incorrect, please try again: (" + counter + " tries remaining.)"));
			temp = scan.nextLine();
		}
		if (temp.equals(pass)) {
			this.greeting();
			menu.customerMenu(this);
		} else {
			this.signOut(menu);
		}
	}

	private void save() {
		udao.updateUser(this);
	}
}
