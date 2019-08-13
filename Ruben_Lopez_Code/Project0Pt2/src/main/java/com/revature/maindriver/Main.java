package com.revature.maindriver;


import com.revature.dao.AccountDaoImpls;
import com.revature.model.Account;
import com.revature.singles.Register;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {

		

		
		System.out.println(	"\n	Login 		'LOG' "
				+ 			"\n	or Register?	'REG'");
		
		
		Scanner lc = new Scanner(System.in);
		
		String input = " ";
		
		//If end is input the whole program is dead
		while ( !(input.equals("END"))) {
			
			//First input is here
			input = lc.next();
			
			
			if (input.equals("LOG")) {
				
				
				//goes into the login user interface
				Loginmenu.login(input);
				
			} else if (input.equals("REG")) {
				
				//Register function
				Register.register();
				
				System.out.println("You are now Awaiting for administration to accept you");
			} else if (input.equals("END")){
				
				//signing out
				System.out.println("Ending program");
				return;
			} else {
				System.out.println("Exception !, try again");
				continue;
			}
			
			System.out.println("\n Welcome back to the main menu" + "\n would you like to Log back in or Register ");
			
				
		}
		
	}

}
