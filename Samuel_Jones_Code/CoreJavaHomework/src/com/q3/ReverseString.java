package com.q3;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String yum = "vegan donut"; // string to reverse
		
		System.out.println("Method one"); //for labeling the console output
		reverseString(yum); // run the method
		System.out.println("\n");// new line
		System.out.println("Method two");// label
		String reverseTwo = reverseString2(yum); // save the output of the second reverseString method
		
		System.out.println(reverseTwo); // print the output of the second method
		
	}
	
	public static void reverseString(String str) {
		for(int i = str.length()-1; i>=0;i--){ // from the end of the string until the beginning
			System.out.print(str.charAt(i)); // print the char at every index 
		}
	}
	
	public static String reverseString2(String str) { // more elaborate approach 
		for(int i = str.length()-1; i>-1; i--) { // loop backwards through the string
			str += str.charAt(i); // concatenate each char to the original string
		}
		
		return str = str.substring((str.length()/2), str.length()); //divide the resulting string by 2, and chop off the first half (the word in the original order)
	}
}
