package tester;

import java.util.Scanner;

import bank.running.AccountsM;

public class Tester 
{
	
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		AccountsM acc = new AccountsM();
//		acc.createAccount("personal", "d", "a", "1", "2");
//		int x = scan.nextInt();
//		System.out.println(acc.findAccID(x));
//		
		System.out.println("New Personal Account Sign Up");
		
		System.out.println("Please enter your First Name");
		String firstName = scan.nextLine();				

		
		System.out.println("Please enter your Last Name");
		String lastName = scan.nextLine();
		
		System.out.println("For logging into your Account");
		System.out.println("Please enter a Username");
		String userName = scan.nextLine();
				
		System.out.println("Password for log in?");
		String password = scan.nextLine();
	}
}
