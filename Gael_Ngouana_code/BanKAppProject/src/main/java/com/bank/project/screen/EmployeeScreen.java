package com.bank.project.screen;

import java.util.Scanner;

import com.bank.project.inteface.GeneralRepository;
import com.bank.project.model.Employee;
import com.bank.project.services.EmployeeService;

public class EmployeeScreen {
	
	
	public Employee enrollEmployee() {
		Employee empl = new Employee();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your ID");
		String idCustomer = scanner.nextLine();	
		System.out.println("Enter your Name");
		String name = scanner.nextLine();
		System.out.println("Enter username: ");
		String user = scanner.nextLine();
		System.out.println("Enter password: ");
		String pwd = scanner.nextLine();
		
		empl.setId(idCustomer);
		empl.setKindPerson('E');
		empl.setNmCustomer(name);
		empl.setUser(user);
		empl.setPwd(pwd);
		GeneralRepository<Employee> gRepository = new EmployeeService();
		gRepository.createRegister(empl);
		return empl;
	}

}
