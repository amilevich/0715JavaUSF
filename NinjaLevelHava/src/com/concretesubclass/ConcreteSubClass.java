package com.concretesubclass;

/*
 * Q18. Write a program having a concrete subclass that inherits three abstract methods
 *  from a superclass.  Provide the following three implementations in the subclass
 *   corresponding to the abstract methods in the superclass: 

1.  Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending
if any are found.
2.  Convert all of the lower case characters to uppercase in the input string, and return 
the result. 
3.  Convert the input string to integer and add 10, output the result to the console.

 */

public class ConcreteSubClass extends MyAbstractClass{
	
	public static void main(String[] args) {
		ConcreteSubClass obj = new ConcreteSubClass();
		System.out.println(obj.uppercaseCheck("Hello"));
		System.out.println(obj.lower2Upper("woohooo"));
		System.out.println(obj.string2Int("100"));

	}

	@Override
	public boolean uppercaseCheck(String x) {
		for(int i=0; i<x.length(); i++){
			char c = x.charAt(i);
			if(c >= 97 && c <= 122) {
				return true;
			}
		}return false;
	}

	@Override
	public String lower2Upper(String x) {
		
		String upperCase = x.toUpperCase();
		return upperCase;
	}

	@Override
	public int string2Int(String x) {
		String oldString = x;
		int newInt = Integer.parseInt(oldString);
		
		return newInt;
	}
}

abstract class MyAbstractClass{
	public abstract boolean uppercaseCheck(String x);
	public abstract String lower2Upper(String x);
	public abstract int string2Int(String x);
}
