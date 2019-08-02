package com.question8.palin;

import java.util.ArrayList;
import java.util.ListIterator;

public class My_Palindrome {

	//Creates arraylist that will be used to store all palindromes.
	
	static ArrayList<String> palindromes = new ArrayList<>();

	public static void main(String[] args) {
		
		//Creates arraylist by adding all string elements to the arraylist.
		
		ArrayList<String> arrList = new ArrayList<>();
		arrList.add("karan");
		arrList.add("madam");
		arrList.add("tom");
		arrList.add("civic");
		arrList.add("radar");
		arrList.add("sexes");
		arrList.add("jimmy");
		arrList.add("kayak");
		arrList.add("john");
		arrList.add("refer");
		arrList.add("billy");
		arrList.add("did");
		
		//creates iterator. Helpful to access the arraylist and sequentially go through all its elements.

		ListIterator<String> iterator = arrList.listIterator();
		
		//Loop that will sequentially go through every single element of the arraylist.
		
		while(iterator.hasNext()) {
			
			//The flip method checks to see if each element is a palindrome or not. 
			
			flip(iterator.next());
			
		}
		System.out.println("Arraylist of all string elements: " + arrList);
		System.out.println("Arraylist of palindromes: " + palindromes);
		

	}
	
	//creating a method that will help determine if an element of the arraylist is a palindrome or not.
	//if a palindrome is found, it will be added to the arraylist created for all identified palindromes.
	
	static void flip(String original) {
		
		String reverse = "";
		
		for(int i = original.length() - 1; i >= 0; i--) {
			
			 reverse = reverse + original.charAt(i);
		}
		
		if(original.equals(reverse)) {
			
			//addsfound palindromes to the palindromes arraylist.
			
			palindromes.add(reverse);
			
		}
	}

}

		
		
		

	


