package com.q18;

public class ConcreteClass extends SuperClass {
	public boolean anyUpperCase(String word) {
		
		// using the Character wrapper class's isUpperCase method, 
//		loop through the word checking the case of each Character
		for(int i =0;i<word.length();i++) {
			if(Character.isUpperCase(word.charAt(i))) { 
				return true;
			}
		}
		
		return false;
	}
	
	//converts lowercase words to uppercase letters using the toUpperCase method of Character
	public String convertLowerCase(String word) {
		String s = "";
		
		for(int i=0; i<word.length();i++) {
			s+=Character.toUpperCase(word.charAt(i));
		}
		return s;
	}
	
	// converts to Integer a String such as "5" "6" or "7"
	public void convertToInt(String str) {
		int s = Integer.valueOf(str);
		System.out.println(s);
	}
}
