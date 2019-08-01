package q14.switcher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Runner 
{
	/*
	 * Case 1: Find the square root of a number using the Math class method. 
	 * Case 2: Display today’s date.
	   Case 3: Split the following string and store it in a string array.
		“I am learning Core Java”
	 */
	
	public static void main(String[] args) //main method program execution start
	{
		double x = 32; //"x" initialized to 32 of type double
		String a = "I am learning Core Java"; //"a" initialized of type String
		
		switch(2) //switch statement for switching between cases based on the argument passed in
		{
		case 1:  //this case does a square root of double value "x"
			System.out.println("Square root of " + x + " is " + Math.sqrt(x));
			break;
			
		case 2: //prints out to the console the current date based on the format of MM/dd/yyyy
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate localDate = LocalDate.now();
			System.out.println(dtf.format(localDate));
			break;
			
		case 3: //splits up the String variable "a" into 3 parts and adds them to the String array "arr" that has an array size of 3
			String[] arr = new String[3]; 
			
				arr[0] = a.substring(0,10);  //splits up the string from index 0 to 10, where the ending index is exclusive so the next split needs to start from 
				arr[1] = a.substring(10,20); //10 because the starting index is inclusive
				arr[2] = a.substring(20,23);
				
				System.out.print(arr[0]); //shows that the whole String is still the same
				System.out.print(arr[1]);
				System.out.print(arr[2]);
				
				System.out.println("\n" + "Index 0: " + arr[0]); //shows what substring is in each array index
				System.out.println("Index 1: " + arr[1]);
				System.out.println("Index 2: " +arr[2]);
		}
	}
}
