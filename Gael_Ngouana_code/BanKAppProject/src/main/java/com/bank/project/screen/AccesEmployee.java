package com.bank.project.screen;

import java.util.Scanner;

import com.bank.project.dao.customer.FindCustomerByUserDao;
import com.bank.project.dao.customer.FindEmployeeByUserDao;
import com.bank.project.model.Customer;
import com.bank.project.model.Employee;

public class AccesEmployee {
	
	
	
	public Employee accsesSystem() {
		Scanner scanner = new Scanner(System.in);
		Employee empl = new Employee();		
		System.out.println("Username: ");
		String user = scanner.nextLine();
		System.out.println("Password: ");
		String pwd = scanner.nextLine();
		
		FindEmployeeByUserDao emp = new FindEmployeeByUserDao();
		
		empl = emp.findEmpl(user, pwd);
		 
		
		return empl;
	}

}
