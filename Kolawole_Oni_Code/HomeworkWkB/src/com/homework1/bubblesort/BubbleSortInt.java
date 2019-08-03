package com.homework1.bubblesort;

public class BubbleSortInt {
	
	public static void main(String[] args) {
	//Demonstrate a bubblesort for integer arrays 1,0,5,6,3,2,3,7,9,8,4
	//Declare the array to be used s
	int arr [] = {1, 0, 5, 6, 3, 3, 2, 3, 7, 8, 9, 4};
	
	// Declare the method usage
	bubblesort(arr);
	printArray(arr);

	System.out.println("Sorted Array ");
	
}

public static void bubblesort (int arr []) {
	
	for (int x = 0; x < arr.length -1; x++) {
		for(int y = 0; y<arr.length -x -1 ; y++) {
			if( arr[x]> arr[y]) {
				int temp = arr[x];
				arr[x]= arr[y];
				arr[y]=temp; 
	
			}	
		}
	}
		
}

static void printArray(int arr[]) {
int n = arr.length;
for(int i=0; i<n; i++) {
	System.out.println(arr[i]);
}}
}

	
