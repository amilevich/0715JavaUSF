/**
 * 
 */
package Employees;

import Accounts.Account;
import Application.Application;
import Customers.Customer;


public class Admin extends Employee{
//Admin is an employee
	
	/**
	 * @param name
	 * @param test
	 */
	public Admin(String name) {
		super(name);
	}

	public void joint(String userName) {
		System.out.println("Hello " + userName + ". My name is " + this.getName() + ". I was told you want a joint account, so let's get started.");
		
		Application a = new Application();
		Account acc = a.startJointApplication(userName);
		analyzeApplication(userName, a, acc);
	}
	
	public void analyzeApplication(String userName, Application app, Account acc) {
		System.out.println("Let's take a look at your application.");
		System.out.println("I will tell you if you have been approved or denied momentarily.");
		
		//if the name doesn't equal the name you entered in the beginning of the program, application is denied
		if (!userName.equalsIgnoreCase(app.getName())) {
			deny();
		} else {
			approve(app, acc);
		}
	}
	
	public void approve(Application app, Account acc) { //application approved

		System.out.println("Thank you for waiting. Your application has been approved.");
		Customer.addCustomer(new Customer(app.getName(),acc.getAccount_id()));
		System.out.println("Please make sure you keep the login information and the account ID safe.");
	}
	
	public void cancelAccount(Account acc, Customer cust) { //canceling account
		
		System.out.println("Hello. My name is " + this.getName() + ". I was told you want cancel your account, so let's get started.");
		
		Account.removeAccount(acc);
		Customer.removeCustomer(cust);
	}
}
