package com.q9;

import java.util.ArrayList;

public class PrintPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ints = createArrList100();
		printPrimes(ints);
	}
	
	public static ArrayList<Integer> createArrList100(){
		ArrayList<Integer> arrList = new ArrayList<>();
		for(Integer i=1; i<=100;i++) {
			arrList.add(i);
			
		}
		return arrList;
	}
	
	public static void printPrimes(ArrayList<Integer> arrList) {
		int i,two=0, flag=0;
		
		for(Integer n: arrList) {
			flag=0;
			two=n/2;
			if(n!=1) { // for every number that isn't one...
					for(i=2; i<=two;i++) { // 
						if(n%i==0) { // if n is evenly divisible by 2 through n/2
							flag=1; // flag the number to prevent the following if statement from running
							break; // break, grab the next integer from the arraylist
						}
					}
					if(flag==0) { // if the flag was not triggered, the number is prime
						System.out.println((n));
				}
			}
		}
	}
}
			

