package com.homework.q9;

import java.util.ArrayList;

public class QuestionNine
{
	/*
	 * Creates an arraylist with numbers spanning 1-100 and prints out prime numbers from the list
	 */
	
	//Method to check if given number is prime and print it out if so
	public static void printIfPrime(int num)
	{
		//Prime number -> only divisible by 1 and itself
		//loop to check divisibility of given number by every number less than it, besides 1
		//Doesn't check 1 as every number is divisible by 1
		for(int i=2; i<num; i++)
		{
			if(num % i == 0) //If division does not result in a remainder, num is divisible by i
				return; //return and dont print if num is divisible by i as this indicates num is not prime
		}
		
		//if loop completed without returning -> num is not divisible by any number less than it
		//print out num as it is prime
		System.out.println(num);
	}
	
	public static void main(String[] args)
	{
		//ArrayList to hold every number between 1-100
		ArrayList<Integer> nums = new ArrayList<>();
		
		//for loop from 1-100 to fill arraylist with numbers
		for(int i=1;i<=100;i++)
			nums.add(i);
		
		//for-each loop to iterate over every number in the list and calls method to print if it is prime
		for(int i : nums)
			printIfPrime(i);
	}
}