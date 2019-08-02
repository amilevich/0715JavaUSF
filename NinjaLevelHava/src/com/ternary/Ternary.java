package com.ternary;

public class Ternary {
	//Q10. Find the minimum of two numbers using ternary operators.
		public static float x = 10;
		public static float y = 25;
		
	
	public static void main(String[] args) {
		 
		 
		float minValue = (x < y) ? x : y;
		//I guess a ternary statement is like an if else statement
		//if x is less than y, minValue = x,
		//else, minValue = y
		
		System.out.println(minValue);

	}

}
