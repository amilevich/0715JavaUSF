package com.homework.q5;

public class QuestionFive
{
	/*
	 * Generate substring of given string and given upper bound
	 */
	
	static int c = 0; //class owned counter variable for use in dividing substring
	
	//Recursive method to return substring of given string and index of upper bound
	public static String substring(String str, int idx)
	{
		return idx < 1 ? "" : str.charAt(c++) + substring(str, idx-1);
		//Ternary operator including base case and recursive call to build substring
		//Base case is to return an empty string for concatenation when index of character is below lower bound of string
		//Recursive call concatenates characters of the string at given counter index beginning at start of string
		//Call of substring("Coffee", 3) yields:
		// C + substring("Coffee", 2) ->
		// C + o + substring("Coffee", 1) ->
		// C + o + f + substring("Coffee", 0) ->
		// C + o + f + "" = Cof
	}
	
	public static void main(String[] args)
	{
		//Call to print out substring of "Coffee" including first 3 characters
		System.out.println(substring("Coffee", 3));
	}
}