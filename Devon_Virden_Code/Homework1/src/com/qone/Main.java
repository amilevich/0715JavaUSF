package com.qone;
//Q1: bubblesort

public class Main {

	public static void main(String[] args) {
		int arr[]= {1,0,5,6,3,2,3,7,9,8,4};
		System.out.print("Original:\t[");
		for(int i:arr) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println("]\n");
		//sort it
		bubbleSort(arr,0);
		//print them out
		System.out.print("Sorted:\t\t[");
		for(int i:arr) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println("]");	
	}
	
	//creating a recursive method to not do exactly what we did in class
	static int[] bubbleSort(int[] arr, int i) {
		// i is a counter
		if((i+1)==arr.length) {
			//break back up here
			return arr;
		}
		else {
			for(int x=0;x<arr.length-i-1;x++) {
				//checking adjacent
				if(arr[x]<arr[x+1]) {
					//swapping
					int temp = arr[x+1];
					arr[x+1]= arr[x];
					arr[x]=temp;
				}
			}
			//and looping back in
			arr=bubbleSort(arr, i+1);
			return arr;
		}
	}

}
