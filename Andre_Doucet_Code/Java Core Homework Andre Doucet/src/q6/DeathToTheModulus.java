package q6;
import java.util.Scanner;

public class DeathToTheModulus {
	
	public static void main(String[] args) 
	{ 
		//the user is first solicited input for a number
		//the input number is then assigned to variable "num" 
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number to see if it is even or not!");
		int num = s.nextInt();
		
		//this is an if else statement that uses boolean methods to determine whether to print out the number as being even or odd
		if(isEven(num) != false) 
			System.out.print( "Even" ); 
		else
			System.out.print( "Odd" ); 
	} 
		
	// in order to assess whether the number is even or odd, the number is multiplied twice, then divided twice, and if the number equals what is was
	// originally then it is even
	static boolean isEven(int num) 
	{  
		return ((num / 2) * 2 == num); 
	} 

	
	
} 

