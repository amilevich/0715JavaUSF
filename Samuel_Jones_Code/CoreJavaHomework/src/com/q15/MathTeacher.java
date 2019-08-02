package com.q15;

public class MathTeacher implements SkilledAtMath{
	public double addition(double one, double two) { //concrete versions of the abstract methods in the SkilledAtMath interface
		
		return one + two;
	}
	
	public double subtraction(double one, double two) {
		return one-two;
	}

	public double multiplication(double one, double two) {
		return one*two;
	}
	
	public double division(double one, double two) {
		return one/two;
	}
}
