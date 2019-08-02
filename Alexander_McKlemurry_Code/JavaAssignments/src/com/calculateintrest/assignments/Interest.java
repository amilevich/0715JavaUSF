package com.calculateintrest.assignments;

import java.util.Scanner; //standard importing practice in order to utilize the Scanner
//Class

public class Interest {  //making it public so it is easier to access. using class to
	//make sure everything falls under the same package via being under the same class

	public static void main(String args[])
	{
	Scanner scanner = new Scanner(System.in); 
	System.out.println("Enter principle amount :"); //This allows you to input an amount
	//of your choosing
	float principle = scanner.nextFloat(); 
	System.out.println("Enter time in years : "); //Allows you to input the amount of time
	// in years that you wish to multiple the compound the interest by years based on amount
	float time = scanner.nextFloat(); 
	System.out.println("Enter rate annually : "); //Profit increases yearly based on
	//principle amount and will amount to the total based on the years in which interest
	// was compounded.
	float rate = scanner.nextFloat(); 
	float interest = (principle*rate*time)/100; 
	System.out.println("The total amount of interest gained : " + interest); //The total
	//profit gained base on the above conditions
	}
	
}


