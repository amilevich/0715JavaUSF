package com.AdminStuff;

import java.util.Scanner;

public class Admin {

	public static void adminMenuDisplay() {
		Scanner sc = new Scanner(System.in);
		int option;
		do {
		System.out.println("Please select an option");
		System.out.println("1. View account/edit accounts");
		System.out.println("2. Cancel customer account");
		System.out.println("3. Withdraw");
		System.out.println("4. Deposit");
		System.out.println("5. Transfer funds");
		System.out.println("6. Exit");
		option = sc.nextInt();
		
		switch(option) {
		case 1:
			break;
			
		case 2:
			break;
			
		case 3:
			break;
			
		case 4:
			break;
			
		case 5:
			break;
			
		case 6:
			//mainMenu();
			break;
		
		
	}

}while (option != 6);
		
}
}