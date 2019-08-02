package com.question1.bubblesort;

public class MyBubbleSort {

	static // Declaring variables

	int[] myArr = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
	
	public static void BubbleSort(int[] myArr) {
		// x= myArr[i];
		// y= myArr[j];

		// goes through the array and compare two adjacent numbers at a time from left
		// to right

		for(int i = 0; i< myArr.length - 1; i++) {
			
			for(int j = i + 1; j< myArr.length; j++) {
					
				if (myArr[j] < myArr[i]) {
					// Swaps elements
					int temp = myArr[i];
					myArr[i]= myArr[j];
					myArr[j]= temp;

				}

			}
		}
	}

	public static void main(String[] args) {
		
//Method to sort the array
		BubbleSort(myArr);
		for (int j = 0; j < myArr.length; j++) {

			System.out.print(myArr[j]);
		}

	}

}
