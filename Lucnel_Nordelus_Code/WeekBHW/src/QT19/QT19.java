package QT19;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
 * 
 * Create an ArrayList and insert integers 1 through 10. 
 * Display the ArrayList. Add all the even numbers up and display the result. 
 * Add all the odd numbers up and display the result. 
 * Remove the prime numbers from the ArrayList 
 * and print out the remaining ArrayList.
 */
public class QT19 {

	public static void main(String[] args) {
		
		List<Integer> all = new ArrayList();
		all.add(1);
		all.add(2);
		all.add(3);
		all.add(4);
		all.add(5);
		all.add(6);
		all.add(7);
		all.add(8);
		all.add(9);
		all.add(10);
		
		System.out.println(all);
		
		int even = 0;
		int odd = 0;
		
	
		// sum even, sum odd, remove primes
		for(int i = 0; i < all.size(); i++ )
		{
			Integer num = all.get(i);
			
			if( num % 2 == 0 )
				even = even + num;
			if( num % 2 == 1  )
				odd = odd + num;
			
			
			if( isPrime(num) )
			{		
				all.remove(i);
				i--;              // account for removal
			}
	
		}
	
		System.out.println("The sum of the even numbers: " + even);
		System.out.println("The sum of the odd numbers: " + odd);
		System.out.println( "ArrayList (no primes): " + all );
		
	}

	private static boolean isPrime(Integer i) {
int counter = 0;
		
		for(int j = 1; j <= i; j++)
			if( i % j == 0)
				counter++;
			
		if( i <= 3 )
			return true;
		else if( counter > 2)
			return false;
		else
		
		return true;
	}

	}


