package com.bank.project.screen;


import java.util.Scanner;

import com.bank.project.inteface.GeneralRepository;
import com.bank.project.model.Customer;
import com.bank.project.services.CustomerService;

public class CustomerScreen {	
	
	public Customer customerAcces() {
		Scanner scanner = new Scanner(System.in);
		Customer customer = new Customer();
		System.out.print("Social Security: ");
		String id = scanner.nextLine();		
		System.out.print("Name: ");
		String name = scanner.nextLine();
		System.out.print("Address: ");
		String address = scanner.nextLine();
		System.out.print("Telephone number: ");
		String phone = scanner.nextLine();
		System.out.print("Username: ");
		String username =  scanner.nextLine();
		System.out.print("Password: ");
		String password =  scanner.nextLine();		
		
		customer.setId(id);
		customer.setNmCustomer(name);
		customer.setAddress(address);
		customer.setPhone(phone);
		customer.setUser(username);
		customer.setPwd(password);
		customer.setKindPerson('C');
		
		GeneralRepository<Customer> gRepository = new CustomerService();
		gRepository.createRegister(customer);
		
		return customer;
		
		
		
	}
	
	
	

}
