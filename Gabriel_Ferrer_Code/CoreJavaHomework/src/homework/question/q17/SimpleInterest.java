package homework.question.q17;

import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the Interest Rate per Year:");
		double annualInterestRate = scan.nextDouble();
		System.out.println("Please enter the Prinicipal:");
		double principal = scan.nextDouble();
		System.out.println("Please enter the Number of Years:");
		double year = scan.nextDouble();
		
		double interest = annualInterestRate/100 * principal * year;
		
		System.out.println("The simple interest for the given inputs is: " 
					+ String.format("%,.2f", interest));
	}

}
