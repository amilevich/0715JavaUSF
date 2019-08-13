package com.bankdb.project.screen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.bankdb.project.VerifyNumber;
import com.bankdb.project.dao.implement.AccountDAOImpl;
import com.bankdb.project.dao.implement.PersonDAOImplement;
import com.bankdb.project.model.Account;
import com.bankdb.project.model.Person;

public class ReviewApliScreen {
	
	public void reviewApl() {		
		Scanner scanner = new Scanner(System.in);
		Account account = new Account();
		String kd = new String();
		long number = 0;
		String kind = new String();
		List<Account> accounts = new ArrayList<>();
		HashMap<Long, Account> accountMap = new HashMap<>();
		PersonDAOImplement personDAOImpl = new PersonDAOImplement();
		AccountDAOImpl accountImpl = new AccountDAOImpl();
		List<Person> people = new ArrayList<>(); 
		VerifyNumber vf = new VerifyNumber();
		String accountNumber;
		long count = 1;
		
		people = personDAOImpl.finAllRegister("C");
		
		
		if(people != null) {
			
			for(Person p : people) {
				accounts = accountImpl.finAllRegister(p, "P");	
				if(accounts != null) {
					System.out.println(p.getNmPerson());
					for(Account a : accounts) {
						accountMap.put(count, a);
						System.out.println(count + " -> " + a.getAccountNumber() + 
								(a.getStatus().equals("P") ? " pending" : ""));
						++count;
					}
				}
			}	
						
			do {
				System.out.println("Enter the option ");
				accountNumber = scanner.nextLine();				
			}while(!vf.verifyNum(--count, accountNumber) );
			
			number = Long.parseLong(accountNumber);
			do {
				System.out.println("1 -> Approve  ");
				System.out.println("2 -> Deny  ");		
				kd = scanner.nextLine();
				switch(kd) {
				case "1": kind = "A";
						break;
				case "2": kind = "D";
						break;
				default: System.out.println("No a valid option");
						 break;
				}
			} while(!kd.equals("1") && !kd.equals("2") );
			
			account = accountMap.get(number);
			account.setStatus(kind);
			accountImpl.updateRegister(account);	
			
		}		
	}
}
