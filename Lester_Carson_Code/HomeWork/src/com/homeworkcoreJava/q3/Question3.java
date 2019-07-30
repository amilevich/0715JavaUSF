package com.homeworkcoreJava.q3;

//Answer to Question 3:
//Q3. Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
//Barton Carson
public class Question3 {

	public static void main(String[] args) {

		String str = "The Cow Jumped Over the Moon";
		int amt = str.length();
		System.out.println(str);
		ReverseString(str, amt);
	}

	static void ReverseString(String str, int amt) {

		// uses Recursion and an if statement to print out the string in reverse order
		if (amt > 0) {
			System.out.print(str.charAt(amt - 1));
			ReverseString(str, amt - 1);
		}
	}
}