package QT17;

import java.util.Scanner;

/*
 * Write a program that calculates the simple interest on the principal, 
 * rate of interest and number of years provided by the user. 
 * Enter principal, rate and time through the console using the Scanner class.
 * Interest = Principal* Rate* Time
 */

public class QT17 {

	public static void main(String[] args) {
		//scanner
		Scanner sc = new Scanner(System.in);
	
		
		System.out.println("Please enter principal amount: ");
		float p = sc.nextFloat(); //scanner takes in float value
		
		System.out.println("Please enter rate: ");
		float r = sc.nextFloat();//scanner takes in float value
		
		
		System.out.println("Please enter the number of years: ");
		int y = sc.nextInt();//scanner takes in float value
		
		 float i = p*r/100*y ; //set i equals to principal * rate * time
		 
		 System.out.println("Your Interest is :$" + i);
	
		
		

	}

}
