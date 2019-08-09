package com.q1;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4}; // create array unsorted
		
		bubbleSort(arr);
		System.out.println("Ascending Order bubbleSort: ");
		printArray(arr);
	}
	public static void printArray(int[] array) { // method for printing an array
		for(int i = 0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
	public static void bubbleSort(int[] array) {
		
		for(int i =0; i<array.length; i++) { // for each element in the array
			for(int j = 0; j<array.length-1; j++) { // loop through every element of the array
				if(array[j]>array[j+1]) { // for every element that is out of order
					int temp = array[j]; //swap the element with its neighbor
					array[j] = array[j+1]; 
					array[j+1] = temp; 
					// repeat this process until the array is sorted.
				}
			}
		}
	}

}
