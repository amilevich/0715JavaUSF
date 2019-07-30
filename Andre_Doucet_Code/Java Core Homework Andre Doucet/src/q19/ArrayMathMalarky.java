/*
 *Create an ArrayList and insert integers 1 through 10. 
 *Display the ArrayList. 
 *Add all the even numbers up and display the result. 
 *Add all the odd numbers up and display the result. 
 *Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
*/

package q19;

import java.util.ArrayList;

public class ArrayMathMalarky {
	public static void main(String[] args) {
	ArrayList<Integer> boop = new ArrayList<Integer>(10);
	
	for (int i = 0; i <= 10; i++)
	{
		boop.add(i);
		System.out.println(boop.get(i));
	}
	
}}
