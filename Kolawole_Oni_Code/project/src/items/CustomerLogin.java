package items;

import java.util.Scanner;
//import x.Application 
//import x.ApprovedApplication
//import x.UtilityPrompts

import Menus.CustomerMenu;
import Menus.MainMenu;
import bankapp.Account;
import bankapp.ApprovedApplication;

//import com.revature.daos.AccountDaoInMemory;

//class HomePrompt implements Prompt
public class CustomerLogin {

	
	//package Menus;


	//import java.util.Scanner;

	//import items.Account;
	//import items.ApprovedAccounts;
	//import items.UtilityMenus;

   //Take options for customer and use a method actionMenu to indicate choice
	//
		static Scanner sc = new Scanner(System.in);
		private static String[] optionsArray = {"0. View your account.", "1. Deposit", "2. Withdraw", "3. Transfer", "4. Cancel an Account","5. Return to previous menu"};
		
		public static void loginMenu() {
			ApprovedApplication.customerLogin();//ApprovedApplication has a method customerLogin
		}
		
		//to create a call to Application which parents DeniedApplication and ApprovedApplication
		public static void actionMenu(ApprovedApplication a) {
			
			System.out.println("Welcome customer, what would you like to do?");
			
			for(int i =0; i<optionsArray.length;i++) {
				System.out.println(optionsArray[i]);
			}
			
			int choice = sc.nextInt();
			CustomerMenu.handleInput(choice, a);
			
		}
		//actionPrompts, Utility prompts, firstprompts or firstlogin
		//will be used here to handle different operations
		
		
		public static void handleInput(int choice, Account a) {
			System.out.println("Choice was " + choice);
			boolean flag = true;
			while(flag) {
				
				switch(choice) {
				case 0: 
					System.out.println(a.toString());
					actionMenu(a);
					flag=!flag;
					break;
				case 1: 
					UtilityMenus.depositMenu(a);
					flag=!flag;
					break;
				case 2:
					UtilityMenus.withdrawMenu(a);
					flag=!flag;
					break;
				case 3:
					UtilityMenus.transferMenu(a);
					flag=!flag;
					break;
				case 4:
					UtilityMenus.cancelMenu(a);
					flag=!flag;
					break;
				case 5:
					MainMenu.mainMenu();;
					flag=!flag;
					break;
				default: 
					System.out.println("Enter 1, 2, or 3.");
					flag=!flag;
					break;
				}
			}
			}
	

	public void run() {
		
	}
	}
	
		//int input = "";
	  /*  Scanner scan = new Scanner(System.in);
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
			
		/*	switch (input) {
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
