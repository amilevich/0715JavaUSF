package com.arraylist.assignments;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyArray {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		int i;
		  
		// storing from 1 to 100 
		for(i=0; i<=100; i++)
		list.add(i);		//letting the system know that it will be listed
		  
		for(int num: list)
		{
		
		
		for(i=2; i<num; i++) //This tells the system to print out prime numbers with. It will not work
			//correctly without adding the 2 as a starting point
		{
		if(num%i == 0)  //if number divisible by even then it is to stop its loop thus the reason
		break;			// for the break keyword
		}
		  
		
		if(i==num)	//tells the system to start a loop with i serving as its starting line and
			//(==) is to be compared to the "num" . this allows the system to compare the two
		System.out.print(num+" "); //The quotation serves to provide space within the output
		//not really necessary but it does make it look better
		}
		}
}

	