package com.project.items;

import java.util.Scanner;

import com.project.prompt.DepositPrompt;
import com.project.prompt.WithdrawPrompt;

public class CustomerOneLogin {

	Scanner scan = new Scanner(System.in);
	int input = scan.nextInt();	
		
		System.out.println("\nEnter 1 to view single account");
		Scanner singleAccount = new Scanner(System.in);
		int a = singleAccount.nextInt();
		System.out.println("Enter 2 to view joint account.");
		Scanner jointAccount = new Scanner(System.in);
		int b = jointAccount.nextInt();
		System.out.println("Enter 3 to transfer funds.");
		Scanner transferFunds = new Scanner(System.in);
		int c = transferFunds.nextInt();
		System.out.println("Enter 4 to make deposit.");
		Scanner depositFunds = new Scanner(System.in);
		int d = depositFunds.nextInt();
		System.out.println("Enter 5 to make withdrawal");
		Scanner withdrawal = new Scanner(System.in);
		int e = withdrawal.nextInt();
		System.out.println("Enter 6 to exit account");
		Scanner exit = new Scanner(System.in);
		int f = exit.nextInt();
		//do while loop possible here 
		//while is the exit condition.
		*/
		
		switch (input) {
		case "1":
			//System.out.println(AccountDaoInMemory.accounts);
			SingleUserAccount singleUserAccount = new singleUserAccount;
		    singleUserAccount.run();
			break;		
		case "2":
			JointUserAccount jointUserAccount = new jointUserAccount;
		    jointUserAccount.run();
		case "3":
			return new TransferPrompt();
		case "4":
			return new DepositPrompt();
		case "5":
			return new WithdrawPrompt();
		case "6":
			return new ExitPrompt();
		default:
			System.out.println("Did not understand that selection, try again");
			break;
		}*/
}
