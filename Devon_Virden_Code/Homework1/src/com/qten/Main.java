package com.qten;

//import random
import java.util.Random;

//q10: find min value
public class Main {

	public static void main(String[] args) {
		// ok, looked this up and it seems the ternary operator compares two values and
		// assigns one to another value depending on which fulfills the condition.

		int a;
		int b;
		int min;
		// because where's the fun in order
		Random chaos = new Random();
		a = chaos.nextInt(680);
		b = chaos.nextInt(680);
		min = (a < b) ? a : b;
		System.out.println("a:\t\t" + a + "\nb:\t\t" + b + "\nMinimum:\t" + min);
	}

}
