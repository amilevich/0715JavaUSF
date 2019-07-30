package com.homeworkcoreJava.q8;

import java.util.ArrayList;

//Answer to Question 8:
//Q8. Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
//Barton Carson
public class Question8 {

	//This function stores all strings in one arrayList, and all palindromes in another arrayList and prints to console
	public static void StoreAndPrint(String[] strarr) {

		ArrayList<String> arrListAll = new ArrayList<>();
		ArrayList<String> arrListPal = new ArrayList<>();
		for (String i : strarr) {

			arrListAll.add(i);
			if (isPalindrome(i)) {
				arrListPal.add(i);
			}
		}
		System.out.println(arrListAll.toString());
		System.out.println(arrListPal.toString());
	}

	
	//Function to check whether the string is a Palindrome
	public static boolean isPalindrome(String str) {

		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}
		if (str.equals(rev)) {
			return true;
		}
		return false;
	}

	//Main function
	public static void main(String[] args) {

		String[] strarr = { "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did" };
		StoreAndPrint(strarr);
	}
}