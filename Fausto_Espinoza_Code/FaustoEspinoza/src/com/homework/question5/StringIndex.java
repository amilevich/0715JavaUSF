package com.homework.question5;

public class StringIndex {
	//Method generate subString with out String  methods
	static String subString(String arr, int index) {
		
		int n = 0;
		String r = new String();
		//Gets the size of the String
		for(char c : arr.toCharArray()) {
			n++;
		}
		
		//Gets the subString with the index
		for(int i = 0; i < index; i++) {
			r += arr.charAt(i);
		}
		
		return r;
		
	}
	
	public static void main(String[] args) {
		
		String arr = "Hello this is a test for string index";
		int index = 15;
		System.out.println(arr);
		System.out.println("The index is: " + index + " subString is: " +  subString(arr, index));
		
	}

}
