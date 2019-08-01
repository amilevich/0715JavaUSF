package com.qfifteen;

//implement the interface
public class Operator implements OperatorInterface {
	// override the methods
	@Override
	public double addition(double a, double b) {
		return (a + b);
	}

	@Override
	public double subraction(double a, double b) {
		return (a - b);
	}

	@Override
	public double multiplication(double a, double b) {
		return (a * b);
	}

	@Override
	public double division(double a, double b) {
		return (a / b);
	}

}
