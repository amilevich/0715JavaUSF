package com.example.generics;

/*
 * Generics <>
 * generic methods and generic classes enable programmers
 * to specify, with a single declaration, a set of related types
 * 
 * Generics enforce compile time safety by allwing you to use
 * parametirized types.
 * 
 * Naming Conventions:
 * type parameters can be named anything you want, but the convention
 * is to use single, uppercase letters to make it obvious that
 * they are not real class names
 * T => Generic Data Type
 * E => Element
 * K => Map Key
 * V => Map Value
 * N => Number
 */

class GenericClass<T> {
	private T value;

	public GenericClass(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
}

public class MyClass {
	public static void main(String[] args) {

		GenericClass<String> gClassOne = new GenericClass<String>("Birb");
		GenericClass<Integer> gClassTwo = new GenericClass<>(4);
		//bad practice to leave the right hand side of the chevrons
		//empty.
		//it has no effect on the compiler
		//you want to restrict the data type so that you don't get
		//unexpected object types
		
		GenericClass gClassThree = new GenericClass<>("Beer");
		//if you don't explicitly put the left chevrons,
		//it defaults to Object
	}

}
