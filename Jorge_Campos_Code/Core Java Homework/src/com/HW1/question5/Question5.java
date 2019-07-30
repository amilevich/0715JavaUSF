package com.HW1.question5;

import java.util.Scanner;

public class Question5 {
	//Write a substring method that accepts a string str and an integer
	// idx and returns the substring contained between 0 and idx-1 
	// inclusive.  Do NOT use any of the existing substring methods in
	// the String, StringBuilder, or StringBuffer APIs.
	
	static String subString(String str, int idx) {
		String result = "";
		if(idx > str.length()) {
			System.out.println("Error, index beyond string range!");			//Checking to make sure index is within range
			return "ERROR";
		}else
			for(int i=0; i<idx; i++) {
				result += Character.toString(str.charAt(i));		//Utilizing char to build up a sub string
			}		
		return  result;
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter string: ");
		String str = sc.nextLine();
		System.out.println("Please enter number of characters to display: ");
		int input = sc.nextInt();
		
		System.out.println(subString(str,input));
		
		sc.close();

	}

}
