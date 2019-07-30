package com.HW1.question15;

public class Question15 implements operations{
	
	public int addition(int x, int y) {			//implementation of abstract methods
		return x+y;
	}
	public int subtraction(int x, int y){
		return x-y;
	}
	public int multiplication(int x, int y){
		return x*y;
	}
	public int division(int x, int y){
		return x/y;
	};

	public static void main(String[] args) {
		int x = 5, y = 2;						//test case values
		Question15 test = new Question15();
		System.out.println(test.addition(x,y));	//outputting results
		System.out.println(test.multiplication(x,y));	

	}
}

interface operations{						//Interface with abstract methods
	abstract int addition(int x, int y);
	abstract int subtraction(int x, int y);
	abstract int multiplication(int x, int y);
	abstract int division(int x, int y);
}
