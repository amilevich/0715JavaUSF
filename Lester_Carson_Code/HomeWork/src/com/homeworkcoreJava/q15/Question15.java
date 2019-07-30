package com.homeworkcoreJava.q15;

//Answers to Question 15:
//Q15. Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division.  Create a class that implements this interface and provides appropriate functionality to carry out the required operations. Hard code two operands in a test class having a main method that calls the implementing class.
//Barton Carson
public class Question15 {

	public static void main(String[] args) {
		
		int a = 20, b = 5;
		Functions function = new Functions();
		
		//Functions run in main
		System.out.println(function.add(a,b));
		System.out.println(function.sub(a,b));
		System.out.println(function.mult(a,b));
		System.out.println(function.div(a,b));
	}

}

//interface holding methods
interface Operations {
	
	//Interface methods
	int add(int a, int b);
	int sub(int a, int b);
	int mult(int a, int b);
	int div(int a, int b);
	
}

//Class implementing methods
class Functions implements Operations {

	//Implemented functions
	@Override
	public int add(int a, int b) {return a + b;}

	@Override
	public int sub(int a, int b) {return a - b;}

	@Override
	public int mult(int a, int b) {return a * b;}

	@Override
	public int div(int a, int b) {return a / b;}	
}