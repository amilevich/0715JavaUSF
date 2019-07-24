package com.example.palindrome;

import java.util.Scanner;

public class MyClass {

	// palindrome examples - "madam", "racecar", "otto"
	// a user will input a word
	// your task is to let the user know if his/her word is
	// a palindrome or not

	public static void main(String[] args) {
		String original, reverse = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a string to " + "check if it is a palindrome... or else");
		original = sc.nextLine();

		for (int i = original.length() - 1; i >= 0; i--) {
			reverse = reverse + original.charAt(i);
		}
		if(original.equals(reverse)) {
			System.out.println("Hooray, palindromes");
		}else {
			System.out.println("u suck");
		}

		// boolean bool = true;
		// for (int i = 0; i < input.length(); i++) {
		// if(input.charAt(i) != input.charAt(input.length()- i -1 )) {
		// bool = false;
		// }
		// }
		// if(bool==true) {
		// System.out.println("The string is a palindrome");
		// }else {
		// System.out.println("The string is not a palindrome.");
		// }
	}
}
