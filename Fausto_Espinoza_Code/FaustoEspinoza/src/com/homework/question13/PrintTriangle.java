package com.homework.question13;

import java.util.Scanner;

//0
//1 0
//1 0 1
//0 1 0 1
//0 1 0 1 0
//1 0 1 0 1 0
//1 0 1 0 1 0 1

public class PrintTriangle {
	
	//It generates the triangle
	static void printTriangle(int number, int i, boolean flag) {
		
		if(i <= number) {
			for(int j = 1 ; j <= i ; j++) {
				if(flag) {
					System.out.print("0 ");
					flag = false;
				}else {
					System.out.print("1 ");
					flag = true;
				}	
			}
			System.out.println("");
			//Call recursion
			printTriangle(number, i + 1, flag);
		}
		
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean flag = true;
		
		System.out.println("Enter the jump number: ");
		int number = scn.nextInt();
		
		if(number > 0) {
			printTriangle(number, 1, flag);
		}else {
			System.out.println("Number's jump can not be negative or zero");
		}	
		
		
//		for(int i = 1 ; i < number + 1; i++) {
//			for(int j = 1; j <= i; j++) {
//				if(flag) {
//					System.out.print("0 ");
//					flag = false;
//				}else {
//					System.out.print("1 ");
//					flag = true;
//				}				
//			}	
//			System.out.println("");
//		}
		
		scn.close();
	}

}
