package com.assignment1.q1;

public class BubbleSort {
public static void main(String[] args) {
		
		int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
		printArray(arr);
		System.out.println();
		System.out.println("Sorted Array: ");
		bubbleSort(arr);
	}
	
	public static void bubbleSort(int arr[]) {
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++){
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}	
			System.out.print(arr[i] + " ");
		}
	}
	static void printArray(int arr[]) {
		int n = arr.length;
		for(int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
	}

}

