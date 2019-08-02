package com.example.Assignments;

public class BubbleSort {

	public static void main(String[] args) { //main method. no need to comment at this 
		//point in the program
		int []array = {1,0,5,6,3,2,3,7,9,8,4}; //array of numbers in the question
		
		bubbleSort(array); //This comment is telling the JVM that the array needs to be
		//bubblesorted
		printArray(array); // this tells the JVM that the bubblesorted array needs
		// to be printed
	}
		public static int[] bubbleSort(int[] Z) { //int Z gives the bubblesort a reference integer
			// value of z
			for(int i = 0;  i< Z.length -1; i++) {
				for(int b = 0; b< Z.length -1-i; b++) {
					if(Z[b] > Z[b + 1]) {
													
					
						int temp = Z[b];
						Z[b] = Z[b + 1];
						Z[b + 1] = temp;}
					
					
				}
			}
			return Z; //return the value of Z(ie bubblesort array)
		}
		public static void printArray(int[] Z) {//public makes it accessible from 
			//anywhere. static makes it part of the class, and void is simply stating 
			//there is no return value
			for(int i = 0; i<Z.length; i++) { //i=0 tells the jvm this is the starting 
				//point for the array of numbers while dot length is serving as the
				// variable that
				System.out.print(Z[i] + " "); //syso prints out the array based on
				// values and integers.
				
			}
		}
}
