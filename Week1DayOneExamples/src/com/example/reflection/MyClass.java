package com.example.reflection;

import java.lang.reflect.Method;

public class MyClass {
	/*
	 * Reflection API
	 * library that allows us to inspect and/or modify runtime
	 * attributes of classes, interfaces, fields, and methods.
	 * It is used mostly for debugging/information purposes.
	 */

	public static void main(String[] args) {
		//creating an object whose property is to be checked
		Flan vanillah = new Flan();
		
		//create a class object from the Flan class using getClass
		//method
		Class cls = vanillah.getClass();
		//System.out.println("vanillah.getClass = " + cls);
		
		//get the methods of the class through the object
		//by using GetMethods
		Method[] methods = cls.getMethods();
		//System.out.println(methods);
		for(Method i : methods) {
			System.out.println(i.getName());
		}
		
	}

}
