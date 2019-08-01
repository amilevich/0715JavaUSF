package com.qseventeen;
//import scanner
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//create scanner
		Scanner sc= new Scanner(System.in);
		//initilize and input variables
		System.out.println("Please enter principal ammount:");
		double principal=sc.nextDouble();
		System.out.println("Please enter interest rate percent:");
		double rate =sc.nextDouble();
		System.out.println("Please enter time of loan in years:");
		double time=sc.nextDouble();
		//calculate and print
		double interest = principal*(rate/100)*time;
		System.out.println("Final interest:\t$"+interest);
	}

}
