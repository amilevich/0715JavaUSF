package com.staff;

import java.util.Scanner;

import com.lopez.drive1.Customer;
import com.lopez.drive1.FileIn;

public class VAI {
	
	public static void vAI() {
		
		System.out.println(	"\n Input the account number" +
							"\n ");
		int inputIn;
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		
		String input = "";
		inputIn = sc.nextInt();
		boolean flag = true;
		while (flag) {
			if ( FileIn.getLmao().containsKey(inputIn) ) {

				System.out.println("User Name: " + ((Customer) FileIn.getLmao().get(inputIn)).getUserName());
				System.out.println("Password: " + ((Customer) FileIn.getLmao().get(inputIn)).getPassWord());
				
				flag = false;
			} else {
				System.out.println(	"\n Account not found!" +
									"\n Want to 'Try again' "+
									"\n Or 'exit' ");
				input = sc.next();
				if ( "exit".equals(input)) {
					flag = false;
				} else {
					System.out.println(	"\n Input the account number" +
										"\n ");
					inputIn = sc.nextInt();
				}
			}
		}
	}

}
