package q17;

import java.util.Scanner;

public class IntersetCounter {

	public static void main(String[] args) {
		double interest;
		double principal;
		double interestRate;
		int years;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Principal Amount :");
		principal = sc.nextDouble();
		System.out.println("Enter The Yearly Interst Rate :");
		interestRate = sc.nextDouble();
		System.out.println("Enter Number Of Years :");
		years = sc.nextInt();
		
		interest = (principal*interestRate)/12 *years;
		System.out.println("The Interest Of the Principal Amount For "+ years+ "Years is = "+ interest);

	}

}
