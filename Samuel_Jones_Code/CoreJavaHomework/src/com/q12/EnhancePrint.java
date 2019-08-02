package com.q12;

import java.util.ArrayList;

public class EnhancePrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = createArrList100();
		printEvens(arr);
		
	}

	//returns an array of ints
	public static int[] createArrList100(){ 
		int[] arrList = new int[101]; // initialize the 
		for(int i=2; i<101;i++) { // loop through numbers from 2 to 101
			arrList[i]=i; // add the int to the array
			
		}
		return arrList; // return the arraylist
	}
	
	// print the evens using an enhanced for loop
	public static void printEvens(int[] array) {
		
		for(int u: array) { // loop through every int in the array 
			if(u%2==0) { // if the int is evenly divisible by 2
				if (u == 0) { // if the int is 0, skip it
					continue;
				}
				System.out.println(array[u]); // print out each element of array
			}
		}
	}
	
}
