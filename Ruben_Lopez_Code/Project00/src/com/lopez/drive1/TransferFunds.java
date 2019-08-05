package com.lopez.drive1;

import java.util.Scanner;

public class TransferFunds {
	
	public static void transferFunds(String tracker, int key) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		//CompareDouble is the current amount in the object
		double compareDouble = ((Customer) FileIn.getLmao().get(key)).getBalance();
		
		System.out.println("\n Which account would you like to transfer funds to ?");
		System.out.println(FileIn.getLmao().keySet());
		int inputInt = sc.nextInt();
			
		//Declaring the container for second account
		double pseudoBalance = 0.0;
			
			
		//checking for unique account selection
		boolean flag1 = true;
		while (flag1) {
				
			if ((key == inputInt) | (!(FileIn.getLmao().containsKey(inputInt)))) {
				System.out.println(	"\n try again, can't transfer to yourself "+
									"\n Or account does not exist!!!");
			}else if (key != inputInt) {
				
				// A valid account to transfer to is found
				flag1 = false;
				System.out.println("\n Alright");
				
				
			}
		}		
			
			
		System.out.println("\n What is the amount you would like to transfer");
			
		double input = sc.nextDouble();
		
		flag1 = true;
		while (flag1) {	
			if ((input > compareDouble) | (input < 0)) {
					System.out.println("\n Error, insuffient funds");
			} else if (input == 0) {
			
				System.out.println("\n EXITING");
			
				flag1 = false;
			} else if ( input < compareDouble){
				
				
			System.out.println("\n .....Withdrawing");
			((Customer) FileIn.getLmao().get(key)).setBalance(compareDouble - input);
			((Customer) FileIn.getLmao().get(inputInt)).setBalance(compareDouble + input);
			flag1 = false;
			pseudoBalance = ((Customer) FileIn.getLmao().get(key)).getBalance();
			System.out.println("\n Your Balance is now " + pseudoBalance );
			
			
			pseudoBalance = ((Customer) FileIn.getLmao().get(inputInt)).getBalance();
			System.out.println("\n Thier balance is now " + pseudoBalance);
		
			}
		}
	}
		
		
		
		
}


