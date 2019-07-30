//Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user. 
//Enter principal, rate and time through the console using the Scanner class.
//Interest = Principal* Rate* Time


package q17;

import java.util.Scanner;

public class PrincipalPrinciple {

	public static void main(String[] args) {
		
		//solicit input for principal, rate, and time
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the principal amount.");
		
		@SuppressWarnings("resource")
		Scanner input2 = new Scanner(System.in);
		System.out.println("Please enter the rate.");
		
		@SuppressWarnings("resource")
		Scanner input3 = new Scanner(System.in);
		System.out.println("Please enter the amount of time.");

		int prin = input.nextInt();
		//rate needs to correspond to correct math, which is calculated here
		float rate = input2.nextFloat() / 100;
		int time = input3.nextInt();
		
		//the formula is performed and printed to the console
		float interest = prin * rate * time;
		System.out.println(interest);
	}

}
