package com.example.scopes;

public class MyClass {
	
	/*
	 * Scopes
	 * the lifetime of a variable/member
	 * 
	 * 4 scopes:
	 * 
	 * Class/Static - variables exist for the lifetime of the class
	 * and exist within the class itself
	 * 
	 * Object/Instance - the object's field/state variables exist for the
	 * lifetime of the object and exist within the object itself
	 * 
	 * Local/Method - parameters and any variables defined at the method
	 * level. Variables exist for the lifetime of the method call.
	 * 
	 * Block/Loop - any variable defined within the curly brackets or
	 * a control flow statement
	 */
	
	public static int i; //class scope
	
	static {
		int i = 5; //block scope
	}
	
	public static void main(String[] args) {
		
		int k; //method scope
		for(int j=0; j<3; j++) {
			int i = 5; //block scope
		}
		Burrito b = new Burrito(760, "extra small", true);
		//calories -> object scope
	}
}

class Burrito {
	int calories; //class scope
	String size;
	boolean isVeggie;
	public Burrito(int calories, String size, boolean isVeggie) {
		super();
		this.calories = calories;
		this.size = size;
		this.isVeggie = isVeggie;
	}
	
	
}
