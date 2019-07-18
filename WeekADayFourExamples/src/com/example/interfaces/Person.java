package com.example.interfaces;

public interface Person {
	
	public static final int a=4;
	
	int b = 5;
	//implicitly always public static final
	
	public void eat();
	
	default public void snackingWhileAntiquing() {
		System.out.println("java 8, jwhy");
	}

}
