package com.q5;

public class SubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  
		 */
		
		System.out.println(subString("Hello",3)); // find the substring of Hello between indices 0 and 3.
		System.out.println(subString("pokemon",4)); // find the substring of pokemon between indices 0 and 4.
		
		
	}
	
	public static String subString(String str, int idx) { // method for finding substrings
		
		String s =""; //save a dummy String
		for(int i = 0; i<=idx-1;i++) { // start at 0, loop until one less than the provided value is reached
			s+=str.charAt(i); // append each char to the dummy string
			
		}
		return s; //return the new string.
	}

}
