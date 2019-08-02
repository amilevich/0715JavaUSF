package homework.question.q12;

import homework.question.q06.*;

public class PrintEvenNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = new int[100];
		int index = 0;
		
		System.out.println("Printing all even numbers from 1 - 100");
		for (int i : numbers) {
			numbers[index++] = index; // index++ gets the value of index before incrementing it
									  // = index  assigns the value to numbers[index++]
			                          // example: numbers[0] = 1; numbers[1] = 2; ......
			if ( EvenWithoutModulus.isEven(index) ) {
				System.out.println(index);
			}
		}
	}

}
