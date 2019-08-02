package com.example.question8;

import java.util.ArrayList;

public class Palindrome {

	public static void main(String[] args) {
		
		// Creates an ArrayList to store the names

		ArrayList<String> myList = new ArrayList<String>();
		
		// Create Arraylist for names that are palindromes

		ArrayList<String> myPalindromes = new ArrayList<String>();
		
		// Seperate list for those that aren't palindromes

		ArrayList<String> noPalindromes = new ArrayList<String>();
		
		// Adds the names to the first/ original list

		myList.add("karan");

		myList.add("madam");

		myList.add("tom");

		myList.add("civic");

		myList.add("radar");

		myList.add("sexes");

		myList.add("jimmy");

		myList.add("kayak");

		myList.add("john");

		myList.add("refer");

		myList.add("billy");

		myList.add("did");

		for (String palin : myList) {

			// boolean to check if it is a palindrome

			boolean palindrome = isPalindrome(palin);

			// if it is a palindrome

			if (palindrome)

			{

				// adds the palindrome word to the palindrome Arraylist

				myPalindromes.add(palin);

			}

			else {

				// adds the non palindrome to the NonPalindrome ArrayList

				noPalindromes.add(palin);

			}

		}

		// print out the different lists to the console

		System.out.println("Original list: ");

		System.out.println(myList);

		System.out.println("Palindrome list: ");

		System.out.println(myPalindromes);
		
		System.out.println("Non-Palindrome list");
		
		System.out.println(noPalindromes);

	}
	
	// method for checking whether a string is a palindrome

	public static boolean isPalindrome(String name) {

		if (name == null || name.isEmpty())

			return false;

		// this take the string passed it reverses it and compares if its equal to
		// itself

		// it returns a boolean

		return new StringBuilder(name).reverse().toString().equals(name);

	}

}
