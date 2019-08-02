package com.anotherarray.assignments;

public class MyEvenArray { //This array will store and print out 1 - 100

	
	public static void main(String[] args) {
		  
		
		int numbers[] = new int[100]; // giving the array the total number of integers and creating
		//the size of the array
		  
		
		for(int i=1; i<=100; i++) //a normal for loop that loops through and increments up via i++
			//until the last number has been reached
		{
		numbers[i-1] = i;
		}
		  
		
		for (int num: numbers) {  
		System.out.println(num+" "); //telling the system to print out the incrementing numbers
		//the ("") with a space in gives it a cleaner look
		}
		}
}
