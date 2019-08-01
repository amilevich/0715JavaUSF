package question19;

import java.util.ArrayList;
import java.util.Arrays;

public class Array_Lists_V2 
{
	public static boolean prime(int n)
	{
		for(int i=2; i<n; i++)
		{
			if(n%i==0) 
			{
				return false; 
			}
		}
		return true; 
	}
	public static void main(String[] args)
	{
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i<10; i++)
		{
			int number = i + 1;
			numbers.add(number);
		}
//		Checking to see if the array was created correctly
//		for (int i = 0; i<numbers.size(); i++)
//		{
//			System.out.println(numbers.get(i));
//		}
		int evensum = 0;
		int oddsum = 0;
		for (int i = 0; i<10; i++)
		{
			if (numbers.get(i)%2 == 0)
			{
				evensum += numbers.get(i);
			}
		}
	System.out.println("The sum of all even numbers from 1 to 10 is " + evensum);
	for (int i = 0; i<10; i++)
	{
		if (numbers.get(i)%2 == 1)
		{
			oddsum += numbers.get(i);
		}
	}
	System.out.println("The sum of all odd numbers from 1 to 10 is " + oddsum);
//	for (int i = 0; i<10; i++)
//	{
//		if ((numbers.get(i)%2 != 0) & (numbers.get(i)%3 != 0))
//		{
//			numbers.remove(i);
//		}
//	}
// failed attempt at creating a looping method to check for primes
	for(int i=0; i<numbers.size(); i++)
	{
		if(prime(numbers.get(i)))
		{
			numbers.remove(i); 
		}
	}
	System.out.println("These are the numbers from 1 to 10 which are not primes " + numbers);
}
}
