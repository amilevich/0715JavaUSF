package com.example.question1;

public class BubbleSort {
	
	// Example from class
	// Main Driver

	public static void main(String[] args) {
		int arr[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		System.out.println("Unsorted array: ");
		printArray(arr);
		bubbleSort(arr);
		System.out.println();
		System.out.println("Sorted array: ");
		printArray(arr);

	}
	
	// Method that does the sorting

	public static void bubbleSort(int arr[]) {

		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++)
				
				// Compares adjacent elements in arr
				if (arr[j] > arr[j + 1]) {
					
					// Swaps if neccessary
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
		}
	}
	
	// Method to print out the arr

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
	}

}
