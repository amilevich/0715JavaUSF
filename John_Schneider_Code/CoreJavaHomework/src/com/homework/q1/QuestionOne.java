package com.homework.q1;

public class QuestionOne
{
	/*
	 * Sort a given array of integers using the bubble sort algorithm
	 */
	
	public static void bubbleSort(int[] arr)
	{
		//Bubble sort works by comparing every element in an array with the one
		//immediately proceeding it, and swapping the two based on ordering requirement.
		//Multiple passes through the array of this comparison and swapping process
		//are completed in order to fully sort the array.
		
		//Nested for loop to compare every element in the array with every other element
		for(int i=0; i<arr.length; i++) //Outer for loop steps through every element in the array starting at index 0
		{
			for(int j=i; j<arr.length-1; j++) //Inner for loop steps through elements in the array spanning from index i to the penultimate element
			{
				//Loop condition stops one element before the last in the array due to 
				//below conditional statement comparing value of current element to one ahead of it
				if(arr[j] > arr[j+1])//If the current element is greater than the one proceeding it...
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp; //... swap the two elements.
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		//Array of integers to be sorted
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		
		//Call to sorting method with the array as an argument
		bubbleSort(arr);
		
		//Print out the sorted array
		for(int i : arr)
			System.out.print(i + " ");
		
	}
}