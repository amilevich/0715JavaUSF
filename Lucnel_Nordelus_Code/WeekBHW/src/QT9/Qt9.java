package QT9;

import java.util.ArrayList;
import java.util.Collection;

public class Qt9 {

	/*
	 * Create an ArrayList which stores numbers from 1 to 100 and prints out all the
	 * prime numbers to the console.
	 */

	public static void main(String[] args) {
		//created an array list
		ArrayList<Integer> primeArr = new ArrayList<Integer>();
		for (int i = 0; i <= 100; i++) {
			if (i % 2 != 0) { //check if prime
				primeArr.add(i);
				System.out.println(i);

			}
		}
	}

}
