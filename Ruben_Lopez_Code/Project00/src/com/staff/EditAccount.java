package com.staff;

import java.util.Scanner;

import com.lopez.drive1.Customer;
import com.lopez.drive1.Deposit;
import com.lopez.drive1.FileIn;
import com.lopez.drive1.Withdraw;

public class EditAccount {

	public static void editaccount(int inputInt) {
		Scanner sc = new Scanner(System.in);
		String input = " ";
		// TODO Auto-generated method stub
		
		boolean flag = true;
		while (flag) {
			System.out.println(	"\n	What attirbute would you like to edit"+
							"\n	First Name			FN"+
							"\n	Last Name 			LN"+
							"\n	address				ADS"+
							"\n	city				CITY"+
							"\n	UserName			UN"+
							"\n	Password			PASS");
		
			input = sc.next();
			
			if ("FN".equals(input)){
				
				System.out.println(	"\n How would you like to change attribute" +
									"\n Here ia old attribute");
				String temp = ((Customer) FileIn.getLmao().get(inputInt)).getfName();
				System.out.println(temp);
				input = sc.next();
					
				((Customer)FileIn.getLmao().get(inputInt)).setfName(input);					
				flag = false;
				
			} else if ("LN".equals(input)) {
				
				System.out.println(	"\n How would you like to change attribute" +
						"\n Here ia old attribute");
				String temp = ((Customer) FileIn.getLmao().get(inputInt)).getlName();
				System.out.println(temp);
				input = sc.next();
		
				((Customer)FileIn.getLmao().get(inputInt)).setlName(input);					
				flag = false;
				
				
			} else if ("ADS".equals(input)) {
				System.out.println(	"\n How would you like to change attribute" +
						"\n Here ia old attribute");
				String temp = ((Customer) FileIn.getLmao().get(inputInt)).getAddress();
				System.out.println(temp);
				input = sc.next();
		
				((Customer)FileIn.getLmao().get(inputInt)).setAddress(input);					
				flag = false;
				
				
			} else if ("CITY".equals(input)) {
				System.out.println(	"\n How would you like to change attribute" +
						"\n Here ia old attribute");
				String temp = ((Customer) FileIn.getLmao().get(inputInt)).getCity();
				System.out.println(temp);
				input = sc.next();
		
				((Customer)FileIn.getLmao().get(inputInt)).setCity(input);					
				flag = false;
				
			} else if ("UN".equals(input)) {
				System.out.println(	"\n How would you like to change attribute" +
						"\n Here ia old attribute");
				String temp = ((Customer) FileIn.getLmao().get(inputInt)).getUserName();
				System.out.println(temp);
				input = sc.next();
		
				((Customer)FileIn.getLmao().get(inputInt)).setUserName(input);					
				flag = false;
				
			} else if ("PASS".equals(input)){
				System.out.println(	"\n How would you like to change attribute" +
						"\n Here ia old attribute");
				String temp = ((Customer) FileIn.getLmao().get(inputInt)).getPassWord();
				System.out.println(temp);
				input = sc.next();
		
				((Customer)FileIn.getLmao().get(inputInt)).setPassWord(input);					
				flag = false;
				
			} else {
				
				System.out.println("Try again");
			}
		
		//super(balance, fName, lName, address, city, userName, passWord);
		// TODO Auto-generated constructor stub
		}
		
	}

}
