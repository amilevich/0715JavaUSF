package question9;

import java.util.ArrayList;
import java.util.Arrays;

public class Primes 
{
	public static void main(String[] args) {
		
	ArrayList<Integer> numbers = new ArrayList<>(); 
	int[] baseprimes = {1, 2, 3, 5, 7, 11};
	ArrayList<Integer> primes = new ArrayList<Integer>() {{ for (int i : baseprimes) add(i); }};
	for (int i = 1; i<= 100; i++)
	{
		numbers.add(i);
	}
//a test	System.out.println(Arrays.toString(numbers.toArray()));
	for (int i = 1; i< 100; i++)
	{
		int number = numbers.get(i);
		if((number%2 != 0) & (number%3 !=0))
		{
			if ((number%5 != 0) & (number%7 !=0))
					{
						if(number%11!=0)
						{
							primes.add(number);
						}
					}
		}
	}
	System.out.println(Arrays.toString(primes.toArray()));
}
}