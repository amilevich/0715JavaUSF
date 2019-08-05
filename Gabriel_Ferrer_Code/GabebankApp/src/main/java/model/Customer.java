package model;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.apache.log4j.Logger;

public class Customer extends Person implements Serializable{
	/**
	 * @author Gabriel Ferrer
	 */
	private static final long serialVersionUID = 2341673796778491437L;
	final static Logger logger = Logger.getLogger(Customer.class);
	public static TreeMap<String, Customer> customers = new TreeMap<String, Customer>();
	private TreeSet<Integer> bankAccountNumbers = new TreeSet<Integer>();
	private static Integer counter = 0;
	/// constructors
	public Customer() {}
	
	public Customer(String firstName, String lastName, String username, Integer bankAccountNumber) {
		super(firstName, lastName);
		this.bankAccountNumbers.add(bankAccountNumber);
		customers.put(username,this);
		++counter;
		logger.info(String.format("Registered new customer %1$s", this.getFullname()));
	}
	
	/// static methods
	
	public static Customer getCustomer (String username) {
		return customers.get(username);
	}

	public static void edit(String username, String firstname, String lastname) {
		customers.get(username).firstName = firstname;
		customers.get(username).lastName = lastname;
	}

	public static TreeMap<String, Customer> getAll() {
		return customers;
	}

	public static void setAll(TreeMap<String, Customer> c) {
		customers = c;
	}
	
	public static Integer getSize() {
		return customers.size();
	}
	
	public static void setCustomers(TreeMap<String, Customer> customers) {
		Customer.customers = customers;
	}

	public static Set<String> getUsernames() {
		return customers.keySet();
	}
	
	/// object methods
	
	public boolean hasBankAccount (Integer bankAccountNumber) {
		return bankAccountNumbers.contains(bankAccountNumber);
	}
	
	public Set<Integer> getBankAccountNumbers() {
		return (Set<Integer>) bankAccountNumbers;
	}

	public void setBankAccountNumbers(TreeSet<Integer> bankAccountNumbers) {
		this.bankAccountNumbers = bankAccountNumbers;
	}
	
	public void addBankAccount(Integer bankAccount) {
		this.bankAccountNumbers.add(bankAccount);
	}
	
	public void removeBankAccount(Integer bankAccount) {
		this.bankAccountNumbers.remove(bankAccount);
	}
	
	public String getFullname() {
		return getFirstName() + " " + getLastName();
	}
	
	public String getFirstName() {
		return super.firstName;
	}
	
	public String getLastName() {
		return super.lastName;
	}

	@Override
	public String toString() {
		return "Customer [bankAccountNumbers=" + bankAccountNumbers + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
	
	
}