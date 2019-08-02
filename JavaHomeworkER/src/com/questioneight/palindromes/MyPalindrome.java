package com.questioneight.palindromes;
import java.util.ArrayList;

public class MyPalindrome {
	
	public static void main(String[] args) {
		ArrayList<String> originalList = new ArrayList<String>();
        ArrayList<String> listPalindromes = new ArrayList<String>();
        ArrayList<String> noPalindromes = new ArrayList<String>();
        originalList.add("karan");
        originalList.add("madam");
        originalList.add("tom");
        originalList.add("civic");
        originalList.add("radar");
        originalList.add("sexes");
        originalList.add("jimmy");
        originalList.add("kayak");
        originalList.add("john");
        originalList.add("refer");
        originalList.add("billy");
        originalList.add("did");
	

        for (String palin: originalList) {   
        	
        	//boolean to check if it is a palindrome
	        boolean palindrome = isPalindrome(palin);
       	            
	           //if it is a palindrome
	           if(palindrome)
	           {
	               //adds the palindrome word to the listPalindrome Arraylist
	               listPalindromes.add(palin);
	           }
	           else{
	               //adds the non-palindromes to the noPalindromes ArrayList 
	               noPalindromes.add(palin);
	           }
	        }
	        //print out the list to the console
	        System.out.println("Original List: ");
	        System.out.println(originalList);

	        System.out.println("Palindrome list: ");
	        System.out.print(listPalindromes);

	    }


	    public static boolean isPalindrome(String value) {
	        if (value == null || value.isEmpty())
	            return false;

	        // this take the string passed it reverses it and compares if its equal to itself
	        //it returns a boolean
	        return new StringBuilder(value).reverse().toString().equals(value);
	    }


	}


