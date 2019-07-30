package com.homework.question17;

import java.util.Scanner;

import javax.xml.validation.SchemaFactoryConfigurationError;

public class SimpleInterest {
	//Calculate the simple interest. 
	static void  calcInterest(double principal, double rateInterest, int numberYears) {
		double total1 =  principal + (principal * (rateInterest/100) * (double) numberYears);
		double prd = principal;
		for(int i = 1; i <= numberYears; i++) {
			prd =  principal +  (principal * ( rateInterest/100) *  (double) i);
			System.out.println("Interest for year " + i + " is " + prd);
		}
		
		System.out.println("Total for: " + numberYears + " years: " + total1);
		
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter Principal: ");
		double principal = scn.nextDouble();
		System.out.print("\n");
		System.out.print("Enter rate of interest: ");
		double rate = scn.nextDouble();
		System.out.print("\n");
		System.out.print("Enter numbers of years: ");
		int nYears = scn.nextInt();
		System.out.print("\n");
		
		
		calcInterest(principal, rate, nYears);
		
		scn.close();

	}

}
