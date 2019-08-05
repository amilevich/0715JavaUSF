package com.bank.project.screen;

import com.bank.project.inteface.GeneralRepository;
import com.bank.project.model.Customer;
import com.bank.project.services.CustomerService;

public class AllCustomersScreen {
	
	public void allCustomers() {
		GeneralRepository<Customer> customers = new CustomerService();
		
		for(Customer c : customers.finAllRegister()) {
			System.out.println("Name: " + c.getNmCustomer() + "Driver Lic: " + "Address; " 
					+ c.getAddress() + "" +  c.getPhone());
		}
	}

}
