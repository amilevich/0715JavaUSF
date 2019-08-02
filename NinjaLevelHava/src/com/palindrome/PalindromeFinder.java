package com.palindrome;

import java.util.ArrayList;
import java.util.Scanner;

public class PalindromeFinder {

	//Q8. Write a program that stores the following strings in an ArrayList
	//and saves all the palindromes in another ArrayList.

	//“karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, 
	//“jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
	
	String name;
	
	public PalindromeFinder(String name) {
		//here is my constructor using the name field so I can populate the appropriate arraylist
		super();
		this.name = name;
	}
	public String toString() {
		//I was having trouble pronting out my arraylist until I remembered
		//that I overrided the toString method in my Employee class to solve this problem
		return this.name;
	}

	public static void main(String[] saveThePalindromezzz) {
		//I am going to populate these arraylist using the scanner
		//I will use a do while loop to exit the scanner and print the two arraylist
		ArrayList<PalindromeFinder> palindromes = new ArrayList<PalindromeFinder>();
		ArrayList<PalindromeFinder> nonPalindromes = new ArrayList<PalindromeFinder>();
		
		Scanner input = new Scanner(System.in);
		
		String original,reverse = "";
		
		do {
			System.out.println("Enter a string then press ENTER to add it to the list. \n"
					+ "When you are done, enter the number 0");
			
			original = input.nextLine();
			
			for(int i = original.length()-1; i >= 0; i--) {
				reverse = reverse + original.charAt(i);
			}
			if(original.equals(reverse)) {
				palindromes.add(new PalindromeFinder(original));
				reverse = "";//my problem here was that the "reverse" string never reset 
				//so every palindrome was just added to the next, making it a non-palindrome.
			
			}else {
				nonPalindromes.add(new PalindromeFinder(original));
				reverse = "";
			}
		}while(!original.equals("0"));
		
		System.out.println("Here is your list of Palindromes...");
		for(int i = 0; i < palindromes.size(); i++) {
			System.out.print(palindromes.get(i)+", ");
		}System.out.println("");

		System.out.println("And here is your list of Non-Palindromes...");
		for(int i = 0; i < nonPalindromes.size(); i++) {
			System.out.print(nonPalindromes.get(i)+", ");
		}
		
	}

}
