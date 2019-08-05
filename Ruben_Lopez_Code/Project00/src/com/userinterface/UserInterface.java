package com.userinterface;

import com.lopez.drive1.Customer;
import com.lopez.drive1.FileIn;
import com.lopez.drive1.FileOut;
import com.userinterface.*;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class UserInterface {

	static TempAccount tempAccount = new TempAccount();
		
	
	
	
	
	public static TempAccount getTempAccount() {
			return tempAccount;
		}

		public static void setTempAccount(TempAccount tempAccount) {
			UserInterface.tempAccount = tempAccount;
		}

	public static void main(String[] args) throws IOException {
		
		
		
		FileIn.mainFileIn();
		System.out.println("Hello");
		
		System.out.println("Log in or Register?");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		String input = " ";
		
		//If end is input the whole program is dead
		while ( !(input.equals("END"))) {
			
			//First input is here
			input = sc.next();
			
			
			if (input.equals("Log")) {
				
				
				//goes into the login user interface
				Login.login(input);
				
			} else if (input.equals("Register")) {
				
				//goes into the 
				Register.register(input);
				
				System.out.println("You are now Awaiting for administration to accept you");
			} else {
				System.out.println("Exception !, try again");
				continue;
			}
			
			System.out.println("\n Welcome back to the main menu" + "\n would you like to Log back in or Register ");
			
				
		}
		
		FileOut.writeList();
	}
	

	//checking password from database
	static boolean passwordIsTrue(String input1) {
		// TODO Auto-generated method stub
		for (Entry<Integer, Object> entry : FileIn.getLmao().entrySet()) {
			
			//Checks if input is equal to the PassWord inside an object, through a for each loop of entry key, inside a map 'LMAO', through File class
		    if (input1.equals((((Customer) FileIn.getLmao().get(entry.getKey())).getPassWord() )) ) {
				return true;
			}
		}
		
		return false;
	}

	
	//checking user name from database
	static boolean userNameIsTrue(String input) {
		// TODO Auto-generated method stub
		
		//An ITERATOR OF A LINKED MAP
		for (Entry<Integer, Object> entry : FileIn.getLmao().entrySet()) {
			
			//Checks if input is equal to the user name inside an object, through a for each loop of entry key, inside a map 'LMAO', through File class
		    if (input.equals((((Customer) FileIn.getLmao().get(entry.getKey())).getUserName() )) ) {
				return true;
			}
		}

		
		return false;
	}
	
	public static Object getObjectTypeByUserName(String input) {
		for (Entry<Integer, Object> entry : FileIn.getLmao().entrySet()) {
  			
  			//Checks if input is equal to the user name inside an object, through a for each loop of entry key, inside a map 'LMAO', through File class
  		    if (input.equals((((Customer) FileIn.getLmao().get(entry.getKey())).getUserName() )) ) {
  				return (FileIn.getLmao().get(entry.getKey()));
  				
  			}
  		}
		return -1;
	}
	
	
	


}
