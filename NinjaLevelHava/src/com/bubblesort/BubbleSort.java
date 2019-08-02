package com.bubblesort;

//Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4

		/*
		 * TO DO LIST:
		 * 1. bubble sort method
		 * 2. print method
		 * 3. create an object to call methods in the mane
		 */

public class BubbleSort {
	
	 void bubbleSort(int[] x) {
		for(int i = 0; i < x.length-1; i++) {
			for(int j = 0; j< x.length-1; j++) {
				if(x[j] > x[j+1]) {
					int temp = x[j];
					x[j] = x[j+1];
					x[j+1] = temp;
				}
			}
		}
	}
	 void bubblePrint(int[] y) {
		for(int i = 0; i < y.length; i++) {
			System.out.print(y[i] + " ");
		}System.out.println("\n^^^^Bubble Sorted^^^^");
	}

	public static void main(String[] args) {
		
		int wubble[] = {1,0,5,6,3,2,3,7,9,8,4}; 
		
		BubbleSort bubbleYum = new BubbleSort();
		
		bubbleYum.bubbleSort(wubble);
		bubbleYum.bubblePrint(wubble);
	}

}
