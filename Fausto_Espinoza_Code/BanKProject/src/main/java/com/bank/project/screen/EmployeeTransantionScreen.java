package com.bank.project.screen;

import java.util.Scanner;

import com.bank.project.AdminManager.EmployeeMenu;
import com.bank.project.model.Customer;

public class EmployeeTransantionScreen {
	
	public Customer  transferEmployee() {
		Scanner  scnner = new Scanner(System.in);
		for(Customer c : EmployeeMenu.custumer) {
			System.out.println("customer ID " + c.getId() + " Name: " + c.getAddress());
		}
		
		System.out.println("Enter Customer ID ");
		String idCustomer = scnner.nextLine();
		
		for(Customer c : EmployeeMenu.custumer) {
			if(c.getId().equals(idCustomer)) {
				return c;
			}
		}
		
		return null;
	}

}
