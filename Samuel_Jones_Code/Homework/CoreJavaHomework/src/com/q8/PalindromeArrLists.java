package com.q8;

import java.util.ArrayList;

public class PalindromeArrLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> allWords = new ArrayList<>(); //instantiate an ArrayList
		
		String[] all = {"karan","madam","tom","civic","radar","sexes","jimmy","john","refer","billy","did"}; //save all words to an array of Strings
		for(String s: all) { //add all words to the arraylist
			allWords.add(s);
		}
		
		//save the results of the storePalindromes method as a new ArrayList
		ArrayList<String> arrList = storePalindromes(allWords); 
		System.out.println(arrList); //print the ArrayList
		
	}
	
	//method to store the palindromes
	public static ArrayList<String> storePalindromes(ArrayList<String> arrList){ 
		ArrayList<String> pals = new ArrayList<>(); //instantiation of pals arraylist
		
		for(String s: arrList) { // iterate over every string in the list
			if(s.equals(reverseString(s))) { // whenever the string is equivalent to its reversed version
				pals.add(s); //add the palindrome to the pals object
			};
		}
		
		
		return pals;
	}
	
	// utility method for reversing strings
	public static String reverseString(String str) {
		String s = ""; // create a dummy string variable
		for(int i = str.length()-1; i>=0;i--){ // loop backwards through the string
			s+=str.charAt(i); //save the chars to the string object
		}
		
		return s;
	}

}
