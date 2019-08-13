package com.bankdb.project.screen;


import java.util.Scanner;
import org.apache.log4j.Logger;

import com.bankdb.project.dao.implement.PersonDAOImplement;
import com.bankdb.project.model.Person;

public class CustomerScreen {	
	final static Logger loggy = Logger.getLogger(CustomerScreen.class);
	public Person personAcces(String kinPerson) {		
		PersonDAOImplement gRepository = new PersonDAOImplement();
		Scanner scanner = new Scanner(System.in);
		Person persn = new Person();
		Person customer = new Person();
		String username;
		String kindPerson = new String();
		
		System.out.println("");
		System.out.println("");
		System.out.println("********************************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("           E N R O L L    S C R E E N");
		System.out.println("");
		System.out.println("");
		System.out.println("********************************************************");
		
		
		customer.setKindPerson(kinPerson);
		kindPerson = kinPerson;
			
		if(kinPerson.equals("A")) {
			String kind;
			do {
				System.out.println("");
				System.out.println("1 -> Admin ");
				System.out.println("2 -> Employee ");
				kind = scanner.nextLine();
				switch(kind) {
				case "1": kindPerson = "A";
						  break;
				case "2": kindPerson = "E";
						  break;
				default:  System.out.println(" Not is a valid option");
						  break;
				}
			}while(!kind.equals("1") && !kind.equals("2"));			
		}
		
		do {
			System.out.print("Username: ");
			username =  scanner.nextLine();
			customer.setUser(username);			
			persn = gRepository.findByUser(customer);
			if(persn != null) {
				if(kindPerson.equals("C"))
					System.out.println(" Customer already exist");
				else
					System.out.println((kindPerson.equals("A") ? "Admin" : "Employee") + " already exist");
			}
		}while(persn != null);
		
		System.out.print("Password: ");
		String password =  scanner.nextLine();		
		System.out.print("Name: ");
		String name = scanner.nextLine();
		System.out.print("Address: ");
		String address = scanner.nextLine();
		System.out.print("Telephone number: ");
		String phone = scanner.nextLine();	
				
		customer.setUser(username);
		customer.setPwd(password);
		customer.setNmPerson(name);
		customer.setAddress(address);
		customer.setPhone(phone);
		customer.setKindPerson(kindPerson);	
		if(gRepository.createRegister(customer)) {
			if(kindPerson.equals("C")) loggy.info("Customer created successful");
			else loggy.info((kindPerson.equals("A") ? "Admin" : "Employee") + " created successful");
		}
		return customer;		
	}
}
