package homework.question.q19;

import java.util.ArrayList;
import homework.question.q06.*;
import homework.question.q09.*;

public class EvenOddPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbers = new ArrayList<>();
		Integer evenTotal = 0, oddTotal = 0;
		
		for (int i = 1; i <= 10; i++) {
			numbers.add(i);
		}
		
		for (Integer integer : numbers) {
			if (EvenWithoutModulus.isEven(integer)) {  //uses isEven of q06 to check if number is prime
				evenTotal += integer;
			} else {
				oddTotal += integer;
			}
		}
		
		PrimeNumbers.removeNonPrimeNumbers(numbers); // leave prime numbers
		
		System.out.println("Total of even numbers is: "+evenTotal);
		System.out.println("Total of odd numbers is: "+oddTotal);
		System.out.println(numbers); // print prime numbers
	}

}
