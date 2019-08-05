package com.bank.project.screen;
import java.util.Scanner;
import com.bank.project.dao.customer.FindCustomerByUserDao;
import com.bank.project.model.Customer;

public class AccesScreen {
	
	public Customer accsesSystem() {
		Scanner scanner = new Scanner(System.in);
		Customer crdCustomer = new Customer();		
		System.out.println("Username: ");
		String user = scanner.nextLine();
		System.out.println("Password: ");
		String pwd = scanner.nextLine();
		
		FindCustomerByUserDao customer = new FindCustomerByUserDao();
		
		crdCustomer = customer.findUser(user, pwd);
		 
		
		return crdCustomer;
	}
}
