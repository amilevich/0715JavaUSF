package com.substring;

import java.util.LinkedList;
import java.util.Queue;

public class SubStringMethod {
// Write a substring method that accepts a string str and an integer idx and returns
	//the substring contained between 0 and idx-1 inclusive.  Do NOT use any of the 
	//existing substring methods in the String, StringBuilder, or StringBuffer APIs.
	
	public static void main(String[] args) {
	
		
		
		myStringMethod("Zombie",2);
		
		

	}
	public static String myStringMethod(String str, int idx) {
		String sub = str;
		    
		for(int i = 0; i < idx; i++) {
			
			System.out.print(sub.charAt(i));
		}
		
		return sub;
	}

}
