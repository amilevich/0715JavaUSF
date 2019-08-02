package com.q11.packagea;

import com.q11.packageb.Q11B;

public class Q11 {
	public static void main(String[] args) {
		Q11B q11b = new Q11B(); //instantiate a Q11B object
		System.out.println("Variable F1 from class Q11B: " + q11b.getF1()); //retrieve the value of f1 from the object
		System.out.println("Variable F1 from class Q11B: " + q11b.getF2()); //retrieve the value of f2 from the object
	}
}
