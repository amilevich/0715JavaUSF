package com.bank.project.screen;

import java.util.ListIterator;
import java.util.Scanner;

import com.bank.project.FileWriterTXT;
import com.bank.project.AdminManager.EmployeeMenu;
import com.bank.project.model.Account;

public class CancelAccount {
	public void cnncel() {
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
		System.out.println("Enter the Account to cacel ");
		String accountNumber = scanner.nextLine();			
		
		for(Account c : EmployeeMenu.account) {
			if(c.getAccountNumber().equals(accountNumber)) {
				idCustumer = c.getId();
//				System.out.println("Account number "+ c.getAccountNumber() + " customer " + c.getNmCustomer());
//				System.out.println(idCustumer);
				break;
			}			
		}
		
		
		ListIterator<Account> iterator = EmployeeMenu.account.listIterator();
		kind = 'C';
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
