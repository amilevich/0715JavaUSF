package Customers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Application.Application;


public class Customer implements Serializable {

	private static final long serialVersionUID = -7450933814758381572L;

	private static List<Customer> customers = new ArrayList<Customer>();  //instantiates an object of list of customers (empty right now)

	private String name; //customer's name variable
	private String account_id; //customer's account ID variable

	public Customer(Application app) { //constructor; takes the name and the account ID from the customer's application
		this.name = app.getName(); 
		this.account_id = app.getAccount_id();
	}
	/**
	 * @param name
	 * @param account_id
	 */
	public Customer(String name, String account_id) { //constructor
		super();
		this.name = name;
		this.account_id = account_id;
	}

	/**
	 * @param name
	 */
	public Customer(String name) { //constructor
		super();
		this.name = name;
	}
	
	public Customer() { // no-args constructor
		super();
	}
	
	//static getters & setters (belongs to the class, don't have to have an object to use those)
	//methods that modify and search the static customers list

	/**
	 * @return the customers
	 */
	public static List<Customer> getCustomers() { //returns the list of customers
		return customers;
	}

	/**
	 * @param customers the customers to set
	 */
	public static void setCustomers(List<Customer> customers) { //will take the customer list from data.txt to set the current customer list in the program
		Customer.customers = customers;
	}

	public static void addCustomer(Customer cust) { //adds a customer to the customer's array list 
		Customer.customers.add(cust);
	}

	public static void removeCustomer(Customer cust) { //removes a customer from the customer's array list
		Customer.customers.remove(cust);
	}

	public static Customer findCustomer(String name) {
		for (int i = 0; i < Customer.customers.size(); i++) {
			if (Customer.customers.get(i).getName().equalsIgnoreCase(name)) { //looks for customers using their name and returns the customer
				return Customer.customers.get(i);
			}
		}
		return null; //if can't find the customer, returns null
	}

	//non-static getters & setters
	/**
	 * @return the name
	 */
	public String getName() { //returns name
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) { //sets the name
		this.name = name;
	}

	/**
	 * @return the account_id
	 */
	public String getAccount_id() { //returns account ID
		return account_id;
	}

	/**
	 * @param account_id the account_id to set
	 */
	public void setAccount_id(String account_id) { //sets account ID
		this.account_id = account_id;
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", account_id=" + account_id + "]"; //returns the string value of the object's fields 
	}

}
