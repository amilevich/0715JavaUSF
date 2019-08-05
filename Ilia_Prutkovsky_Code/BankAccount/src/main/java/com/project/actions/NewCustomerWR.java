package com.project.actions;

import com.project.pjzero.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.members.*;

public class NewCustomerWR implements Serializable {
	
	final static Logger logTracker = Logger.getLogger(NewCustomerWR.class);
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 399139992826698021L;
					
	public void writeNewCustomer() throws FileNotFoundException, NoSuchFieldException, IllegalAccessException {
		Menu menu = new Menu();
		String filename = "d:/workspace-sts-3.9.4.RELEASE/BankAccount/DB/new_customer.dat";
		NewCustomer createCustomer = new NewCustomer(null, null, null, 0);		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(createCustomer);
			oos.close();
		} catch(IOException exc) {
			exc.printStackTrace();
		}		
		System.out.println("Your profile was created succesfully");
		System.out.println("\n");
		logTracker.info("Customer profile was created and saved");
		
		Scanner scan = new Scanner (System.in);
		System.out.println("Customer's profile was created. Please input \"1\" for returning to main menu");
		int num = scan.nextInt();
		if(num == 1) menu.mainMenu();
		scan.close();
	}
	
	public void readNewCustomer() {	
		String filename = "d:/workspace-sts-3.9.4.RELEASE/BankAccount/DB/new_customer.dat";
		NewCustomer createCustomer = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			createCustomer = (NewCustomer)ois.readObject();
			System.out.println(createCustomer);	
			ois.close();
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();			
		}
		logTracker.info("Customer information was read");
	}
}
