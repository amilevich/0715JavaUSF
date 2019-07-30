package com.homeworkcoreJava.q9;

import java.util.ArrayList;

//Answer to Question 9:
//Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
//Barton Carson
public class Question9 {

	public static void main(String[] args) {

		//Creates arrayList from 1 to 100
		ArrayList<Integer> arrList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			arrList.add(i + 1);
		}
		
		printPrime(arrList);
	}

	public static void printPrime(ArrayList<Integer> arrList) {
		for (int i = 0; i < arrList.size(); i++) {
			
			//Declared Variables
			int flag = 0, a = arrList.get(i), m = a / 2;
			
			//1 is not a prime number, according to google
			if (a == 1) {} else {
				
				//for loop that test if half the number is divisible by the numbers of the loop
				//if the number is not divisible, the number is prime
				for (int j = 2; j <= m; j++) {
					
					if (a % j == 0) {
						flag = 1;
						break;
					}
				}
				//if flag stays 0, the number in question is prime and printed to console
				if (flag == 0) {
					System.out.print(a + " ");
				}
			}
		}
	}
}