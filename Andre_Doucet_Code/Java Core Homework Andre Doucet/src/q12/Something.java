//Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. 

//Use the enhanced FOR loop for printing out the numbers.

package q12;

import java.util.ArrayList;
import java.util.Collections;

public class Something {
	
	
	public static void main(String[] args) {
		// an Array is created, that contains the numbers 1 through 100
		
		int[] anArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};
		ArrayList<Integer>evenList = new ArrayList<Integer>(); 
//		 
//		//this figures out what is even and adds it to the evenList ArrayList
		//for(int i=0;i<anArray.length;i++){ 
		for(int b: anArray) {
			if(b%2==0){ 
			evenList.add(b); 
			}
			} 
			Collections.sort(evenList); 
//			//this prints the evenList
			for(int even : evenList) 
			System.out.print(even + " "); 
		
		
		
		
			
	}

}
