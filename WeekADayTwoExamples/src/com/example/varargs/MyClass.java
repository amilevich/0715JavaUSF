package com.example.varargs;

public class MyClass {

	public static void main(String[] args) {
		fun();
		fun(1,5,8,1,500);
		fun(200);
		
		fun2("Word");
		fun2("Yayyy", 5, 6, 8, 9);
		fun2("Burrito", 3, 1);
	}
	
	/*
	 * varargs - variable-length arguments
	 * a method that takes a variable number of arguments is 
	 * a varargs method
	 */
	
	public static void fun(int ...a) {
		//this syntax tells the compiler that fun() can be called
		//with 0 or more arguments.
		//as a result, a is implicitly declared as an array of ints
		System.out.println("Number of arguments: " + a.length);
	}
	
	public static void fun2(String s, int ...a) {
		//takes in a single string and any number of ints
		System.out.println("String: " + s);
		System.out.println("Number of arguments: " + a.length);
	}
	//there can only be one variable argument in a method
	//it must be the last argument
}
