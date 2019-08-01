package question14;
import java.util.Scanner;
import java.math.*;
import java.time.LocalDate;

public class SWITCH 
{
/*Case 1: Find the square root of a number using the Math class method. 
Case 2: Display today¡¯s date.
Case 3: Split the following string and store it in a string array. 
		¡°I am learning Core Java¡±
		*/
	public static void main(String[] args)
	{
		System.out.println("Pick which function you want.");
		System.out.println(" ");
		System.out.println("(1) Find the square root an entered number.");
		System.out.println("(2) Show today's date.");
		System.out.println("(3) See a split string.");
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		switch(choice)
		{
		case 1: 
		System.out.println("Enter a positive integer.");
		double target = s.nextInt(); 
		double result = Math.sqrt(target);
		System.out.println(result);
		s.close();
		break;
		case 2:
		LocalDate today = LocalDate.now();
		System.out.println(today);
		break;
		case 3: 
		// String targetstring;
		String targetstring = "I am learning Core Java";
		targetstring.split(" ");
		System.out.println(targetstring);
		break;
		}
		
	}
}
