package QT8;

import java.util.ArrayList;
import java.util.List;

import QT7.Employees;

/*
 * Write a program that stores the following strings in an ArrayList
 * and saves all the palindromes in another ArrayList.
 * “karan”, “madam”, ”tom”, “civic”, “radar”, 
 * “sexes”, “jimmy”, “kayak”, “john”,  
 * “refer”, “billy”, “did”
 */
public class Qt8 {

	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
		
		ArrayList<String> myPalindromes = new ArrayList<String>();
		
		ArrayList<String> noPalindromes = new ArrayList<String>();

		strList.add("did");
		strList.add("refer");
		strList.add("john");
		strList.add("kayak");
		strList.add("jimmy");
		strList.add("sexes");
		strList.add("radar");
		strList.add("civic");
		strList.add("tom");
		strList.add("madam");
		strList.add("karan");

		for (String palin : strList) {

			// boolean to check if it is a palindrome

			boolean palindrome = isPalindrome(palin);

			// if it is a palindrome

			if (palindrome) {
				// adds the palindrome word to the palindrome Arraylist
				myPalindromes.add(palin);
			} else {
				// adds the non palindrome to the NonPalindrome ArrayList
				noPalindromes.add(palin);
			}
		}

		// print out the list to the console

		System.out.println("OriginalList: ");

		System.out.println(strList);

		System.out.println("Palindromelist: ");

		System.out.print(myPalindromes);
	}

	public static boolean isPalindrome(String value) {
		if (value == null || value.isEmpty())
			return false;
		// this take the string passed it reverses it and compares if its equal to
		// itself

		// it returns a boolean

		return new StringBuilder(value).reverse().toString().equals(value);

	}

}
