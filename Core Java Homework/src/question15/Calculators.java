//Write a program that defines an interface having the following methods: addition, 
//subtraction, multiplication, and division.  Create a class that implements this interface and provides 
//appropriate functionality to carry out the required operations. Hard code two operands in a test class having a main 
//method that calls the implementing class.

package question15;
import java.io.*; 
public class Calculators {
	interface operations
	{
		public double add(double a, double b);
		public double sub(double a, double b);
		public double multi(double a, double b);
		public double div(double a, double b);
	}
	static class Calculator implements operations
	{
		double a;
		double b;
		double result;
		@Override
		public double add(double a, double b) {
			// TODO Auto-generated method stub
			return a + b;
		}

		@Override
		public double sub(double a, double b) {
			// TODO Auto-generated method stub
			return a - b;
		}

		@Override
		public double multi(double a, double b) {
			// TODO Auto-generated method stub
			return a * b;
		}

		@Override
		public double div(double a, double b) {
			// TODO Auto-generated method stub
			return a / b;
		}
	    public void printResult() { 
	         System.out.println("The result is " + result); 
	    } 
	      

	public static void main(String[] args)
	{
		
		Calculator calc = new Calculator();
		double a = calc.add(31, 14.5);
		double b = calc.div(14.5, 31);
		System.out.println("The addition of 31 and 14.5 results in " + a);
		System.out.println("The addition of 14.5 by 31 results in " + b);
	}
			
	}
		

}

