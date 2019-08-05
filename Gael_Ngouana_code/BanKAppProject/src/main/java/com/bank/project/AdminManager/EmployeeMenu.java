package com.bank.project.AdminManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bank.project.PullAllOfThem;
import com.bank.project.PullAllOfToEmpl;
import com.bank.project.model.Account;
import com.bank.project.model.Customer;
import com.bank.project.model.Employee;
import com.bank.project.model.JointAccount;
import com.bank.project.model.Transaction;
import com.bank.project.screen.AccesEmployee;
import com.bank.project.screen.CancelAccount;
import com.bank.project.screen.CustomerInformationScreen;
import com.bank.project.screen.EmployeeScreen;
import com.bank.project.screen.EmployeeTransantionScreen;
import com.bank.project.screen.ReviewApliScreen;
import com.bank.project.screen.TransactionScreenEmployee;
import com.bank.project.screen.TransferScreenEmployee;

public class EmployeeMenu {
	
	public static List<Employee> employee = new ArrayList<>();
	public static List<Customer> custumer = new ArrayList<>();
	public static List<Account> account = new ArrayList<>();
	public static List<JointAccount> jtAccount = new ArrayList<>();
	public static List<Transaction> transaction = new ArrayList<>();
	public static Customer cstomer = new Customer();
	public static Employee epl = new Employee();
	public static PullAllOfToEmpl pullAll = new PullAllOfToEmpl();
	public static CustomerInformationScreen info = new CustomerInformationScreen();
	public static long numberAccount;
	
	public static void main(String[] args) {
		pullAll.pullAll();
		
		accessSystem();
	}
	
	static void  accessSystem() {
		Scanner scanner = new Scanner(System.in);
		int option;	
		do {
			pullAll.pullAll();			
			System.out.println("1. Log in .      ");
			System.out.println("2. Register.       ");
			System.out.println("3. Log Out.       ");
			System.out.println("Select an option  ");
			option = scanner.nextInt();
			
			switch(option) {			
			case 1:	AccesEmployee acces = new AccesEmployee();
					epl = acces.accsesSystem();				
					if(epl != null) {
						menuEmployee();
					}else System.out.println("Employee not found...");
					break;			
			case 2: EmployeeScreen access = new EmployeeScreen();
					epl = access.enrollEmployee();
					if(epl == null) {
						System.out.println("Sorry.. Employee could not be created");
					}
					break;
			default: 
				     if(option != 3) System.out.println("Invalid option"); 
					 break;
			
			};
		}while(option != 3);			
	}
	
	static void menuEmployee() {
			pullAll.pullAll();
			EmployeeTransantionScreen tre = new EmployeeTransantionScreen();
			TransactionScreenEmployee  cst = new TransactionScreenEmployee();
			TransferScreenEmployee  tranf = new TransferScreenEmployee();
			Scanner scanner = new Scanner(System.in);
			int option;
			do {
				pullAll.pullAll();
				System.out.println("1. Review Applications ");
				System.out.println("2 -> Joint Accounts ");
				System.out.println("3 -> Customer Information ");				
				System.out.println("4 -> Withdrawal ");				
				System.out.println("5 -> Deposit ");				
				System.out.println("6 -> Transfer ");				
				System.out.println("7 -> Cancel account ");	
				System.out.println("8 -> Exit ");	
				option = scanner.nextInt();
				
				switch(option) {
					case 1: ReviewApliScreen rv = new ReviewApliScreen();
							rv.reviewApl();
							break;
					case 2:						
							break;						
					case 3: cstomer = tre.transferEmployee();
							if(cstomer != null) {
								info.infCustomer(cstomer);
							}	
							break;
					case 4: cstomer = tre.transferEmployee();
							if(cstomer != null) {
								cst.addTransaction(cstomer, 'W');
							}
							break;
					case 5: cstomer = tre.transferEmployee();
							if(cstomer != null) {
								cst.addTransaction(cstomer, 'D');
							}
					
							break;
					case 6: cstomer = tre.transferEmployee();
							if(cstomer != null) {
								tranf.addTransfer(cstomer);
							}
							break;
					case 7: CancelAccount clc = new CancelAccount();
					clc.cnncel();
							break;
					default: if(option != 8)  System.out.println("Invalid Option");
				}
				
			}while(option != 8);
	}

}
