package com.homeworkcoreJava.q6;

//Answer to Question 6:
//Q6. Write a program to determine if an integer is even without using the modulus operator (%)
//Barton Carson
public class Question6 {

	public static void main(String[] args) {
		
		int a = -5;
		System.out.println(isEven(a));
		
	}
	
	//Program that counts up from 0 or down from 0 (depending on if your integer is positive or negative) and switches between true and false
	//as the number goes from even to odd.
	//Once the counter reaches the number in question, the proper boolean is returned
	public static boolean isEven(int a) {
		
		int i = 0;
		boolean even = true;

		if (a >= 0 ) {
			while (i != a) {
				even = !even;
				i++;
			}
		} else {
			while (i != a) {
				even = !even;
				i--;
			}
		}
		return even;	
	}
}