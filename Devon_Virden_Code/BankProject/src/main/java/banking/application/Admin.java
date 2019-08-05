package banking.application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Admin extends User {

	private static final long serialVersionUID = 4024696280052968529L;
	private String id;
	private int pin;

	public Admin(String userName, String idCode, int pinNumber) {
		super(userName, "ADMIN");
		id = idCode;
		pin = pinNumber;
		ibis.info("Added new Admin:" + id + " " + name);
		save();
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
		menu.adminMenu(this);
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
