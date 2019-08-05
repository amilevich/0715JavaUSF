package com.lopez.drive1;
import com.lopez.drive1.Customer;
import java.util.Scanner;

import com.userinterface.UserInterface;

public class Withdraw {

	public static void withdraw(String tracker, int key) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		
		double compareDouble = ((Customer) FileIn.getLmao().get(key)).getBalance();
		boolean flag = true;
		while (flag) {
			System.out.println("\n How much would you like to withdraw");
			
			
			double input = sc.nextDouble();
		
		
			if ((input > compareDouble) | (input < 0)) {
				System.out.println("\n Error, insuffient funds");
			} else if (input == 0) {
				
				System.out.println("\n EXITING");
				
				flag = false;
			} else if ( input < compareDouble){
				
				
				System.out.println("\n .....Withdrawing");
				((Customer) FileIn.getLmao().get(key)).setBalance(compareDouble - input);
				flag = false;
				double pseudoBalance = ((Customer) FileIn.getLmao().get(key)).getBalance();
				System.out.println("\n Balance is now" + pseudoBalance );
		
			}
		
		
		}
		
	}

	
	
}
	
	

