package com.example.methods;

public class MyClass {
	
	public static void main(String[] args) {
		MyClass objectOne = new MyClass();
		objectOne.methodOne();
		objectOne.methodTwo("Hello", "World, yo");
		methodThree();
	}
	
	public void methodOne() {
		System.out.println("methodOne() called");
	}
	
	public void methodTwo(String s, String t) {
		System.out.println("methodTwo(String s, String t) called with "
				+ "arguments: " + s + " " + t);		
	}
	
	public static void methodThree() {
		/*
		 * static - can be applied to methods, variables, blocks,
		 * nested classes
		 * when a member is declared static, there is only one copy
		 * per class and it belongs to the class.
		 * it can be accessed before any objects of its class are
		 * created and without a reference to any object.
		 */
		System.out.println("static methodThree called");
	}

}
