package com.homework.quesone;

// Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4

public class QuesOne {

	public static void main(String[] args) {
		
		int arr[] = {1,0,5,6,3,2,3,7,9,8,4}; // source array for sorting
		System.out.print("Original array: "); // print out the original array
		printOut(arr); // call the print method
		
		System.out.print("\nSorted array:   "); // print out the sorted array
		bubbleSort(arr); // call the sort method
		printOut(arr); // call the print method
	}
	
	public static void bubbleSort(int arr[]) { // Create a method for sorting array "arr"
		for (int i = 0; i < arr.length - 1; i++) { // show us which element is point of start  
			for (int j = 0; j < arr.length - i - 1; j++) { // compare neighbor elements
				if (arr[j] > arr[j + 1]) { // check if current element more then previous one
					int temp = arr[j]; // use temporary variable to assign current element 
					arr[j] = arr[j + 1]; // assign next element to previous one
					arr[j + 1] = temp;	// next to temporary variable									
				}
			}			
		}	
	}
	
	public static void printOut(int arr[]) { // Method of printing out all elements of array 
		for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " "); // go through all array and print it out one by one
	}
}
