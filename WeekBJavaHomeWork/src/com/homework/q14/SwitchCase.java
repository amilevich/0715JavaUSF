package com.homework.q14;
import java.lang.Math;
import java.util.Scanner;
import java.text.SimpleDateFormat; //Importing tools for time data and formating
import java.util.Date;
public class SwitchCase {
	
	public static void main(String[] args) {
		menu();
	}
		
	
	
	public static void menu() {
		Scanner scanner = new Scanner(System.in); //creating a menu to traverse through the switch statement easily
	System.out.println("Choose an option: \n");
	System.out.println("\t 1. Calculate the square root of 30");
	System.out.println("\t 2. Display Todays Date");
	System.out.println("\t 3. Divide the sentence 'I am Learning Core Java'");
	options(scanner.nextInt());
	}
	
	public static void options(int option) {
		
	switch(option) {
	case 1:
		double result = Math.sqrt(30);  //using the square root method of the Math class to find the square root of 30
		System.out.println(result);
		menu();   //Call the Menu method for use of use to test all switch cases.
		break;
	case 2:
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // used to format current date
	    Date date = new Date();  
	    System.out.println(formatter.format(date));  //uses date object and formatting to display the current date, from the imported classes
	    menu();   //Call the Menu method for use of use to test all switch cases.
		break;
	case 3:
		String arr[] = new String[5];
		arr[0]="I";
		arr[1]="am";
		arr[2]="learning";
		arr[3]="Core";
		arr[4]="Java";
		for (int i = 0; i < arr.length; i++) { //Iterates through array to print the Sentence 'I am Learning Core Java'
			System.out.print(arr[i]+" ");
		}System.out.println();
		menu();  //Call the Menu method for use of use to test all switch cases. 
		
		break;
		
	}
	}
}


