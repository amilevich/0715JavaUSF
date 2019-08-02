package QT18;

import java.util.Scanner;

/*
 * Write a program having a concrete subclass that inherits three 
 * abstract methods from a superclass.  Provide the following three 
 * implementations in the subclass corresponding to the 
 * abstract methods in the superclass: 
 * 
 * 1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found
 * 2.Convert all of the lower case characters to uppercase in the input string, and return the result. 
 * 3.Convert the input string to integer and add 10, output the result to the console
 * 
 * Create an appropriate class having a main method to test the above setup.
 * 
 */

public class QT18 extends qtSuper {
	
	private static String name;
	private static String number;

	public static void main(String[] args) {
		
	QT18 qt18 = new QT18();
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter your name: ");
		name = sc.nextLine(); //takes name input
		
		System.out.println("Enter a number: ");
		number = sc.nextLine(); //takes number input
		
		
		System.out.println("Any capital letters: "  + qt18.hasUpperCase() + " " + name );
		
		qt18.toUpperCase();
		System.out.println("All Caps: " + name );
		
		System.out.println("Number plus 10: " + qt18.add());
			
}

	
	@Override //overides method
	public boolean hasUpperCase() {
		
		for(int i = 0; i < name.length(); i++){
			if( Character.isUpperCase( name.charAt(i) ) )
				return true;
		}
		return false;
	}

	@Override //overides method
	public void toUpperCase() {
		name = name.toUpperCase();
	}

	
	@Override //overides method
	public int add() {
		return Integer.parseInt(number) + 10;
	}
	
}






