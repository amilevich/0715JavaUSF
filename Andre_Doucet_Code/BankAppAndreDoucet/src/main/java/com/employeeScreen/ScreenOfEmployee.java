package com.employeeScreen;

import java.util.Scanner;

import com.mainmenu.MainScreen;
import com.uncertainty.Employee;

import dao.EmployeeCreate;

public class ScreenOfEmployee {
	public void menuBridge() {
		Employee employee = new Employee();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your id.");
		String id = in.nextLine();
		Scanner in2 = new Scanner(System.in);
		System.out.println("Enter your name.");
		String employeeName = in2.nextLine();
		Scanner in3 = new Scanner(System.in);
		System.out.println("Enter your user name.");
		String employeeLogin = in3.nextLine();
		Scanner in4 = new Scanner(System.in);
		System.out.println("Enter your password.");
		String employeePassword = in4.nextLine();
		
		
		employee.setId(id);
		employee.setEmployeeName(employeeName);
		employee.setEmployeeLogin(employeeLogin);
		employee.setEmployeePassword(employeePassword);
		
		
		MainScreen.employee.add(employee);
		EmployeeCreate thing = new EmployeeCreate();
		thing.addtoDB(employee);
	}
}
