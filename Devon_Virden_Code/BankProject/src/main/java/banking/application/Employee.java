package banking.application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Employee extends User {

	private static final long serialVersionUID = -4608423206146845150L;
	private String id;
	private int pin;

	public Employee(String userName, String idNumber, int pinNumber) {
		super(userName, "EMPLOYEE");
		id = idNumber;
		pin = pinNumber;
		ibis.info("Added new employee:" + id + " " + name);
		save();
	}

	public String getID() {
		return id;
	}

	@Override
	void printUser() {
		System.out.println("\rName:\t\t" + name + "\nID Number:\t" + id);
	}

	@Override
	void signIn(Menu menu) {
		int input;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter Pin Number:");
			input = sc.nextInt();
		} while (input != pin);

		this.greeting();
		menu.employeeMenu(this);
	}

	@Override
	protected void save() {
		{
			try {
				ObjectOutputStream writer = new ObjectOutputStream(
						new FileOutputStream("./Serialization\\user_" + name + "_" + id + ".txt"));
				writer.writeObject(this);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return ("[" + name + type + pin + id + "]");
	}
}
