package com.question5.substring;

public class MySubstring {
	
	
	static void mySub(String str, int numb) {
		
		String str1 = "";
		
		// Loop to go through each letter of the string up to the specified upper limit.
		
		for(int i = 0; i < numb; i++) {
			
			str1 += str.charAt(i); //concatenation of all the letters for the specific range specified in the for loop.
			
			
		}
		
		System.out.println(str1);
		
			
		}
		
		
	
	public static void main(String[] args) {
		
		mySub("Beautiful", 2);

	

	}
}
