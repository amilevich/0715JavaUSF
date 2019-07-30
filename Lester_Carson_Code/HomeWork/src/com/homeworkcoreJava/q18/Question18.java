package com.homeworkcoreJava.q18;

//Answers to Question 18:
//Q18. Write a program having a concrete subclass that inherits three abstract methods from a superclass.  Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass: 
//Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
//Convert all of the lower case characters to uppercase in the input string, and return the result. 
//Convert the input string to integer and add 10, output the result to the console.
//Create an appropriate class having a main method to test the above setup.
//Barton Carson
public abstract class Question18 {

	//Abstract classes
	public abstract boolean UpperCase();
	public abstract String LowerToUpper();
	public abstract int Add10();

}

//Class to implement methods
class Concrete extends Question18 {

	@Override
	public boolean UpperCase() {
		
		String str = "Billy";
		return !str.equals(str.toLowerCase());
		
	}

	@Override
	public String LowerToUpper() {
		
		String str = "Why so Serious sir";
		return str.toUpperCase();
		
	}

	@Override
	public int Add10() {
		
		String str = "15";
		int string = Integer.parseInt(str);
		string = string + 10;
		return string;
		
	}
}

class Main {
	
	public static void main(String[] args) {
		
		//Main method to run the methods
		Concrete concrete = new Concrete();
		
		System.out.println(concrete.UpperCase());
		System.out.println(concrete.LowerToUpper());
		System.out.println(concrete.Add10());
		
	}	
}