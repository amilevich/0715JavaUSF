package com.homework.quesone;

import java.util.Scanner;

// Sort two employees based on their name, department, and age using the Comparator interface

public class QuesSeven {

	public static void main(String[] args) {
		QuesSeven obj = new QuesSeven(); // create new object		
		obj.sortEmployee(); // invoke sortEmployee method
	}

	public void sortEmployee() {
		Scanner scan = new Scanner(System.in); // create a new object for class Scanner		
		System.out.print("Input name of first employee: "); // ask user to input string
		String str1 = scan.nextLine(); // assign variable str1 with type String to string that was inputed from console
		System.out.print("Input department of first employee: "); // ask user to input string
		String str1_2 = scan.nextLine(); // assign variable str1_2 with type String to string that was inputed from console
		System.out.print("Input age of first employee: "); // ask user to input number
		int age1 = scan.nextInt(); // assign variable age1 with type String to string that was inputed from console
		
		scan.nextLine();
		
		System.out.print("Input name of second employee: "); // ask user to input string
		String str2 = scan.nextLine(); // assign variable str2 with type String to string that was inputed from console
		System.out.print("Input department of second employee: "); // ask user to input string
		String str2_2 = scan.nextLine(); // assign variable str2_2 with type String to string that was inputed from console
		System.out.print("Input age of second employee: "); // ask user to input number
		int age2 = scan.nextInt(); // assign variable age2 with type String to string that was inputed from console
		
		scan.close();
		
		System.out.println();
		compare(str1, str2); // invoke compare method with first str
		compare(str1_2, str2_2); // invoke compare method with second one
		compareInt(age1, age2); // invoke compareInt method with age
	}

	public void compare (String str, String str2) {
		if(str.compareTo(str2) == 0) System.out.println("Inputed data identically");
		else System.out.println("Inputed data are different");
	}

	public void compareInt (int x, int y) {
		
		String x1 = Integer.toString(x);
		String y1 = Integer.toString(y);
		if(x1.compareTo(y1) == 0) System.out.println("Age of both employee are equal");
		else System.out.println("They have different ages");
	}

}
