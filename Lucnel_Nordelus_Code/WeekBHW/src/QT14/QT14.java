package QT14;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * Write a program that demonstrates the 
 * switch case. 
 * Implement the following functionalities 
 * in the cases:
 * 
 */
public class QT14 {

	public static void main(String[] args) {
		//scanner
		Scanner sc =new Scanner(System.in);

		int choice = sc.nextInt();
		//takes in user choices
		
		switch(choice) {
		
		case 1:
			System.out.println("Enter a number: ");
			int num = sc.nextInt();
			System.out.println("The square root of " + num + " is: " + Math.sqrt(num)); // finds square root
			break;
		case 2:
			Date today = Calendar.getInstance().getTime();// gets todays date
			System.out.println("Today's date is: " + today);
			break;
		case 3:
			String str = "I am Learning core java";
			String[] arr = str.split("\\s"); //splits the string
			for(String s: arr)
				System.out.println(s);
			break;
			
		}
	}
}
