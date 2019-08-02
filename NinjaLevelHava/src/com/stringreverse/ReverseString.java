package com.stringreverse;

public class ReverseString {
    //Reverse a string without using a temporary variable.
	//Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.

	public static void main(String[] args) {
		String chimiChanga = "!!!agnahcimihC";
		
		
		for(int i = chimiChanga.length()-1; i >= 0; i--) {
			System.out.print(chimiChanga.charAt(i));
		}
		
		

	}
       

}
