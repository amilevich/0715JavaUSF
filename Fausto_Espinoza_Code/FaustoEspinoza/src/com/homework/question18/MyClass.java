package com.homework.question18;

public class MyClass {
	
	public static void main(String[] args) {
		ConcreteSubclass csc = new ConcreteSubclass();
		
		System.out.println(csc.checkUpperCase("hello hoW? arE you"));
		System.out.println(csc.lowerCase("hello how( are you"));
		System.out.println(csc.stringToNumber("hello 4 row 2 are 4 you 0"));
	}

}
