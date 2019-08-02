package homework.question.q09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import homework.question.q06.EvenWithoutModulus;

public abstract class PrimeNumbers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbers = new ArrayList<>();

		for (Integer j = 1; j <= 100; j++) {
			numbers.add(j);
		}
		
		removeNonPrimeNumbers(numbers);

		System.out.println(numbers);
	}

	public static void removeNonPrimeNumbers(ArrayList<Integer> numbers) {
		numbers.remove(0); // removes one from the list
		
		// removes numbers that are divisible to 2, 3, 5, 7 except 2, 3, 5, 6
		numbers.removeIf(n -> ( n % 2 == 0 && n != 2 )); // size 50

		numbers.removeIf(n -> ( n % 3 == 0 && n != 3 )); // size 34
		
		numbers.removeIf(n -> ( n % 5 == 0 && n != 5)); // size 28
		
		numbers.removeIf(n -> ( n % 7 == 0 && n != 7)); // size 25
		
		
	}

}
