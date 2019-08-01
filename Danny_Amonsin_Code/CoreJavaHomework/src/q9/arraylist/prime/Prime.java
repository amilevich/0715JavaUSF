package q9.arraylist.prime;

import java.util.ArrayList; //import java ArrayList utilities

public class Prime 
{

	// Create an ArrayList which stores numbers from 1 to 100 and prints out all the
	// prime numbers to the console.
	
	static int n; //declared integer n and i as static to allow for using them without object instance of prime class
	static int i;

	public static void main(String[] args)  //main method, start point of program execution
	{
		ArrayList<Integer> list = new ArrayList<>(); //ArrayList object creation that takes in Integer objects, with variable name of "list"

		for (i = 1; i <= 100; i++) //for loop for storing numbers 1 to 100 into the ArrayList
		{
			list.add(i);
		}

		for (int i = 2; i <= list.size(); i++)  //for loop for checking all numbers from 2 to 100, we start at 2 because a prime number is a natural number greater than 1
		{

			boolean isPrime = true; //boolean variable isPrime starts out as true

			for (int j = 2; j < i; j++)  //a prime number is only divisible by itself and 1, this loop checks through numbers, for loop for checking this by looping through numbers, as long as j is less than value of i 
			{

				if (i % j == 0)  //as we loop, we check if the remainder of i divided by j is equivalent to 0, if it is, then isPrime will become false, and we break out of the for loop for that number and back to the outer for loop until we reach 100
				{
					isPrime = false;
					break;
				}
			}
			// print the number
			if (isPrime) //if isPrime is still true, then we know that the number is prime and we print out the value in the ArrayList, we do i-1 because the ArrayList index starts as 0
				System.out.print(list.get(i - 1) + " ");
		}
	}
}
