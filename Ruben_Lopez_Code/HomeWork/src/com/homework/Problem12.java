package com.homework;

public class Problem12 {
	//Write a program to store numbers from 1 to 100 in an array. 
	//Print out all the even numbers from the array. 
	//Use the enhanced FOR loop for printing out the numbers.
	
	public static void main(String[] args) {
		
		int[] intArray = new int[101];
		for (int i = 0; i < 101 ; i++) {
			
			intArray[i] = i; 
		}
		
		for ( int a : intArray) {
			//checking if numbers are even
			//calls from the memory address an array
			if (intArray[a] % 2 == 0) {
			System.out.println(a);
			}
		}


	}
}
