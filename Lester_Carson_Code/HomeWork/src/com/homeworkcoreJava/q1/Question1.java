package com.homeworkcoreJava.q1;


//Answer to Question 1:
//Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
//Barton Carson
public class Question1 {

	public static void main(String[] args) {
		
		//integer array and functions used
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		bubbleSort(arr);
		printArray(arr);
	}
	
	//Sorts the integer array
	public static void bubbleSort(int[] arr) {
		
		//Nested for loop designed to compare each element with the one next to it\
		//If j is less than i, they are switched in the array
		//Repeats until the array is sorted
		for(int i = 0; i < arr.length; i++) {
			for(int j = i; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}	
	}
	
	//Prints out the integer array
	static void printArray(int arr[]) {
		for(int k = 0; k < arr.length; k++) {
			System.out.print(arr[k] + " ");
		}
	}
}