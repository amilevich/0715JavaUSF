package com.homeworkcoreJava.q5;

import java.util.ArrayList;

//Answer to Question 5:
//Q5. Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.
//Barton Carson
public class Question5 {

	public static void main(String[] args) {
		
		int idx = 5;
		String str = "BillyBoy";
		System.out.println(subString(str, idx));

	}
	
	public static String subString(String str, int idx) {
		
		ArrayList<String> str1 = new ArrayList<String>();
		
		//breaks up the string into an arrayList of strings each with one character in them
		for (int i = 0; i < idx; i++) {
			str1.add(String.valueOf(str.charAt(i)));	
		}
		
		//uses a string builder and a for each loop to append each arrayList string into one string builder
		StringBuilder sb = new StringBuilder();
		
		for (String s : str1) {
		    sb.append(s);
		}
		//returns the requested string to the console
		return sb.toString();	
	}
}