/*
 *Create an ArrayList and insert integers 1 through 10. 
 *Display the ArrayList. 
 *Add all the even numbers up and display the result. 
 *Add all the odd numbers up and display the result. 
 *Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
*/

package q19;

import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayMathMalarky {
	public static void main(String[] args) {
	ArrayList<Integer> boop = new ArrayList<Integer>();
	int even = 0, sum = 0;
	
	for (int i = 0; i <= 10; i++)
	{
		
		boop.add(i);
		System.out.print(boop.get(i)+ " ");
	}
	
	for (int e=0; e < boop.size(); e++) {
		if((e%2)==0) {
			even+=boop.get(e);
			
		} else {
			sum +=boop.get(e);
		}
	}
	
	
	
	System.out.println("\n" + even);
	System.out.println("\n" + sum);
	boop = checkPrime(boop);
	System.out.println(boop);
	
	
	
	
	
}
	static ArrayList<Integer> checkPrime(ArrayList<Integer> arr) {
		ArrayList<Integer> primeNumero = new ArrayList<>();

		ListIterator<Integer> iterator = arr.listIterator();

		while (iterator.hasNext()) {
			int numba = iterator.next();
			boolean snitch = false;
			// Verify if the number is prime
			for (int i = 2; i < numba; i++) {
				if ((numba % i) == 0) {
					snitch = true;
					break;
				}
			}
			
			//if the condition for the number being prime is met, it is taken our of to the prime number list
			if (snitch) {
				primeNumero.add(numba);
			}
		}
		return primeNumero;
}
	
}
