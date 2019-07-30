package com.homework.question1;

public class BubbleSort {
	
	//Method swap 
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	 static void bubbleSort(int[] arr) {
		 
		 int n  =  arr.length;
		 //Loop to move the array to 
		 for(int i = 0 ; i < n ; i++) {
			 // Loop to go the next elments to be compared
			 for(int j = 1 ; j < n - i; j++) {
				 if(arr[j-1] > arr[j]) {
					 //Call method swap
					 swap(arr, j-1, j);
				 }		 
				 
			 }
		 }
		 
	 }
	 
	 static void printArray(int[] arr) {
		 int n = arr.length;
		 for(int i = 0 ; i < n ; i++) {
			 System.out.print(arr[i] + " ");			 
		 }
		 System.out.print("\n");
	 }

	public static void main(String[] args) {
		
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.print("Origina array " );
		//Call printArray
		printArray(arr);
		//Call bubbleSort method
		bubbleSort(arr);
		System.out.print("Sort array    ");
		//Call printArray
		printArray(arr);

	}

}
