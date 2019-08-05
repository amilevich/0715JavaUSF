package com.accountScreen;

import java.time.LocalDate;
import java.util.Scanner;

import com.mainmenu.MainScreen;
import com.uncertainty.Account;

import dao.AccountCreate;
/*
 * account number
 * date
 * amount
 */

public class ScreenOfAccount {
	public void menuBridge() {
		Account account = new Account();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your account number.");
		String accountNumber = in.nextLine();
		Scanner in2 = new Scanner(System.in);
		System.out.println("Enter the starting amount.");
		Double amount = in2.nextDouble();
		LocalDate date = LocalDate.now();
		Scanner in3 = new Scanner(System.in);
		System.out.println("Please reenter your user id.");
		String id = in3.nextLine();
		
		
		
		
		
		account.setAccountNumber(accountNumber);
		account.setDate(date);
		account.setAmount(amount);
		account.setStatus('p');
		account.setId(id);
		
		
		MainScreen.account.add(account);
		AccountCreate thing = new AccountCreate();
		thing.addtoDB(account);
	}
}
