package com.example.polymorphism;

public class MainDriver {
	
	/*
	 * Polymorphism
	 * 
	 * The implementation of polymorphism in java is overriding and
	 * overloading
	 * 
	 * Overloading occurs when two or more methods in one class
	 * have the same method name but different parameters.
	 * 
	 * Overriding means having two methods with the same method
	 * name and parameters (i.e., same method signature) where one
	 * method is in the parent class and one is in the child class.
	 * You override the parent class's method in the child class to 
	 * provide a specific implementation.
	 * 
	 * Overriding - runtime polymorphism
	 * Overloading - compile time polymorphism
	 */
	
	public static void main(String[] beardedLady) {
		
		//If a Parent type reference refers to a Parent
		//object, then Parent's show is called
		Parent obj1 = new Parent();
		obj1.show();
		
		//If a Parent type reference refers to a Child
		//object, then Child's show is called
		//this is called RUNTIME POLYMORPHISM
		Parent obj2 = new Child();
		obj2.show();
		
		Child obj3 = new Child();
		obj3.show();
		
		Parent obj4 = new GrandChild();
		obj4.show();
	}

}
