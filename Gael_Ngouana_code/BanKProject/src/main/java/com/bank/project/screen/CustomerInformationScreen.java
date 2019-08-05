package com.bank.project.screen;

import com.bank.project.AdminManager.EmployeeMenu;
import com.bank.project.model.Account;
import com.bank.project.model.Customer;

public class CustomerInformationScreen {
	public void infCustomer(Customer customer) {
		
		System.out.println(" Name: " + customer.getNmCustomer());
		System.out.println(" Address: " + customer.getAddress());
		System.out.println(" Phono: " + customer.getPhone());
		
		for(Account a : EmployeeMenu.account) {
			if(a.getId().equals(customer.getId()) && a.getStatus() == 'A') {
				System.out.println(" # Acct: " + a.getAccountNumber() + " Kind: " + (a.getKindAccount() == 'S' ? "Saving": "Checking") +" Balabce: " + a.getAmount());
			}
		}
	}

}
