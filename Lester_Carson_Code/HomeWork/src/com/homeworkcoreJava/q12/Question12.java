package com.homeworkcoreJava.q12;


//Answer to Question 12:
//Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
//Barton Carson
public class Question12 {

	public static void main(String[] args) {
		
		printEvenNumbers();
		
	}
	
	public static void printEvenNumbers() {
		
		int[] arr = new int[100];
		
		//Builds Array
		for (int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		
		//Prints out even numbers
		for (int i : arr) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}	
		}	
	}
}