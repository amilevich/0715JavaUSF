package com.example.stringstuff;

public class MyClass {

	public static void main(String[] args) {
		
		String str = "I like this buritto class and it is fancy.";
		
		//returns an index of first occurance of character 's'
		int firstIndex = str.indexOf('s');
		System.out.println("First occurance of char 's' is at index: " + firstIndex);
		
		int lastIndex = str.lastIndexOf('s');
		System.out.println("Last occurance of char 's' is at "
				+ "index: " + lastIndex);
		
		int first_in = str.indexOf('s', 15);
		System.out.println("First occurance of char 's' after "
				+ "index 15 is: " + first_in);
		
		//gives ASCII valye of character at location 14, index 13
		int char_at = str.charAt(13);
		System.out.println("Character at location 13 is: " + char_at);
	}

}
