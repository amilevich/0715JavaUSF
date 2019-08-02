package q12;

import java.util.ArrayList;

public class EnhancedForEvenNumbers {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		//Add 1-100 to the ArrayList.
		for (int i = 1; i <= 100; i++) { 
			al.add(i);

		}
		//Enhanced For loop for traverse through the ArrayList.
		for (int num : al) {
			//Find the even number using Modulus operator.
			if (num % 2 == 0) {
				System.out.println(num);
			}

		}
	}
}
