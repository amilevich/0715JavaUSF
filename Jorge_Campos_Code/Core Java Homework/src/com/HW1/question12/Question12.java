package com.HW1.question12;

public class Question12 {
	//Write a program to store numbers from 1 to 100 in an array.
	//Print out all the even numbers from the array. 
	//Use the enhanced FOR loop for printing out the numbers

	public static void main(String[] args) {
		int arr[] = new int[100];		//populating array with values
		for (int i = 1; i <= 100; i++)
			arr[i-1] = i;

		System.out.println("Even numbers: ");
		for(int i: arr) { 			// enhanced for loop to check all elements one by one
			if (i%2 == 0)			// if they are an even integer it is printed to console
				System.out.print(i + " ");
		}
	}
}
