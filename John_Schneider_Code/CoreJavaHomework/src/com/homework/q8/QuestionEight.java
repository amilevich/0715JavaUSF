package com.homework.q8;

import java.util.ArrayList;
import java.util.Arrays;

public class QuestionEight
{
	/*
	 * Store given strings in an arraylist and copy palindromic strings into another arraylist
	 */
	
	//Method to determine if given string is a palindrome or not
	//returns true if it is a palindrome, false if it is not
	public static boolean isPalindrome(String str)
	{
		//Iterates over characters in the given string checking equality between each and their mirror
		//Mirror character refers to character same length from end of string as current string is from beginning
		//Only needs to iterate over half of the string as equality checking operation covers the other half
		//If at any point an unequal character/mirror-character is found, string is not a palindrome and false is returned
		for(int i=0; i<str.length()/2;i++)
			if(str.charAt(i) != str.charAt(str.length()-1-i))
				return false;
		
		//If loop was able to iterate over entire string without find an unequal character/mirro-character, string is a palindrome and true is returned
		return true;
	}
	
	//Method to populate and return a new arraylist with only palindromic strings from a given arraylist
	public static ArrayList<String> getPalindromes(ArrayList<String> strings)
	{
		//New arraylist to hold palindromes is created
		ArrayList<String> palindromes = new ArrayList<>();
		
		//for-each loop to iterate over all strings in the given arraylist and check if each is a palindrome based on logic of isPalindrome() method
		//If the given string is a palindrome, add it to the palindromes arraylist
		for(String s : strings)
			if(isPalindrome(s))
				palindromes.add(s);
		
		//return the newly populated palindromes arraylist
		return palindromes;
	}
	
	public static void main(String[] args)
	{
		//create new arraylist with given strings
		ArrayList<String> strings = new ArrayList<>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"));
		
		//Print out all the given strings
		System.out.println("All Strings in list: ");
		for(String s : strings)
			System.out.print(s+" ");
		
		System.out.println("\n");
		
		//create a new arraylist to hold palindromes from given strings
		ArrayList<String> palindromes = getPalindromes(strings);
		
		//Print out the newly created arraylist of given palindromes 
		System.out.println("Palindromes in list: ");
		for(String s : palindromes)
			System.out.print(s+" ");
	}
}