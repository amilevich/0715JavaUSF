package com.bank.project.screen;

import java.util.Scanner;

import com.bank.project.inteface.GeneralRepository;
import com.bank.project.model.Customer;
import com.bank.project.services.CustomerService;

public class CustomerEnrollScreen {
	GeneralRepository<Customer> gRepository = new CustomerService();
	
	public Customer enrollCustomer() {	
		Scanner scanner = new Scanner(System.in);		
		Customer customer = new Customer();
		System.out.println("Enter Socila Security");
		String idCustomer = scanner.nextLine();	
		System.out.println("Enter username: ");
		String user = scanner.nextLine();
		System.out.println("Enter password: ");
		String pwd = scanner.nextLine();
		
		
		customer.setPwd(pwd);
		customer.setId(idCustomer);
		customer.setUser(user);	
		if(gRepository.updateRegister(customer)) {
			customer = gRepository.findById(customer);
			return customer;
		}else return null;	
	}

}
