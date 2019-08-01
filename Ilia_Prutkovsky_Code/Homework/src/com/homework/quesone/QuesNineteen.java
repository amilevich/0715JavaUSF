package com.homework.quesone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

// Create an ArrayList and insert integers 1 through 10. Display the ArrayList. 
// 1. Add all the even numbers up and display the result. 
// 2. Add all the odd numbers up and display the result. 
// 3. Remove the prime numbers from the ArrayList and print out the remaining ArrayList.

public class QuesNineteen {
	
	public static void main(String[] args) {
		
		fillArrayList(); // call our method
	}
	
	public static void fillArrayList() {
		ArrayList<Integer> arrL = new ArrayList<>(); // create new ArrayList 
		ArrayList<Integer> arrEven = new ArrayList<>(); // create new ArrayList 
		ArrayList<Integer> arrOdd = new ArrayList<>(); // create new ArrayList 
		
		Scanner scan = new Scanner(System.in); // create a new object for class Scanner
		System.out.print("Input size of ArrayList: ");
		int num = scan.nextInt(); // assign variable num with type integer to digit that was inputed from console
		scan.close(); // close Scanner class if no more input from console
		
		for (int i = 1; i < num; i++) arrL.add(i); // fill out our ArrayList & add every object one by one
		System.out.println("Our ArrayList is: " + arrL); // print out our ArrayList
		
		for (Integer n: arrL) if(n % 2 == 0) arrEven.add(n); // go through our array & check if number is even add to the begin of ArrayList
		for (Integer n: arrL) if(n % 2 != 0) arrEven.add(n); // go through our array & check if number is odd add to the end of ArrayList
		System.out.println("All even up: " + arrEven); // print out our modified ArrayList
		
		for (Integer n: arrEven) if(n % 2 != 0) arrOdd.add(n); // go through our array & check if number is odd add to the begin of ArrayList		
		for (Integer n: arrEven) if(n % 2 == 0) arrOdd.add(n); // go through our array & check if number is even add to the end of ArrayList
		System.out.println("All odd up: " + arrOdd); // print out our modified ArrayList
		
		Iterator<Integer> itr = arrOdd.iterator(); // create iterator object for our ArrayList
        while (itr.hasNext()) // check availability can go to next object of our ArrayList go further
        { 
            int n = (Integer)itr.next(); // assign variable int n to go to next object of our ArrayList
            if (primeCheck(n)) itr.remove(); // check current object of an ArrayList is prime number than remove it
        }
		System.out.println("Our ArrayList without prime numbers: " + arrOdd); // print out our modified ArrayList
		
	}
	
	static boolean primeCheck(int num) { // primeCheck - method for checking number is prime or not	... method was taken from Q9	
		for (int j = 2; j < num; j++) if(num % j == 0) return false; // loop help us to go through & do checking number is not prime return false
		return true; // if yes , return true		
	}
}
