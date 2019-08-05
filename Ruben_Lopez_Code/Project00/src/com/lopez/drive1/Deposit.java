package com.lopez.drive1;

import java.util.Scanner;

public class Deposit {
	public static void deposit(String tracker, int key) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		
		double compareDouble = ((Customer) FileIn.getLmao().get(key)).getBalance();
		boolean flag = true;
		while (flag) {
			System.out.println("\n Please insert cash or check");
			
			
			double input = sc.nextDouble();
		
		
			if ( (input < 0)) {
				System.out.println("\n Error, do you like losing money");
			} else if (input == 0) {
				
				System.out.println("\n EXITING");
				
				flag = false;
			} else if ( input > 0){
				
				
				System.out.println("\n .....Withdrawing");
				((Customer) FileIn.getLmao().get(key)).setBalance(compareDouble + input);
				flag = false;
				double pseudoBalance = ((Customer) FileIn.getLmao().get(key)).getBalance();
				System.out.println("\n Balance is now" + pseudoBalance );
		
			}
		
		
		}
		
	}

}
