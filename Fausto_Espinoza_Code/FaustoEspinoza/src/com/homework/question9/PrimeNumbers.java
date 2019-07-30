package com.homework.question9;

import java.util.ArrayList;
import java.util.ListIterator;

public class PrimeNumbers {
	
	
	//This method verify if the number is prime
	
	static ArrayList<Integer> checkPrime(ArrayList<Integer> arr) {
		ArrayList<Integer> primeN = new ArrayList<>();
		
		ListIterator<Integer> iterator = arr.listIterator();
		
		while(iterator.hasNext()) {
			int number = iterator.next();
			boolean flag = false;
			//Verify if the number is prime
			for(int i = 2; i < number; i++ ) {
				if((number % i) == 0) {
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				primeN.add(number);
			}
		}
		
		return primeN;
	}
	
	
	//Print Elements
	static void  printList(ArrayList<Integer> arr) {
		ListIterator<Integer> iterator = arr.listIterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<>(), newArr = new ArrayList<>();
		
		
		for(int i = 1 ; i <= 100 ; i++) {			
			arr.add(i);			
		}
		
		printList(arr);
		newArr = checkPrime(arr);
		printList(newArr);
		

	}

}
