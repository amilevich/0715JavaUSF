package com.homework.q8;

import java.util.*;


public class PalindromeArray {
	static List<String> wordList = new ArrayList<>();  //ArrayList to be populated with requested strings
	static List<String> listOfPalindromes = new ArrayList<>(); //ArrayList to be populated with Palindrome Strings

	public static void main(String[] args) {
		//Populates ArrayList with Requested information
		wordList.add("karan");
		wordList.add("madam");
		wordList.add("tom");
		wordList.add("civic");
		wordList.add("radar");
		wordList.add("sexes");
		wordList.add("jimmy");
		wordList.add("kayak");
		wordList.add("john");
		wordList.add("refer");
		wordList.add("billy");
		wordList.add("did");

		isItPalindrome(wordList); //Calls The method that populates listOfPalindromes ArrayList from the given selection of Strings
		

	}

	static void isItPalindrome(List<String> list) {
		String reverse = "";  //Declares and initializes String variable reverse
		for (String word : list) {//traverses List of Strings
			for (int i = word.length() - 1; i >= 0; i--) {
				reverse = reverse + word.charAt(i); //Takes each String element and reverses it
			}
			if (word.equals(reverse)) {  //Checks if reversed String is equal to original String element
				listOfPalindromes.add(reverse); //If above condition is true, assign the palindrome to new ArrayList
				reverse=""; //Clears the reverse variable to take in a new String element
			}else{
				reverse=""; //Clears the reverse variable to take in a new String element if condition fails
			}
		}
		printArray(listOfPalindromes); //calls out printArray Method for our new ArrayList of Palindromes
	}
	
	static void printArray(List arr) {  //prints List
		for (int i = 0; i < arr.size() - 1; i++) {
			System.out.println(arr.get(i));
		}
	}

}
