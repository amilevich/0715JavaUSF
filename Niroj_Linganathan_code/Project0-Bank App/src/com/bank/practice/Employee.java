package com.bank.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Employee {
	static int accNumber;
	static double balance;
	static String adminId;
	static String password;
	static double bal2;
	public static void employeeMainPage() {
		bank b1=new bank();
		Scanner sc = new Scanner(System.in);
		System.out.println("                 Commercial Bank");
		System.out.println("                  Employee login");
		System.out.println(" ");
		System.out.println("Enter Employee ID :-");

		adminId = sc.nextLine();
		System.out.println("Enter Password :-");
		password = sc.nextLine();
		
		if (adminId.equals("employee") && password.equals("commbank")) {
			System.out.println("WelCome" + " " + adminId);

			System.out.println("@VIEW CUSTOMER PERSONAL DETAILS==> PRESS 1" + "    " + "@VIEW ACCOUNT BALANCE==> PRESS 2");
			String input = sc.nextLine();
			switch (input) {
			
			case "1":
				System.out.println("personal details");
				break;
			case "2":
				System.out.println("balance");
				System.out.println("Enter The Account Number : ");
				String accNo=sc.nextLine();
				String cusTxtFile = "./" + accNo +"AccountDetails"+ ".txt";
				ReadAccountTxt(cusTxtFile);
				break;
			default:
				System.out.println("Invalid Selection !");
				
				
				b1.welcome();
			}

		} else {
			System.out.println("Invalid Login Details.");
			b1.welcome();
		}
		sc.close();
	}

	public static void approveAccount(String accNumber) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n");
		System.out.println("===========Application Waitng For Approval===========");
		System.out.println("\n");
		System.out.println("          ****YOU MUST BE AN EMPLOYEE OR ADMIN TO APPROVE AN ACCOUNT APPLICATION****");
		System.out.println("Enter Employee OR Admin ID :-");
		adminId = sc.nextLine();
		System.out.println("Enter Password :-");
		password = sc.nextLine();
		
		While(adminId.equals("employee") && password.equals("commbank")||adminId.equals("admin")&&password.equals("commbank")); {
			System.out.println("WelCome" + " " + adminId);
			bank b1=new bank();
			b1.tempCustDetails();
			System.out.println("Do You Want To Approve This Application? y/n.");
			String input=sc.nextLine();
			if(input.equals("y")) {
				accNumber = accNumber;
				System.out.println(accNumber);
				NewCustomer nc = new NewCustomer(accNumber);
				String a = nc.getAccNumber();
				System.out.println(a);
				String cusTxtFile = "./" + accNumber +"AccountDetails"+ ".txt";
				String accountFile = cusTxtFile;
				AccountDetails AD = new AccountDetails(accNumber, balance);
				WriteAccountTxt(accountFile, AD);
				ReadAccountTxt(accountFile);
				
				
			}else {
				System.out.println("Application Rejected.");
			}
		
	}
	}
	private static void While(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public static void WriteAccountTxt(String accountFile, Object obj) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(accountFile))) {
			oos.writeObject(obj);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}

	public static void ReadAccountTxt(String accountFile) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(accountFile))) {
			Object obj = ois.readObject();
			System.out.println("Current Balance : "+ obj);
			System.out.println("");
			
			
			String bal=obj.toString();
			bal2=Double.parseDouble(bal);
			//System.out.println(bal2);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//==============================================================================================================Transfer Money
	public static void WriteTransferAmount(String accountFile, Object obj) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(accountFile))) {
			oos.writeObject(obj);
			check();
		} catch (IOException exc) {
			//exc.printStackTrace();
			System.out.println("Invalid Account Number. Please Double Check The Number.");
			
		}
		
	}
	
	
	public static void ReadTransferTxt(String accountFile) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(accountFile))) {
			Object obj = ois.readObject();
	
			String bal=obj.toString();
			bal2=Double.parseDouble(bal);
			
		
		} catch (IOException e) {
			System.out.println("Invalid Account Number. Please Double Check The Number.");
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
		public static double bal() {
		
			return bal2;
		}
		public static int check() {
			return 0;
			
		}
	}


