package com.examples.constructors;

public class MyClass {
	
	/*
	 * constructor - is a block of code that instantiates a newly created
	 * object.
	 * NOT a method because it doesn't have a return type and 
	 * cannot be overridden.
	 * cannot be abstract, static or final
	 * must be named as the name of the class it belongs to
	 */
	
	MyClass(){
	}
	
	/*
	 * There are 3 types of constructors:
	 * 
	 * default - if no constructor is explicitly provided, the JVM
	 * provides you with a no-argument constructor by default.
	 * no-arg - constructor with no arguments/parameters. the signature
	 * of this no arg constructor is the same as default one, but
	 * the body can have any code unlike default constructors
	 * parameterized - constructor with arguments(or parameters)
	 */
	
	public static void main(String[] args) {
		
		MyClass obj = new MyClass();
		//the new keyword creates the object of class MyClass
		//and invokes the constructor to instantiate this newly
		//created object.
		
		Pet obj1 = new Pet("Jack", "The Spider");
		Pet obj2 = new Pet("Jill", "The Badger", 4);
		Pet obj3 = new Pet("Emily", 0);
		obj1.info();
		obj2.info();
		
	}

}
