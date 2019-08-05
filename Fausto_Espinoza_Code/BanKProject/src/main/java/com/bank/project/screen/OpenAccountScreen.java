package com.bank.project.screen;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.bank.project.MainEntry;
import com.bank.project.dao.account.CreateNumber;
import com.bank.project.model.Account;
import com.bank.project.model.Customer;
import com.bank.project.services.AccountService;

public class OpenAccountScreen {
	
	public void openAccount(Customer customer) {
		Scanner scanner = new Scanner(System.in);
		Account account = new Account();
		AccountService accountService = new AccountService();
//		System.out.println("Enter # Acount");
//		String numberAcct = scanner.nextLine();
		System.out.println("Select kind account");
		String numberAcct = new String();
		numberAcct +=  MainEntry.numberAccount;
		if(numberAcct.length() > 0) {
			String temp = new String();
			for(int i = 0 ; i <= 14 - numberAcct.length() ; i++) {
				temp += "0";
			}
			numberAcct = temp + numberAcct;
		}
		char kdAcct = ' ';	
		int option;
		do {
			System.out.println("1 -> Checking");
			System.out.println("2 -> Saving");
			option = scanner.nextInt();
			switch(option){
			case 1: kdAcct = 'C';
				    break;
			case 2: kdAcct = 'S';
					break;
			default: System.out.println("No is a valid option");
					break;
			
			}		
		}while(option != 1 && option != 2 );
		
		double amount = 0.00;
		LocalDateTime date = LocalDateTime.now();	
		char status = 'P';//The application is pending
		
		account.setId(customer.getId());
		account.setNmCustomer(customer.getNmCustomer());
		
		account.setAccountNumber(numberAcct);
//		account.setAccountNumber("");
		account.setKindAccount(kdAcct);
		account.setAmount(amount);
		account.setDate(date);
		account.setStatus(status);
		
		accountService.createRegister(account);
		CreateNumber numberAcc = new CreateNumber();
		numberAcc.createNum(MainEntry.numberAccount + 1);
		
	}
	
	

}
