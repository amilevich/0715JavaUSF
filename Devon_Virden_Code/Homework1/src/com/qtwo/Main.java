package com.qtwo;
//Q2: fibonacci

public class Main {

	public static void main(String[] args) {
		int num = 25;
		fibPrint(num);
		
	}
	//count is how many we want to print. I usually skip zero, sorry.
	
	//first one
	static void fibPrint(int count) {
		int num = 1;
		System.out.println(num);
		count--;
		System.out.println(num);
		count--;
		if(count>0) {
			fibPrint(count,num,num);
		}
	}

	//the second one
	static void fibPrint(int count, int num1) {
		int num = num1;
		System.out.println(num);
		count--;
		if(count>0) {
			fibPrint(count,num1, num);
		}
	}
	
	//calculates anything beyond the first two ones
	static void fibPrint(int count, int num1, int num2) {
		int num = num1+num2;
		System.out.println(num);
		count--;
		if(count>0) {
			fibPrint(count,num2, num);
		}
	}
}
