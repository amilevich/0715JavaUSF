package com.qfifteen;
//q15: interface inheritance
public class Test {
//test case
	public static void main(String[] args) {
		OperatorInterface test=new Operator();
		double a = 6.3;
		double b= 5.96;
		
		System.out.println("Addition:\t"+test.addition(a, b)+
				"\nMultiplication:\t"+test.multiplication(a, b));
	}

}
