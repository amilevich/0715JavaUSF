package com.HW1.question11;

import com.HW1.question11part2.*;		//importing class that contain desired variables

public class Question11 {
	// Write a program that would access two float-variables from a 
	// class that exists in another package. Note, you will need to create two 
	// packages to demonstrate the solution

	public static void main(String[] args) {
		float x = Question11part2.a;			// calling variables by class name since they are static
		float y = Question11part2.b;			// and saving to local variable
		
		System.out.println("Variable a: "+ x);	// Outputting to display values
		System.out.println("Variable b: "+ y);

	}

}
