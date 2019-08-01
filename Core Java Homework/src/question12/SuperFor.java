package question12;

import java.util.ArrayList;

public class SuperFor 
{
	public static void main(String[] args)
	{
	ArrayList<Integer> numbers = new ArrayList<>();
	for (int i = 1; i<= 100; i++)
	{
		numbers.add(i);
	}
	for (int i:numbers)
	{
		if (i%2 == 0)
				{
					System.out.print(i + " ");
				}
	}
}
}