package com.HW1.question8;

import java.util.ArrayList;
import java.util.Arrays;

public class Question8 {

	static boolean isPalindrome(String input) { 			// method to check if string is a palindrome, returns true if is
		for (int i = 0; i < input.length() / 2; i++) { 		// a palindrome, false if it is not
			if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ArrayList<String> arrList = new ArrayList<>();
		arrList.addAll(Arrays.asList("karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",
				"refer", "billy", "did"));
		ArrayList<String> palindromes = new ArrayList<>();

		for (int i = 0; i < arrList.size(); i++) { 		// for loop to check all elements
			if (isPalindrome(arrList.get(i)))
				palindromes.add(arrList.get(i)); 		// if they are palindromes are added to separate arrayList
		}
		System.out.println("Palindromes: " + palindromes);
	}
}
