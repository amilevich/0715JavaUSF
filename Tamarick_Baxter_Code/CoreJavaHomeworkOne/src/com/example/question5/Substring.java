package com.example.question5;

public class Substring {

	public static void main(String[] args) {
		
		System.out.println(substring("WorksLikeACharm", 5));
		

	}
	
	// Method for created a substring
	// will grab from Index 0 up to number specified
	
	public static String substring(String str, int idx) {
		// create a temporary variable that will store characters
		String temp = "";
		for(int i = 0; i < idx; i++) {
			
			// the character will be appended to the temp variable
			temp += str.charAt(i);
		}
		
		return temp;
	}

}
