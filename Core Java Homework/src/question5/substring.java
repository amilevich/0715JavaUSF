package question5;
import java.util.Scanner;

public class substring {
	public static void main(String[] args)
	{
	Scanner s = new Scanner(System.in);
	System.out.println("Enter a phrase.");
	String phrase = s.nextLine();
	System.out.println("Your phrase has " + phrase.length() + " characters.");
	int len = phrase.length();
	char[] substring = new char[len];
	System.out.println("Enter a number of characters.");
	int idx = s.nextInt();
	s.close();
	if (len < idx)
	{
		System.out.println("Too many characters. Try again!");
	}
	else
	{
		for (int i = 0; i<idx; i++)
		{
			substring[i] = phrase.charAt(i);
		}
	}
	System.out.println("The substring was " + new String(substring));
	}
}
