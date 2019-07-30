package com.HW1.question1;

public class Questions1 {

	public static void main(String[] args) {
		int arr[] = {1,0,5,6,3,2,3,7,9,8,4};		//predetermined array
		bubbleSort(arr);							//perform bubble sort
		printArray(arr);		
	}
	
	static void bubbleSort(int[] arr) {				//assuming that sort is smallest to largest
		for(int x = 0; x < arr.length-1; x++) {		// perform comparison and if needed call swap
			for(int y = 0; y < arr.length-x-1; y++) {
				if(arr[y]>arr[y+1]) {
					swap(arr,y);				
				}
			}
		}
	}
	
	public static void printArray(int arr[]) {		//method to display array
		int n = arr.length;
		for(int i = 0; i<n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void swap(int arr[], int y) {	//performing swap of array elements
		int temp = arr[y];
		arr[y] = arr[y+1];
		arr[y+1] = temp;
	}

}
