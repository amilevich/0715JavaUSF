package q5;

import java.util.Scanner;

public class substring {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word :");
		String str = sc.nextLine();
		System.out.println("Enter a number limit to get substring:");
		int idx = sc.nextInt();
		try {
			System.out.println(str.substring(0, idx-1));
		}catch(StringIndexOutOfBoundsException e) { //Exception handler for the invalid numbers.
			System.out.println("Enter a valid number!");
			System.out.println(e.toString());
		}
		
		

		
	}
}
