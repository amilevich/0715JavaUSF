// Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
package q9;

import java.util.ArrayList;
import java.util.ListIterator;

public class Primetime {

	//two separate arraylists are created, one stores 1-100, the other is intended to store the prime numbers that are found
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
			
			//if the condition for the number being prime is met, it is added to the prime number list
			if (!snitch) {
				primeNumero.add(numba);
			}
		}
		//this returns the value so the data is not lost
		return primeNumero;
	}

	// this prints both lists in the console
	static void printList(ArrayList<Integer> arr) {
		ListIterator<Integer> iterator = arr.listIterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.print("\n");
	}
	
	//this is where we initialize the first list, and have it be 1 - 100
	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<>(), newArr = new ArrayList<>();

		for (int i = 1; i <= 100; i++) {
			arr.add(i);
		}
		
		//this is where we have the recursive methods called
		printList(arr);
		newArr = checkPrime(arr);
		printList(newArr);

	}
}
