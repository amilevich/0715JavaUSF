package com.lopez.drive1;

import java.util.Scanner;

public class JointAccounts {

	public static void jointAccount(int key) {
		
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		
		
		int inputInt = 0;
		
		
		//checking for unique account selection
		boolean flag1 = true;
		while (flag1) {
			
			System.out.println("\n Hello, please select ");
			System.out.println(FileIn.getLmao().keySet());
			
			inputInt = sc.nextInt();
						
			if ((key == inputInt) | (!(FileIn.getLmao().containsKey(inputInt)))) {
					System.out.println(	"\n try again, can't apply to a joint account to yourself "+
											"\n Or account does not exist!!!");
			}else if (key != inputInt) {
					
				// A valid account to transfer to is found
				flag1 = false;
				System.out.println("\n Alright, joint account pending on other party");
				((Customer) FileIn.getLmao().get(key)).setPendingJointNumber(inputInt);
				((Customer) FileIn.getLmao().get(key)).setJointNumber(inputInt);
						
			}
		}
		
		
				
		
		
	}
	
	

}
