package com.homework.q18;

public class QuestionEighteen
{
	/*
	 * Implement abstract class with given methods
	 */
	
	public static void main(String[] args)
	{
		//Create an instance of the concrete implementation of the abstract class
		ConcClass classy = new ConcClass();
		
		//Define two strings one without any uppercase letters and one with an uppercase letter
		String noUpper = "hello";
		String hasUpper = "hellO";
		
		//Print out the string and if it has any uppercase letters as per ConcClass's hasUpperCase() method
		System.out.println("Does String: " + noUpper + " have an uppercase character? " + classy.hasUppercase(noUpper));
		System.out.println("Does String: " + hasUpper + " have an uppercase character? " + classy.hasUppercase(hasUpper));
		
		//Print out lowercase string before and after being converted to uppercase as per ConClass's convertToUppercase() method
		System.out.println("Before: " + noUpper + " After: " + classy.convertToUppercase(noUpper));
		
		//String that is a number to be used in ConcClass's addTen() method
		String num = "101";
		
		//Converts num string to integer, adds 10, and prints result
		classy.addTen(num);
	}
}

abstract class AbsClass
{
	/*
	 * Abstract class laying out given methods to be implemented
	 */
	
	abstract boolean hasUppercase(String str);
	abstract String convertToUppercase(String str);
	abstract void addTen(String str);
}

class ConcClass extends AbsClass
{
	/*
	 * Concrete implementation of abstract class
	 */
	
	@Override
	boolean hasUppercase(String str) {
		//Iterate over all characters in the given string
		for(int i=0; i<str.length(); i++)
			if(Character.isUpperCase(str.charAt(i))) //Check if the character at current index is uppercase or not
				return true; //If character is uppercase, given string has an uppercase letter so return true
		
		return false; //If loop completes without finding an uppercase letter, there are none so return false
	}

	@Override
	String convertToUppercase(String str) {
		//Utilize string method to convert characters in given string to uppercase
		return str.toUpperCase();
	}

	@Override
	void addTen(String str) {
		//Utilize Integer method to parse a given string into an integer
		int toInt = Integer.parseInt(str);
		//Add 10 to the string as an integer and print out the result
		System.out.println(toInt + 10);
	}
	
}