package com.homework;

public class Problem03 {
	
	public static void main(String [] args) {
		
		
		//Instantiates string 
		
		String s = "Star";
		s = reverse(s);
		System.out.println(s);
	}

	private static String reverse(String s) {
		// TODO Auto-generated method stub
		

		for (int i = s.length()-1; i > -1 ; i--  ){
			
			//append to existing string
			s = s + s.charAt(i);
			
		}
		//Cuts first half of string	
		return s = s.substring(((s.length())/2), s.length() );
		
	}
}
