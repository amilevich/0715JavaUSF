package banking.application;

import java.util.Scanner;
import banking.DAO.UserDAOImpl;

public class Admin extends User {

	UserDAOImpl udao = new UserDAOImpl();

	public Admin(String userName, String idCode, String pinNumber) {
		super(idCode, pinNumber, userName, "ADMIN");
	}
	
	public Admin(String userName, String idCode, String pinNumber, String status) {
		super(idCode, pinNumber, userName, "ADMIN");
		ibis.info("Added new Admin:" + id + " " + name);
	}
	

	@Override
	void printUser() {
		System.out.println("\rName:\t\t" + name + "\nID Number:\t" + id);
	}

	@Override
	void signIn(Menu menu) {
		String input = new String();
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Enter Pin Number:");
			input = scan.nextLine();
			scan = new Scanner(System.in);
		} while (!input.equals(pass));
		this.greeting();
		menu.adminMenu(this);
	}
}
