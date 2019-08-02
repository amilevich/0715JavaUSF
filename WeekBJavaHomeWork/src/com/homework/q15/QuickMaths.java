package com.homework.q15;

public class QuickMaths implements IBasicMath {
	
	public static void main(String[] args) {
		
		QuickMaths kwikMathz = new QuickMaths(); //Creates an instance from QuickMaths class
												//So that we can use our methods in the main method
		
		System.out.println(kwikMathz.addition(5,76));
		System.out.println(kwikMathz.multiplication(5,5));
		
	}

	@Override                                 //All methods bellow are being Overidden from the Implemented BasicMath Interface
	public int addition(int what, int is) {
		int sum = what + is;
		return sum;
	}

	@Override
	public int subtraction(int love, int baby) {
		int difference = love - baby;
		return difference;
	}

	@Override
	public int multiplication(int dont, int hurt) {
		int product = dont * hurt;
		return product;
	}

	@Override
	public int division(int me, int noMore) {
		int dividend = me/noMore;
		return dividend;
	}
	
	
	

}
