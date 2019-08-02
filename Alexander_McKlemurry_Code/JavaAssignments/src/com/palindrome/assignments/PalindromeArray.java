package com.palindrome.assignments;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class PalindromeArray {  //A Palindrome is a word that is spelled the same way when it is written
	//from left to right or right to left

	
public static ArrayList<String> pal = new ArrayList<String>(); //used (pal) because it made it work right
//from my understanding pal has some relation to pega but I am not very knowledgeable in that area yet
//pal=programming array logic I will do more research at a more convenient date as this interests
//me
	
	public static ArrayList<String> palindromes( ArrayList<String> list ) //String is a group of (chars)
	//so I though it would be useful for the arraylist. char is a primitive data type
	{
		int comparsions,
		    counter;		//counter helps count the number of operations and stops when the set
		//limit has been reached
		
		
		for(String x: list)
		{
			if( x.length() % 2 == 0 ) // s.length because s is the string reference while length is
				//calling upon the size of the array input
			{
				comparsions = x.length() /2;
				counter = 0;
				
				for(int i = 0; i < comparsions; i++)
				{		
					if( x.charAt(i) == x.charAt( x.length() - i - 1) )
						counter++;
					
					if( counter == comparsions ) //both (counter) and (comparisons) are operands so
						//I am using (==) operator to compare the two
						pal.add(x);  //pal- programming array logic. I am using this because it
					//turned out to be very useful for doing arrays
				}
			}
			
			else				//this will be my else part of the loop statement
			{												
				comparsions = (x.length()- 1) / 2;  // one value is equal to another for loop purposes
				counter = 0;		//counter will count the number of iterations
				
				for(int j = 0; j < comparsions; j++) // normal for loop that will increment
				{	
					if( x.charAt(j) ==  x.charAt( x.length() - j - 1)  ) //this if statement is used 
						counter++;//to determine whether some is true and if so increment up
					
					if( counter == comparsions ) //if false then add pal
						pal.add(x);				
				}
			}
			
			
		}
		return pal;		//return the value of the pal keyword
	}
	
	
	
	
	public static void main(String[] args) //main method
	{
		ArrayList<String> arr = new ArrayList<String> //setting up an ArrayList
		( 
			Arrays.asList("karan",
						  "madam",	//list of the required names needed to be used for this assignment
						  "tom",
						  "civic",
						  "radar",
						  "sexes",
						  "jimmy",
						  "kayak",
						  "john",
						  "refer",
						  "billy",
						  "did"
			)
		);
		
		
		try( BufferedWriter out = new BufferedWriter(new FileWriter("src/palindromes.txt")) )
		{		//Buffered writer and file write help the system read form files
			Iterator<String> iter = arr.iterator();	//informs the system to iterate the string
			//Throughout the process
			while( iter.hasNext() )
				out.write( "\""+ iter.next() + "\", " ); //the (\) is an escape character. I used it
			// because it worked out
				
			
		} 
		catch (IOException e) //tells the system to resolve the IOexception that may be cause
		//by the variable e
		{
			e.printStackTrace(); // Since I had so many lines, I decided to use this in order to
			// better keep track of any exceptions caused by my code. StackTrace can be used
			//to trace problems in your code.
		}
		
		
		System.out.println("ArrayList: " + arr);				//Print out statements and conditions
		System.out.println("ArrayList palindromes: " + palindromes(arr) );
		
	}
}
