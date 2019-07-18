package com.example.interfaces;

public class Developer implements Person {

	@Override
	public void eat() {
		System.out.println("eating isn't allowed "
				+ "while the code is in (e)motion");
		
	}

}
