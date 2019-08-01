package question17;

import java.util.Scanner;

/*
 * Write a program that calculates the simple interest on the principal, 
 * rate of interest and number of years provided by the user. Enter principal, rate and 
 * time through the console using the Scanner class.
 */
public class SimpleInterest 
{
	public static void main(String[] args)
	{
		System.out.println("This is a simple interest program.");
		System.out.println("Enter your hypothetical principal.");
		Scanner s = new Scanner(System.in);
		double principal = s.nextDouble();
		System.out.println("Enter your hypothetical interest rate (Yearly).");
		double rate = s.nextDouble();
		System.out.println("Enter how many years you want to pass.");
		int years = s.nextInt();
		s.close();
		rate = rate/100;
		principal = rate * principal;
		System.out.println(principal);
		principal = principal * years;
		System.out.println("The simple interest accrued after " +years+" years will be " + principal + " dollars." );
	}
}
