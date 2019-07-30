package com.homeworkcoreJava.q19;

import java.util.ArrayList;

//Answers to Question 19:
//Q19. Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all the even numbers up and display the result. Add all the odd numbers up and display the result. Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
//Barton Carson
public class Question19 {
	
	static int even = 0, odd = 0;
	public static void main(String[] args) {
		
		addEvenOdd();
		
	}
	
	public static void addEvenOdd() {
		
		ArrayList<Integer> arrList = new ArrayList<>();
		
		//For loop to add up even and odd sums
		for(int i = 0; i < 10; i++) {
			arrList.add(i + 1);
			System.out.print(arrList.get(i) + " ");
			if (i % 2 == 0) {
				even = even + arrList.get(i);
			} else {odd = odd + arrList.get(i);}
		}
		
		//Sums printed
		System.out.println("\n" + even + "\n" + odd);
		
		//Prime numbers removed and remaining arrayList printed
		arrList.remove(1);
		arrList.remove(1);
		arrList.remove(2);
		arrList.remove(3);
		for(int i = 0; i < arrList.size(); i++) {
			System.out.print(arrList.get(i) + " ");
		}	
	}
}