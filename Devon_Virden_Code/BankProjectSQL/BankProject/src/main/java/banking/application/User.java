package banking.application;

import java.util.Scanner;

import org.apache.log4j.Logger;

import banking.DAO.UserDAOImpl;

public class User {

	protected final static Logger ibis = Logger.getLogger(User.class);
	protected String id;
	protected String pass;
	protected String name;
	String type;
	UserDAOImpl udao = new UserDAOImpl();

	public User() {
		super();
	}

	public User(String id, String pass, String name, String type) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	void greeting() {
		System.out.println("Hello " + name + "!");
	}

	public String getID() {
		return id;
	}

	public String getPassword() {
		return pass;
	}

	public String getType() {
		return type;
	}

	void printUser() {
		System.out.println("\rName:\t\t" + name + "\nUsername:\t" + id);
	}

	void signIn(Menu menu) {
		if (type.equalsIgnoreCase("ADMIN")) {
			Admin admin = new Admin(name, id, pass);
			admin.signIn(menu);
		} else if (type.equalsIgnoreCase("EMPLOYEE")) {
			Employee employee = new Employee(name, id, pass);
			employee.signIn(menu);
		} else if (type.equalsIgnoreCase("CUSTOMER")) {
			Customer customer = new Customer(name, id, pass);
			customer.signIn(menu);
		}
	}

	void signOut(Menu menu) {
		System.out.println("Goodbye");
		ibis.info(name + " signed out.");
		menu.mainMenu();
	}

	public String toString() {
		return ("[" + name + type + pass + id + "]");
	}

	public void changeName(Menu menu) {
		System.out.println("Please Confirm your password/pin:");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		scan = new Scanner(System.in);
		int counter = 5;
		while (counter > 0 && !temp.equals(pass)) {
			if (!(temp.equals(pass))) {
				counter--;
				System.out.println(("Password/pin incorrect, please try again: (" + counter + " tries remaining.)"));
				temp = scan.nextLine();
				scan = new Scanner(System.in);
			}
		}
		if (temp.equals(pass)) {
			System.out.println("\rPlease enter your new name:");
			name = scan.nextLine();
		} else {
			System.out.println("Password/pin incorrect, signing out");
			this.signOut(menu);
		}
	}
}
