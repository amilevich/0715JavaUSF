package com.homework;

import java.util.ArrayList;

public class Problem19 {
	//Create an ArrayList and insert integers 1 through 10. 
	//Display the ArrayList. 
	//Add all the even numbers up and display the result. 
	//Add all the odd numbers up and display the result. 
	//Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
	public static void main(String[] args) {
		
		//odd and even counter
		int odd = 0;
		int even = 0;
		
		//You are almost done Ruben
		System.out.println("Problem 18!");
		ArrayList<Integer> aList = new ArrayList<Integer>();
		
		for(int i = 0 ; i < 11 ; i++) {
			aList.add(i);
			
		}
		
		
		//show even numbers
		for ( int a : aList) {
			if ( aList.get(a) %2 == 0) {
				even += a;
			}
		}
		System.out.println(even);
		
		for ( int a : aList) {
			if(! ( aList.get(a) % 2 == 0)) {
				//making sure the system works
				System.out.println(aList.get(a));
				odd += a;
			}
		}
		
		System.out.println(odd);
		
		
		
		
		
		
		
	}
}
