package com.homework;

public class Problem01 {
	
	public static void main(String[] args) {
		//creates array
		int intArray[] = {1,0,5,6,3,2,3,7,9,8,4};
		
		//System.out.println(intArray.length);
		
		//sort function
		SORT(intArray);
		
		
		//Prints Array
		for ( int i =0; i < intArray.length ; i++) {
			System.out.println(intArray[i]);
		}
	}
	
	
	static void SORT(int intArray[]) {
		
		//A simple bubble sort
		for ( int i = 0; i < intArray.length -1; i++) {
			for ( int j = 0; j < intArray.length - i -1; j++) {
				if (intArray[j] > intArray[j+1 ]) {
					int temp = intArray[j];
					intArray[j] = intArray[j + 1];
					intArray[j + 1] = temp;
					
				}
			}
		}
		
	}
}
