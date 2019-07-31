package com.homework;

import java.util.Scanner;

import com.problem11.SomeSuperClass;

public class Problem18 implements SomeSuperClass {
	String s = "";
	
	Problem18(String s) {
		this.s = s;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public boolean checkForUpperCases() {
		// TODO Auto-generated method stub
		
		//returns true if no lower case is detected
		for ( int i = 0; i < s.length() ; i++) {
			
			if ((s.charAt(i) >= 'a') && (s.charAt(i) <= 'z')) {
				return false;
			}
		}
		return true;
	}

	public void convertAllCasesToUpper() {
		// TODO Auto-generated method stub
		char c = ' ';
		int z = 0;
		String temp = " ";
		for ( int i = 0; i < s.length() ; i++) {
			c = s.charAt(i);
			
			if ((s.charAt(i) >= 'a') && (s.charAt(i) <= 'z')) {
				
				//Converting the char to int
				//Then subtracting 32 to be converted back into a char
				//Because I like to flex
				
				z = (s.charAt(i) - 32);
				c = (char)z;
				temp = temp + c; 
			} else {
				temp = temp + s.charAt(i);
			}
		}
			
			this.s = temp;
	}

	public String convertStringtoNumber() {
		// TODO Auto-generated method stub
		int z = 0;
		String temp = " ";
		for (int i = 0 ; i < this.s.length() ; i++) {
			z = (this.s.charAt(i) - 1 );
			z = z + 1;
			temp = temp + z;
		}
		
		//int D = Integer.parseInt(temp);
		return temp + 10;
		
				
	}
//	    Write a program having a concrete subclass that inherits three abstract methods from a superclass.  
//  	Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass: 
//
//		 Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
//		 Convert all of the lower case characters to uppercase in the input string, and return the result. 
//		 Convert the input string to integer and add 10, output the result to the console.
//		 Create an appropriate class having a main method to test the above setup.
	public static void main(String[] args) {
		
		
		//initiation of scanner class
		System.out.println("Please input a string");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		//Declaring input as a new object
		Problem18 foo = new Problem18(input);
		System.out.println(foo.checkForUpperCases());
		
		
		foo.convertAllCasesToUpper();
		
		System.out.println(foo.getS());
		
		System.out.println(foo.convertStringtoNumber());
		
		//System.out.println(result);
		//sc.close();
		
	}
	
	
}
