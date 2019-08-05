package com.bank.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer implements Serializable {
	
	private static final long serialVersionUID = -8375625980315271011L;
	List<String> password = new ArrayList<String>(); 
	List<String>name = new ArrayList<String>();
	double balance;
	boolean approved, joint;
	int type;
	CustomerDAOImpl use = new CustomerDAOImpl();
	
	public Customer(String name, String password, int type) {
		super();
		this.name.add(name);
		this.password.add(password);
		this.balance = 0.00;
		this.approved = false;
		this.joint = false;
		this.type = type;
	}
	
	
	public List<String> getPassword() {return password;}
	public void setPassword(List<String> password) {this.password = password;}
	public List<String> getName() {return name;}
	public void setName(List<String> name) {this.name = name;}
	public double getBalance() {return balance;}
	public void setBalance(Double balance) {this.balance = balance;}
	public boolean getApproved() {return approved;}
	public void setApproved(Boolean approved) {this.approved = approved;}
	public boolean getJoint() {return joint;}
	public void setJoint(Boolean joint) {this.joint = joint;}
	public int getType() {return type;}
	public void setType(int type) {this.type = type;}


	@Override
	public String toString() {
		return "Username(s): " + this.getName() + " Password(s): " + this.getPassword() + " Balance: " + Double.toString(this.getBalance()) + " Approved: " + Boolean.toString(this.getApproved());
	}
	
	public static void CustomerRun() {
		
		String name, password;
		Boolean run = true;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int input = 0;
		CustomerDAOImpl use = new CustomerDAOImpl();
		
		while(run) {
			System.out.println("Type out the number of your desired operation");
			System.out.println("1. Create a new Account:");
			System.out.println("2. Open an Account");
			System.out.println("3. Exit");
			if (sc.hasNextInt()) {
				input = sc.nextInt();sc.nextLine();
			}
			if (input == 1) {
				System.out.println("Please enter a username for your account");
				name = sc.nextLine();
				System.out.println("Now enter your password: ");
				password = sc.nextLine();
				use = new CustomerDAOImpl(name, password, 1);
			} else if (input == 2) {
				System.out.println("Please enter a username for your account:");
				name = sc.nextLine();
				System.out.println("Now enter your password: ");
				password = sc.nextLine();
				if(use.Open(name, password)) {
					CustomerOpen(use);
				}
			} else if (input == 3) {
				run = false;
			} else {
				System.out.println("Please type in the integer that best corresponds to you:");
			}
		}
	}
	
	public static void CustomerOpen(CustomerDAOImpl use) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Boolean run = true;
		Double bal;
		String name, pass, how;
		
		while (run) {

			System.out.println("Select an option:");
			System.out.println("1. Withdraw:");
			System.out.println("2. Deposit: ");
			System.out.println("3. Transfer: ");
			System.out.println("4. Add Username/Password to Account: ");
			System.out.println("5. Exit");
			
			int input = sc.nextInt();sc.nextLine();
			
			if (input == 1) {
				System.out.println("Please enter the amount you wish to withdraw: ");
				bal = sc.nextDouble();
				use.Withdraw(bal);
			} else if (input == 2) {
				System.out.println("Please enter the amount you wish to deposit: ");
				bal = sc.nextDouble();
				use.Deposit(bal);
			} else if (input == 3) {
				System.out.println("Please enter the username of the account you want to transfer money to/from:");
				name = sc.nextLine();
				System.out.println("Please enter the password of the account you want to transfer money to/from:");
				pass = sc.nextLine();
				System.out.println("Now enter the amount of money you wish to transfer");
				bal = sc.nextDouble();sc.nextLine();
				System.out.println("Now enter 'to' or 'from' with regards to how the money is passing between accounts");
				how = sc.nextLine();
				use.Transfer(name, pass, bal, how);
			} else if (input == 4) {
				System.out.println("Please enter the username of the person you want to add to your account");
				name = sc.nextLine();
				System.out.println("Please enter the password of the person you want to add to your account");
				pass = sc.nextLine();
				use.add(name, pass);
			} else if (input == 5) {
				run = false;
			} else {
				System.out.println("Please type in the integer that best corresponds to you:");
			}
		}
	}
	
	public static Customer Search(String username, String password, int input) { 
		
	    for(Customer customer : CustomerDAOImpl.customers) {
	    	for(int i = 0; i < customer.name.size(); i++) {
	    		if(customer.name.get(i).equals(username) && customer.password.get(i).equals(password) && customer.getType() == input) {
	    			return customer;
	    		}
	    	}
	    }
	    return null;
	}
}