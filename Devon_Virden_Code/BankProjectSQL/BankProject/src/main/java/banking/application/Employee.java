package banking.application;

import java.util.Scanner;
import banking.DAO.UserDAOImpl;

public class Employee extends User {

	UserDAOImpl udao = new UserDAOImpl();

	public Employee(String userName, String idNumber, String pinNumber) {
		super(idNumber, pinNumber, userName, "EMPLOYEE");
	}
	
	public Employee(String userName, String idNumber, String pinNumber, String status) {
		super(idNumber, pinNumber, userName, "EMPLOYEE");
		ibis.info("Added new employee:" + id + " " + name);
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
		menu.employeeMenu(this);
	}
}
