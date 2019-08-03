package com.homework17.interest;

import java.util.Scanner;

public class InterestRate {
	//To calculate the simple interest of principal
        
   //create a public static method to take inputs
       public static void main(String[] args) {
		
    	   Scanner scanner = new Scanner(System.in);
    	   System.out.println("Please enter interest rate");
    	   double rate = scanner.nextDouble();
    	   System.out.println("Please enter principal");
    	   double principal = scanner.nextDouble();
    	   System.out.println("Please enter time");
    	   int time =scanner.nextInt();
    	   
    	   double interest = rate * principal * time;
    	   System.out.println(interest);
    	   scanner.close();
    	   
	}
    	  // scanner.close();
    	   
}