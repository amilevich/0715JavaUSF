/**
 * If approved the information inside 
 * the  application will be used to create an account
 * or add to an account
 * and gives a name to a new customer along with the foreign 
 * key of an account_id to know which account he/she
 * is connected to
 */
package Application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Accounts.Account;
import Driver.MainDriver;

public class Application implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4760524870134914257L;

	private static List<Application> openApplications = new ArrayList<Application>(); //instantiates an object of list of applications (empty right now)

	private Scanner keyboard = new Scanner(System.in);
	private Map<String, String> login = new HashMap<String, String>();
	private String name; //customer's name variable
	private String account_id; //customer's account ID variable

	public void startApplication() {
		System.out.println("Please fill out the following application, but before we begin, "
				+ "I would like to notify you that there is a minimum initial deposit requirement of $50");

		System.out.println(
				"If you don't have the required deposit at this time, you have the option to save your application and finish the account setup later.");
		System.out.println("Do you want go ahead and start your application now?(yes/no)");
		String response = keyboard.nextLine();
		if (response.equalsIgnoreCase("yes")) {
			System.out.println("Great, please fill out the following...");
			System.out.println("Full Name: ");
			String name = keyboard.nextLine();
			setName(name); //setter for the customer's name
			System.out.println();

			String user;
			do { //do while loop to create a unique user name
				System.out.println("User Name (try again if username already exists): "); 
				user = keyboard.nextLine();
				// System.out.println();
			} while (checkUser(user));

			String pass;
			do { //do while loop to create a password with number of characters restriction
				System.out.println("Password (must be 5-8 characters long): ");
				pass = keyboard.nextLine();
			} while (!checkPassword(pass));
			addLogin(user, pass); //adds the username and password to the login map
		} else {
			MainDriver.stop(); //stops the program if they didn't want to continue with application
		}
	}

	public Account startJointApplication(String user) { //method for filling out the joint application

		System.out.println("Please fill out the following application...");
		System.out.println(
				"We will first need the owner of the account to login to their account for security purposes.");
		System.out.println("Account ID: ");
		String id = keyboard.nextLine();
		Account app = Account.findAccount(id);
		if (app == null) {
			System.out.println("I'm sorry, but we don't have an account with that account ID.");
			MainDriver.stop();
		}
		System.out.println("Account holder's username: ");
		String username = keyboard.nextLine();
		System.out.println("Password: ");
		String password = keyboard.nextLine();
		if (app.checkLogin(username, password)) {
			System.out.println(
					"Please be aware that this information is what is used to gain access to the account.");
			System.out.println("Please fill out the following...");
			System.out.println("Full Name: ");
			String nam = keyboard.nextLine();
			setName(nam);
		}
		return app;

	}

	public boolean checkUser(String user) {  //checks for unique username
		return Account.checkUserNames(user);
	}

	public boolean checkPassword(String pass) { //checks the password is between 5 & 8 characters
		if (pass.length() < 5 || pass.length() > 8) {
			return false;
		}
		return true;
	}

	// static getters & setters

	/**
	 * @return the open
	 */
	public static List<Application> getOpenApplications() { //gets the list of any open applications
		System.out.println(openApplications);
		return openApplications;
	}

	/**
	 * @param open the open to set
	 */
	public static void setOpenApplications(List<Application> open) { //sets the list  
		Application.openApplications = open;
	}

	public static void addApplication(Application app) { //adds open application to application list 
		Application.openApplications.add(app);
	}

	public static void removeApplication(Application app) { //removes an open application once finished completing
		Application.openApplications.remove(app);
	}

	public static Application findCustomer(String name) { //checks if the customer has an open application
		for (int i = 0; i < Application.openApplications.size(); i++) {
			if (Application.openApplications.get(i).getName().equalsIgnoreCase(name)) {
				return Application.openApplications.get(i);
			}
		}
		return null;
	}

	// non-static getters & setters

	/**
	 * @return the login
	 */
	public Map<String, String> getLogin() { //returns the map that contains the login information 
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(Map<String, String> login) { //sets the map with customer's login information
		this.login = login;
	}

	public void addLogin(String username, String password) { //adds the login info to the map
		if (this.login.size() < 1) {
			this.login.put(username, password);
		}
	}

	/**
	 * @return the name
	 */
	public String getName() { //gets the customer's name 
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) { //sets the customer's name
		this.name = name;
	}

	/**
	 * @return the account_id
	 */
	public String getAccount_id() { //gets account ID
		return account_id;
	}

	/**
	 * @param account_id the account_id to set
	 */
	public void setAccount_id(String account_id) { //sets account ID
		this.account_id = account_id;
	}
}
