package q10;
import java.util.Scanner;
public class Ternary {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the first number :");
		int a = sc.nextInt();
		System.out.println("Enter the second number :");
		int b = sc.nextInt();
		int result;

		result = (a<b) ? a : b; //Compare the two numbers with Ternary operator.
		System.out.println("The minimum number is = " +result);
	}
}
