package com.homework.question10;

public class Minimun {
	
	//Minimun two nuumers is {a,b} = 1/2(a+b -|a-b|)
	
	public static void main(String[] args) {
		
		
		int a =9,b = 20, c;
		
		c = a + b;
		
		//This verify the absolute value with ternary operator
		
		c = (a-b) < 0 ? (c -= (-1*(a-b))) : (c -= (a-b));
		
		c /= 2;
		
		System.out.println("The minum betwenn two numbers id : " + c);
		
	}

}
