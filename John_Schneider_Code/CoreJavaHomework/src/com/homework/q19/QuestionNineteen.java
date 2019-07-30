package com.homework.q19;

import java.util.ArrayList;

public class QuestionNineteen
{
	/*
	 * Perform operations on integers in an arraylist
	 */
	
	//Method to check if the given number is prime
	public static boolean isPrime(int n)
	{
		//Prime if only divisible by 1 and itself
		//Check divisibility of all numbers less than n and greater than 1
		for(int i=2; i<n; i++)
			if(n%i==0) //If n is divisible by given number i
				return false; //n is not prime so return false
		
		return true; //If loop has completed without finding n to be not prime, n is prime so return true
	}
	
	public static void main(String[] args)
	{
		//Create a new arraylist to hold integers from 1 to 10
		ArrayList<Integer> ints = new ArrayList<>();
		
		//add numbers from 1 to 10 into the arraylist
		for(int i=1;i<=10;i++)
			ints.add(i);
		
		//variable to hold the sum of all even numbers in the arraylist
		int evenSum = 0;
		//variable to hold the sum of all odd numbers in the arraylist
		int oddSum = 0;
		
		//for-each loop to iterate over ints in arraylist
		for(int i : ints) {
			if(i%2==0) //if the current int is an even number
				evenSum+=i; //add it to the even sum
			else //if the current number is not even (and is therefore odd)
				oddSum+=i; //add it to the odd sum
		}
		
		//Print out the sums of the even and the odd numbers in the arraylist
		System.out.println("Sum of even numbers: " + evenSum);
		System.out.println("Sum of odd numbers: " + oddSum);
		
		//Iterate over all elements in the arraylist
		for(int i=0; i<ints.size(); i++)
			if(isPrime(ints.get(i))) //check if element at current index is prime
				ints.remove(i); //if element is prime, remove from arraylist
		
		//Print out the arraylist with the prime numbers removed
		System.out.println("ArrayList without prime numbers: " + ints);
	}
}