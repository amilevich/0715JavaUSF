package com.question14.switchcase;

import java.lang.Math;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public class Icandothis {
	
	static Date date = new Date();

	public static void main(String[] args) {
		
		//create scanner to get user input through the console.
		//Depending on the number the user will put in, they will be
		//directed to a specific case/option
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a number between 1, 2 and 3");
		int number = sc.nextInt();
		
		//Switch statement implemented
		switch (number) {
		case 1 :
			Scanner w = new Scanner(System.in);
			System.out.println("please enter the number you would like the square root of:");
			int number1 = w.nextInt();
			if(number1 > 0) {
				System.out.println(Math.sqrt(number1));
				break;
			}
			
		case 2 :
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			System.out.println(dateFormat.format(date));
			break;
			
		case 3:
			String z = "I am learning core java";
			String[] zz = z.split(" ");
			for(String myString : zz) {
			System.out.println(myString);
		}
		
			

	}

}
}
