package com.example.polymorphism;

//base class
public class Parent {
	
	void show() {
		System.out.println("Parent's show()");
	}

}

class Child extends Parent{
	
	//this method overrides show() of Parent
	@Override
	void show() {
		System.out.println("Child's show()");
	}
}
