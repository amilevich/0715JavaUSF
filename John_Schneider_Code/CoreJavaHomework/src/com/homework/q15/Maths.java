package com.homework.q15;

public class Maths implements Interfce
{
	/*
	 * Implementation of the "Interfce" interface
	 * defining the simple mathematical methods
	 */
	
	@Override
	public int addition(int x, int y) {
		return x + y;
	}

	@Override
	public int subtraction(int x, int y) {
		return x - y;
	}

	@Override
	public int multiplication(int x, int y) {
		return x * y;
	}

	@Override
	public int division(int x, int y) {
		return x / y;
	}
}