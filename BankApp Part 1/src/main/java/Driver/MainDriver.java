package Driver;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Accounts.Account;
import Application.Application;
import Customers.Customer;
import Employees.Employee;


public class MainDriver {

	//pulls the txt file data into the program at the beginning
	static {
		final String path = "src/main/resources/Data.txt";
		try {
			File file = new File(path);
			FileInputStream fi = new FileInputStream(file);
			ObjectInputStream oi = new ObjectInputStream(fi);
			//new object input stream for the txt file
			
			List<Customer> customers = (ArrayList<Customer>) oi.readObject();
			Customer.setCustomers(customers);
			System.out.println("Cutomer read " + customers);
			//reads customer data from the file
			
			List<Account> accounts = (ArrayList<Account>) oi.readObject();
			Account.setAccounts(accounts);
			System.out.println("Account read " + accounts);
			//reads account data
			System.out.println(oi.readObject());
			
			ArrayList<Application> applications = (ArrayList<Application>) oi.readObject();
			Application.setOpenApplications(applications);
			System.out.println("Application read" + applications);
			//reads application applications
			oi.close();
		} catch (EOFException e) {	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	};

	 
	
	public static void main(String[] args) {
		Employee e = new Employee("Jennifer");
		e.start();
		
		MainDriver.stop();
	}


	public static void stop() {
		System.out.println("Thank you for stopping by the Revature Bank!");
		System.out.println("Hava a nice day!");

		final String path = "src/main/resources/Data.txt"; 
		
		//writes all the lists to the txt file
		try {
			File file = new File(path);
			FileOutputStream fo = new FileOutputStream(file);
			ObjectOutputStream oo = new ObjectOutputStream(fo);

			oo.writeObject(Customer.getCustomers());
			System.out.println("Customers written to file.");
			oo.writeObject(Account.getAccounts());
			System.out.println("Accounts written to file.");
			oo.writeObject(Application.getOpenApplications());
			System.out.println("Applications written to file.");

			oo.close();
		} catch (EOFException e) {	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
