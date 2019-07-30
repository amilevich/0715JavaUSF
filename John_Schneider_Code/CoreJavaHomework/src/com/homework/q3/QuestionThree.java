package com.homework.q3;

public class QuestionThree
{
	/*
	 * Reverse a string without using a temporary variable
	 */
	
	//Prints out a given string in reverse order by printing out each character of the string from the end to beginning
	public static void reverse(String str)
	{
		int length = str.length()-1; //hold the length of the string - 1, as indices of characters span 0 to length-1
		
		//iterate over the string where i will be the index of each character in the string starting from the end
		for(int i=length; i>=0; i--)
		{
			System.out.print(str.charAt(i)); //print out the character in the string at the given index
		}
	}
	
	public static void main(String[] args)
	{
		//call the reverse method with string "hello" to print said string in reverse order
		reverse("hello");
	}
}