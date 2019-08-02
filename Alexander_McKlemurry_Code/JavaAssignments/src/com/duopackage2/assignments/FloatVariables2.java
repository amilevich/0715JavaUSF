package com.duopackage2.assignments;

import com.duopackage.assignments.FloatVariables;

public class FloatVariables2 {

	public static void main(String[] args) {		//main method
		
		FloatVariables obj = new FloatVariables(); //Naming the first package within the second 
			//package
		
		System.out.println("Accessing first float variable as " + obj.satA1()); // (+obj.) serves as
		// the references of what the system will be printing out.
		System.out.println("Accessing second float variable as " + obj.getB1());
	}

}
