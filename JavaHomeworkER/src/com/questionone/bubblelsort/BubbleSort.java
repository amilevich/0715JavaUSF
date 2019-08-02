package com.questionone.bubblelsort;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4}; //declare the array
		bubbleSort(arr); //sorting array elements using bubble sort   
		System.out.println("Sorted array is: ");
		printArray(arr); //print it
		
	}
	
	// Since we compare each element with another, we need two for loops
		
	public static void bubbleSort(int arr[]) { 
		int n = arr.length; //length of array
		
		// number of iterations is determined by its length-1;
		for(int i = 0; i< n - 1; i++) { //initiating the counter i and specifying condition; keeps track of what index it's on
			for(int j = 0; j < n - i - 1; j++) {
				if(arr[j] > arr[j+1]) {  //swap the two values if the first is greater than the next
					int temp = arr[j];   //set the first variable to temp variable 
					arr[j] = arr[j+1]; //set the second variable to the first position
					arr[j+1]= temp; //set the temporary variable to the next position
				}
			}
		}
	}
	
	static void printArray(int arr[]) { 
		int n = arr.length; //get array length
		for(int i = 0; i< n; i++) { //iterate through array 
			System.out.print(arr[i] + " "); //print out the array on one line
		}
	}
}	
	


