package q3;
import java.util.Scanner;
public class reverseString {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);//Scanner object created
		System.out.println("Enter a Word to Reverse :");
		String word = sc.nextLine();
		for (int i = word.length() - 1; i >= 0; i--) {
			System.out.print(word.charAt(i));
		}
	}
}
