package q14;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NintendoSwitch {
	public static void main(String[] args) {
		//a scanner solicits input for the switch statement, and depending on the choice one of the three cases will execute
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Andre Switch program! "
				+ "\n Please select from the following options."
				+ "\n Type 1 In order to find the square root of a number."
				+ "\n Type 2 for Today's Date."
				+ "\n Type 3 for something different.");
		int num = input.nextInt();
		//String lever = new String();
		
		switch (num) {
		
		case 1:
			//System.out.println("Math will happen.");
			
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.println("Enter number to find square root in Java : ");
	      
	        //getting input number from user to calculate square root
	        double square = scanner.nextDouble();
	      
	      
	        //getting square root of a number in Java
	        double squareRoot = Math.sqrt(square);
	      
	        //printing number and its square root in Java
	        System.out.printf("Square root of number: %f is : %f %n" , square, squareRoot);
			
			break;
			
		case 2:
			DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
			Date dateobj = new Date();
			System.out.println(df.format(dateobj));
			
			break;
			
		case 3:
			//System.out.println("Look at me I'm a string!");
			String sentence = "I am learning Core Java";
			String[] array = sentence.split("I \n"
					+ "am \n"
					+ "learning \n"
					+ "Core \n"
					+ "Java", -1);
			System.out.println(java.util.Arrays.toString(array));
			break;
		}
		
		
	}
}
