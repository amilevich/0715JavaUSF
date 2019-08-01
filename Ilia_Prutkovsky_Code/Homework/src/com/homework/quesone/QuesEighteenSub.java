package com.homework.quesone;

import java.util.Scanner;

public class QuesEighteenSub extends QuesEighteen {
	
	public static void main(String[] args) {
		
		QuesEighteen obj = new QuesEighteenSub();
		
		Scanner scan = new Scanner(System.in); // create a new object for class Scanner		
		System.out.print("Input from 1 to 3: "); 
		int num = scan.nextInt(); // assign variable n with type integer to digit that was inputed from console	
				
		switch(num) {
		case 1: 
			obj.upperCaseCheck();
			break;
		
		case 2:
			obj.lowerToUpperCase();
			break;
		
		case 3:
			obj.stringToInteger();
			break;			
		}
		scan.close();						
	}
	
	@Override
	public void upperCaseCheck() {
		
		Scanner scan = new Scanner(System.in); // create a new object for class Scanner
		System.out.print("Input your sentence, please: ");
		String s = scan.nextLine(); // assign variable s with type string to string that was inputed from console
		scan.close(); // close Scanner class if no more input from console
			
		for (int i = 0; i < s.length(); i++)
	    {
	        if (!Character.isUpperCase(s.charAt(i))) System.out.println("False");
	        else System.out.println("True");	        
	    }
	}

	@Override
	public void lowerToUpperCase() {
		Scanner scan = new Scanner(System.in); // create a new object for class Scanner
		System.out.print("Input your sentence, please: ");
		String s = scan.nextLine(); // assign variable s with type string to string that was inputed from console
		scan.close(); // close Scanner class if no more input from console
		System.out.println(s.toUpperCase());
				
	}

	@Override
	public void stringToInteger() {
		Scanner scan = new Scanner(System.in); // create a new object for class Scanner
		System.out.print("Input digit, please: ");
		String s = scan.nextLine(); // assign variable s with type string to string that was inputed from console
		scan.close(); // close Scanner class if no more input from console
		System.out.println(Integer.parseInt(s) + 10);
		
	}

}
