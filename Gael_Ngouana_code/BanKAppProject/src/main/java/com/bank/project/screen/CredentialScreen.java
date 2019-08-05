package com.bank.project.screen;

import java.util.List;
import java.util.Scanner;

import com.bank.project.inteface.GeneralRepository;
import com.bank.project.model.CredentialCustumer;
import com.bank.project.services.CredentialService;

public class CredentialScreen {
	public  void Screen(List<CredentialCustumer> credential) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		CredentialCustumer crdCustomer = new CredentialCustumer();
		String userName = new String();
		String passWord = new String();			
		
		System.out.print("Username: ");
		userName = scanner.nextLine();
		System.out.print("Password: ");
		passWord = scanner.nextLine();
		
		
		
		crdCustomer.setUserName(userName);
		crdCustomer.setPassWord(passWord);	
		
		
		GeneralRepository<CredentialCustumer> gRepository = new CredentialService();
		gRepository.createRegister(crdCustomer);
						
//		for(CredentialCustumer a : credential) {
//			System.out.println("Test: " + a.getUserName());
//		}
//		System.out.println();
	}		

}
