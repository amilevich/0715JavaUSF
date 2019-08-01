package q17.simple.interest;

import java.util.Scanner;

public class Runner 
{	
	public static void main(String[] args) //main method execution start 
	{
		Scanner scan = new Scanner(System.in); //creates new Scanner instance so we can start accepting values in the console
		
		System.out.println("To calculate doubleerest on principal, enter starting principal value"); //prints out a statement to the console to let us know to enter a principal value
		double principal = scan.nextDouble(); //stores the entry into the console in the double type variable "principal"
		
		System.out.println("Enter rate of interest"); //prints out after the console entry to tell us to enter the next value
		double rate = scan.nextDouble(); //takes in the value for variable of double type "rate" through the console
		double x = (rate/100); //takes the rate variables and divides by 100 and stores that in x
		
		System.out.println("Enter number of years"); //prints the statement to let us know to enter the number of years
		double time = scan.nextDouble(); //stores the console entry in the "time" variable, of double type
		
		double interest = principal*time*x; //takes all the values entered and multiplies them all
		System.out.println(interest); //prints out the double type value to the console after the value has been stored in "interest" variables
		
		scan.close(); //closes the scanner so no more input
	}
}
