package com.example.animal;

public class Animal {

	//bean/model making
	
	//POJO - plain old java object (only the variables)
	//bean - variables, getters/setters, toString, constructors,
	//hashcode, .equals()
	
	/*
	 * encapsulation is typically achieved by making variables
	 * private so they can only be accessed within the same
	 * class.
	 * However, it is possible to access them if we provide
	 * public getters and setter methods.
	 * Get -> returns the variable value
	 * Set -> sets the value
	 * 
	 * Access modifiers:
	 * restrict access to classes, methods, variables, etc
	 * 
	 * "private" - class itself
	 * default - class itself, package
	 * "protected" - class itself, package, children
	 * "public" - class itself, package, children, everything
	 */
	
	private String name;
	private String color;
	private int age;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
