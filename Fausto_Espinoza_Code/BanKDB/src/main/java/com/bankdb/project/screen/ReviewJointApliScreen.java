package com.bankdb.project.screen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.bankdb.project.VerifyNumber;
import com.bankdb.project.dao.implement.AccountDAOImpl;
import com.bankdb.project.dao.implement.JointAccountDaoImpl;
import com.bankdb.project.dao.implement.PersonDAOImplement;
import com.bankdb.project.model.Account;
import com.bankdb.project.model.JointAccount;
import com.bankdb.project.model.Person;

public class ReviewJointApliScreen {
	
	public void reviewApl() {		
		Scanner scanner = new Scanner(System.in);
		Account account = new Account();
		String kd = new String();
		long number = 0;
		String kind = new String();
		List<JointAccount> Jaccounts = new ArrayList<>();
		HashMap<Long, JointAccount> accountMap = new HashMap<>();
		PersonDAOImplement personDAOImpl = new PersonDAOImplement();
		AccountDAOImpl accountImpl = new AccountDAOImpl();
		JointAccount jaccount = new JointAccount();
		List<Person> people = new ArrayList<>(); 
		VerifyNumber vf = new VerifyNumber();
		JointAccountDaoImpl jacntDaoImpl = new JointAccountDaoImpl();
		String accountNumber;
		long count = 1;
		
		people = personDAOImpl.finAllJntRegister("C");
		
		
		if(people != null) {
			boolean flg = true;
			for(Person p : people) {
				Jaccounts =  jacntDaoImpl.findByIdCustomer(p,"P");
				if(Jaccounts != null) {
					flg = true;
					System.out.println(p.getNmPerson());
					for(JointAccount a : Jaccounts) {
						accountMap.put(count, a);
						System.out.println(count + " -> " + a.getAccountnumber() + 
								(a.getStatus().equals("P") ? " pending" : ""));
						++count;
					}
				}else flg = false;
			}	
			if(flg)	{		
				do {
					System.out.println("Enter the option ");
					accountNumber = scanner.nextLine();				
				}while(!vf.verifyNum(--count, accountNumber) );
				
				number = Long.parseLong(accountNumber);
				
				do {
					System.out.println("1 -> Joint Acount  ");
					System.out.println("2 -> Deny  ");		
					kd = scanner.nextLine();
					switch(kd) {
					case "1": kind = "J";
							break;
					case "2": kind = "D";
							 break;
					default: System.out.println("No a valid option");
							 break;
					}
				} while(!kd.equals("1") && !kd.equals("2"));
				
				
				jaccount = accountMap.get(number);
				jaccount.setStatus(kind);
				
				if(jacntDaoImpl.updateRegister(jaccount,"P")) {
					System.out.println("Transacction successful");
				}
			
			}
			
		}		
	}
}
