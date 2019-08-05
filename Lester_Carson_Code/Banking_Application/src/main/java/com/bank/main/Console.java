package com.bank.main;

import com.bank.bank_admin.*;
import com.bank.employee.*;
import com.bank.customer.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Console {
	
	public static void Run() {
		
		String fileC = "C:\\Users\\lbcar\\Documents\\workspace-sts-3.9.4.RELEASE\\Banking_Application\\src\\main\\java\\com\\bank\\main\\Accounts.txt";
		Scanner sc = new Scanner(System.in);
		String name, password;
		int input = 0;
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fileC));
			if (br.readLine() == null) {
				CustomerDAOImpl.customers.add(new Customer("Employee", "password", 2));
				CustomerDAOImpl.customers.add(new Customer("Bank_Admin", "password", 3));
			} else {
				FillFromFile(fileC);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}     
		
		while (true) {
			System.out.println("Welcome to Barton's Banking App!");
			System.out.println("Please type in the number that best corresponds to you:");
			System.out.println("1. Customer");
			System.out.println("2. Employee");
			System.out.println("3. Bank Adminstrator");
			System.out.println("4. Exit");
			
			input = sc.nextInt();sc.nextLine();
			
			if (input == 1) {
				Customer.CustomerRun();
			} else if (input == 2) {
				System.out.println("Please enter a username for your account:");
				name = sc.nextLine();
				System.out.println("Now enter your password: ");
				password = sc.nextLine();
				if(Login(name, password, 2)) {
					Employee.EmployeeRun();
				} else {
					System.out.println("Invalid Username and/or Password");
				}
			} else if (input == 3) {
				System.out.println("Please enter a username for your account:");
				name = sc.nextLine();
				System.out.println("Now enter your password: ");
				password = sc.nextLine();
				if(Login(name, password, 3)) {
					Bank_Admin.Bank_AdminRun();
				} else {
					System.out.println("Invalid Username and/or Password");
				}
			} else if (input == 4) {
				System.out.println("Exiting...");
				break;
			}
		}
		WriteToFile(fileC);
		sc.close();
	}
	
	public static Boolean Login(String username, String password, int input) {
		
		if(Customer.Search(username, password, input) != null) {
			return true;
		}
		return false;
		
	}
	
	public static void WriteToFile(String filePath) {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
				oos.writeObject(CustomerDAOImpl.customers);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static void FillFromFile(String filePath) {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
			CustomerDAOImpl.customers = (ArrayList<Customer>) ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}