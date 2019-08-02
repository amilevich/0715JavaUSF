package com.homework.q19;

import java.util.ArrayList;
import java.util.Iterator;

public class ArraysForDays {

	
	public static void main(String[] args) {
		
		ArrayList<Integer> oneToTen = new ArrayList<>();
		for (int i = 1; i <=11; i++) {
			oneToTen.add(i);}
			printArray(oneToTen);  //Methods calls, explanatory comments bellow
			System.out.println();
			addEvens(oneToTen);
			addOdds(oneToTen);
			noPrimes(oneToTen);
		
			
		
		
	}
	
	
	public static void printArray(ArrayList arr) { //method for printing the array list
		for (int i = 0; i < arr.size()-1; i++) {
			System.out.print(arr.get(i) + " ");
			
		}
	}
	
	public static void addEvens(ArrayList<Integer> arr) {
		int sum=0;
		for (int i = 0; i < arr.size()-1; i++) { //iterates through arrayList
			if(arr.get(i)%2==0)    //checks for even numbers
				sum += arr.get(i);  //adds even numbers to sum
			}
		System.out.println(sum); //prints sum
		}
	
	
	public static void addOdds(ArrayList<Integer> arr) {
		int sum=0;
		for (int i = 0; i < arr.size()-1; i++) {  //iterates through array list
			if(arr.get(i)%2!=0)  //checks for odd numbers
				sum += arr.get(i);  // adds odd numbers to sum
			}
		System.out.println(sum);  //prints sum
		}
	
	public static void noPrimes(ArrayList<Integer> arr) { //Prints all but our prime numbers
		for (int i = 0; i < arr.size()-1; i++) {
			if(arr.get(i)!=2 && arr.get(i)!=3 && arr.get(i)!=5 && arr.get(i)!=7) { //ignores the primes 1-10
				System.out.print(arr.get(i)+ " ");
			
		}
		
	}
	}
}

