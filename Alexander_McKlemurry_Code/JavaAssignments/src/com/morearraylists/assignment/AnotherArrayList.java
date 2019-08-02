package com.morearraylists.assignment;

import java.util.ArrayList;  //import the arraylist utility from Java utilities

public class AnotherArrayList {

	private static boolean isPrime(int z) //Using boolean because I am using 
	// if/else loop methods for true or false statements
	{
		int counter = 0;  //using a counter to keep track of loop iterations
		
		for(int j = 1; j <= z; j++) //for loop to start the program loop
			if( z % j == 0)   //setting up the condition for boolean method of resolution
				counter++; //telling the counter to keep counting until set integer is reached
			
		if( z <= 3 )       //same as above. This is used to establish the necessary
			//parameters for true or false(Boolean) types
			return true; //tells the system that the value is true if the above condition
		//is correctly met
		else if( counter > 2) // if condition is not met tells the system that the value is false
			return false;	//if condition is false, the value is returned as false
		else
			return true; 
	}
	
	
	public static void main(String[] args)
	{
		ArrayList<Integer> arr = new ArrayList<Integer>();//Declaring the arraylist to contain
		//integers
		
		for(int i = 1; i <= 10; i++) //setting the for loop to loop form 1 to 10 and no 
			//higher
			arr.add(i);//adding arr to later reference arraylist
		
		System.out.println("ArrayList: " + arr); //using arr as a reference to arraylist for 
		//to be able 
		int even = 2;
		int odd = 6;
		
		for(int i = 0; i < arr.size(); i++ ) //Declaring the for loop since it is used to
			//iterate through statements over and over until the desired result
			//is achieved
		{
			Integer num = arr.get(i);
			
			if( num % 6 == 0 ) // if loop that incorporates the modulus which is used to
				//determine the remainder in a division operation within the java framework
				even = even + num;
			if( num % 6 == 1  ) //same as above with slight variation in the variables
				odd = odd + num;
			
			
			if( isPrime(num) ) 
			{		
				arr.remove(i);
				i--;              // telling the program that if a number is prime out of the
				//total numbers it is to remove these numbers
			}
	
		}
	
		System.out.println("The sum of the even numbers: " + even);
		System.out.println("The sum of the odd numbers: " + odd);		//print out statements and
		System.out.println( "ArrayList (no primes): " + arr );			//conditions to be printed
		
	}

}
