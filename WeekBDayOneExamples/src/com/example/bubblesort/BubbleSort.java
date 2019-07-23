package com.example.bubblesort;

public class BubbleSort {
	
	/*
	 * Bubble Sort is a simple and slow sorting algorithm that
	 * repeatedly performs comparison of adjacent elements and swaps
	 * them if they are in the wrong order.
	 * 
	 * The basic idea of Bubble Sort algorithm can be described
	 * as these steps:
	 * 1)Take two adjacent elements
	 * 2)Compare said elements
	 * 3)If the first is greater than the second, swap them
	 * 
	 * Repeat steps 1-3 until there are no more elements to check.
	 */

	public static void main(String[] args) {
		int arr[] = {34, 64, 25, 12, 22, 11, 90, 27};
		printArray(arr);
		bubbleSort(arr);
		System.out.println("Sorted array: ");
		printArray(arr);
		
	}
	
	public static void bubbleSort(int arr[]) {
//		for(int x = 0; x < arr.length - 1; x++) {
//			for(int y = x + 1; y < arr.length; y++) {
//				if(arr[x] > arr[y]) {
//					int temp = arr[x];
//					arr[x]=arr[y];
//					arr[y]=temp;
//				}
//			}
//		}
		int n = arr.length;
		for(int i = 0; i< n - 1; i++) {
			for(int j = 0; j < n - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]= temp;
				}
			}
		}
	}
	
	static void printArray(int arr[]) {
		int n = arr.length;
		for(int i = 0; i< n; i++) {
			System.out.println(arr[i]);
		}
	}
	

}
