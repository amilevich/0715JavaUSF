package com.homework;

import java.util.ArrayList;

public class Problem08 {
	public static void main(String[] args) {
		
		//creates two ArrayList
		ArrayList<String> aList = new ArrayList<String>();
		ArrayList<String> bList = new ArrayList<String>();
		
		aList.add("karan");
		aList.add("madam");
		aList.add("tom");
		aList.add("civic");
		aList.add("radar");
		aList.add("sexes");
		aList.add("jimmy");
		aList.add("kayak");
		aList.add("john");
		aList.add("billy");
		aList.add("did");
		aList.add("racecar");
		
		//writes list a to list b
		 bList = palindromes(aList);
		 
		 for ( String a : bList) {
			 System.out.println(a);
		 }
		
	}

	private static ArrayList<String> palindromes(ArrayList<String> aList) {
		
		// TODO Auto-generated method stub
		
		//temp arrayList
		ArrayList<String> buffer = new ArrayList<String>();
		for (int i = 0 ; i < aList.size(); i++) {
			System.out.println(aList.get(i));
			if (checkForPalindrones(aList.get(i))) {
				//Appends ArrayList if CheckForPalindrones returns true
				buffer.add(aList.get(i));
			}
		}
		return buffer;
	}

	private static boolean checkForPalindrones(String string) {
		// TODO Auto-generated method stub
		
		//the function has two  indexes that compare the two chars 
		for ( int j = 0 , k = string.length()-1; j < string.length(); j++,k--) {
			System.out.println(string.charAt(j) + " " + string.charAt(k));
			if (string.charAt(j) != string.charAt(k)) {
				return false;
			}
		}
		
		return true;
		
	}
	
	
	
	
	

}
