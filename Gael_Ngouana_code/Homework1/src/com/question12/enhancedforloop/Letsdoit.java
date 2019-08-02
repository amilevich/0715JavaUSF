package com.question12.enhancedforloop;

public class Letsdoit {

	public static void main(String[] args) {
		
		//creates an array of size 100
		int[] arr  = new int[100];
		
		//for loop to populate the array with numbers from 1 to 100.
		for(int i = 0; i < 100; i++) {
			
			arr[i] = i+1;
		} 
		
		System.out.println("The even numbers are:");
		
		//enhanced for loop to traverse each element in the array.
		for(int myValue : arr) {
			
			if (myValue % 2 == 0) {
				
				//System.out.println("The even numbers are:");
				
				System.out.print(myValue + " ");
			}
		}
		

	}

}
