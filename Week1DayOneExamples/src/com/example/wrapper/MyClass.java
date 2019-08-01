package com.example.wrapper;

import java.util.ArrayList;

public class MyClass {
	
	/*
	 * A wrapper is a class that encapsulates primitive data types.
	 */

	public static void main(String[] args) {
		
		Integer i = new Integer(2);
		System.out.println(i);
		
		//boxing: primitive to wrapper
		//unboxing: wrapper to primitive
		
		Float f = 998f; //boxing
		float tempFloat = f; //unboxing
		
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		// intArray of type Integer -> holds only Integers
		// "of type" = <>
		// Integer -> Wrapper Class that encapsulates int
		ArrayList<Object> objArray = new ArrayList<Object>();
		
		
	}

}
