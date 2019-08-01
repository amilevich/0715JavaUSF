package com.homework.quesone;

//Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList

import java.util.ArrayList;

public class QuesEight {

	public static void main(String[] args) {
		
		palidromeSyndrome(); // call our method		
	}
	
	public static void palidromeSyndrome() {
		
		String[] strArr = {"karan" , "madam" , "tom" , "civic" , "radar" , "sexes" , "jimmy" , "kayak" , "john" , "refer" , "billy" , "did"};
		
		ArrayList<String> arrList = new ArrayList<>(); // create new ArrayList arrList
		ArrayList<String> arrRes = new ArrayList<>(); // create new ArrayList arrRes
				
		for (String s: strArr) { // go through our String array 
			String revList = new StringBuffer(s).reverse().toString(); // create new string revList and use StringBuffer to create temp object  
			// and to do reverse and return string representation of the object use toString. 
			if (s.equals(revList)) arrList.add(s); // check if every element strArr equal to reverse of it then add to ArrayList 
			else arrRes.add(s); // otherwise add them to another ArrayList
		}	
		
		System.out.println(arrList); // print out result first
		System.out.println(arrRes);	// print out result second
		
		}	
}
