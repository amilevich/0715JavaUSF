package com.project.bankapp;

public class EmpOneLogin implements Login  {
	
	//EmpLogin will parent EmpOneLogin
	//EmpOneLogin will parent AdminOneLogin
	
	//package com.revature.prompts;

	import java.util.Scanner;

import com.project.items.DepositPrompt;

	//import com.revature.daos.AccountDaoInMemory;


	//public class EmpOneLogin implements Login {

		private Scanner scan = new Scanner(System.in);
		
		
		@Override
		public Login run() {
			String input;

			while (true) {
				
				
				System.out.println("\nEnter 1 to view accounts");
				System.out.println("Enter 2 to view specific account.");
				System.out.println("Enter 3 to see account balance");
				System.out.println("Enter 4 to make deposit.");
				System.out.println("Enter 5 to make withdraw");
				System.out.println("Enter 6 to view another account");
			
				input = scan.nextLine();
				switch (input) {
				case "1":
					System.out.println(AccountDaoInMemory.accounts);
					break;		
				case "2":
					return new AddPrompt();
				case "3":
					return new RemovePrompt();
				case "4":
					return new DepositPrompt();
				case "5":
					return new WithdrawPrompt();
				case "6":
					return new InterestPrompt();
				default:
					System.out.println("Did not understand that selection, try again");
					break;
				}
			}
		}

	

}
