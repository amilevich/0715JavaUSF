package com.homework.question8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class SortArrayList {
	
	//Checking if original String is equal reverse
	static boolean validatepalindromes(String org) {
		String reverse = new String();
		for(int i = org.length() - 1 ; i >= 0; i--) {
			reverse += org.charAt(i);
		}
		
		if(reverse.equals(org)) {
			return true;
		}
		return false;
	}
	
	//main method for palindromes
	static ArrayList<String> palindromes(ArrayList<String> arr){
		ArrayList<String> pdm = new ArrayList<>();
		//Return the elements
		ListIterator<String> iteractor = arr.listIterator();
		// Acces the Elements in ArrayList
		while(iteractor.hasNext()) {
			String original = iteractor.next();
			if(validatepalindromes(original)) {
				pdm.add(original);
			}			
		}		
		
		return pdm;
	}
	
	//Print elements
	
	static void printElement(ArrayList<String> arr) {
		ListIterator<String> iteractor = arr.listIterator();
		while(iteractor.hasNext()) {
			System.out.print(iteractor.next() + " ");
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		
		ArrayList<String> arr = new ArrayList<>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"));
		ArrayList<String> newArr = new ArrayList<>();
		printElement(arr);
		newArr = palindromes(arr);
		printElement(newArr);
		

	}

}
