package com.HW1.question19;

import java.util.ArrayList;

public class Question19 {

	// Create an ArrayList and insert integers 1 through 10. Display the ArrayList.
	// Add all the even numbers up and display the result. Add all the odd numbers
	// up and display the result. Remove the prime numbers from the ArrayList and
	// print out the remaining ArrayList.
	
	static boolean isPrime(int n) { 	// method to check if integer is prime, returns true if is
		if(n == 1)						// prime, false if it is not
				return false;
		for (int i = 2; i < n; i++) { 	
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<>();
		int even = 0, odd = 0;
		for (int i = 1; i <= 10; i++) { 			// Populating ArrayList with values 1 through 10
			arrList.add(i);
		}
		System.out.println(arrList);

		for (int i = 0; i < arrList.size(); i++) {	// Perform summation of odd and even values
			if (arrList.get(i) % 2 == 0)			//  separately while traversing arrayList
				even += arrList.get(i);
			else
				odd += arrList.get(i);
		}
		System.out.println("Sum of Even: "+ even);
		System.out.println("Sum of Odd: "+ odd);
		
		for(int i = 0; i<arrList.size();i++) {		//Check elements if they are a prime number
			if(isPrime(arrList.get(i))) {			//  and removes all prime elements
				arrList.remove(i);
				i--;
			}
		}
		System.out.println("Prime numbers remove: " + arrList);
	}
}
