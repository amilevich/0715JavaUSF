package com.bank.project.screen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.swing.text.html.parser.Entity;

import com.bank.project.FileWriterTXT;
import com.bank.project.MainEntry;
import com.bank.project.AdminManager.EmployeeMenu;
import com.bank.project.model.Account;

public class ReviewApliScreen {
	
	public void reviewApl() {
		FileWriterTXT<Account> filename = new FileWriterTXT();
		Scanner scanner = new Scanner(System.in);
		Account account = new Account();
		char kind = ' ';
		
		for(Account c : EmployeeMenu.account) {
			if(c.getStatus() == 'P') {
				System.out.println("Account number "+ c.getAccountNumber() + " customer " + c.getNmCustomer() + " ID " + c.getId());
			}			
		}
		String idCustumer = new String();
		System.out.println("Enter the Account ");
		String accountNumber = scanner.nextLine();
		
		
		int kd =0 ;
		do {
			System.out.println("1 -> Approve  ");
			System.out.println("2 -> Deny  ");		
			kd = scanner.nextInt();
			switch(kd) {
			case 1: kind = 'A';
					break;
			case 2: kind = 'D';
					break;
			default: System.out.println("No valid option");
					 break;
			}
		} while(kd != 1 && kd != 2 );
		
		
		
		for(Account c : EmployeeMenu.account) {
			if(c.getAccountNumber().equals(accountNumber)) {
				idCustumer = c.getId();
//				System.out.println("Account number "+ c.getAccountNumber() + " customer " + c.getNmCustomer());
//				System.out.println(idCustumer);
				break;
			}			
		}
		
		
		ListIterator<Account> iterator = EmployeeMenu.account.listIterator();
		
		Account ac ;
		while(iterator.hasNext()) {
			ac = iterator.next();
			if(ac.getAccountNumber().equals(accountNumber) && ac.getId().equals(idCustumer)) {				
				ac.setStatus(kind);
				iterator.set(ac);
				break;
			}
		}
			
		
		filename.updateFile(EmployeeMenu.account, "./DataBase/Account.txt");
		
	}

}
