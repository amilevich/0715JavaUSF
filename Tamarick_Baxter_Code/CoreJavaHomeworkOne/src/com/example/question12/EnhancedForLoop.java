package com.example.question12;

public class EnhancedForLoop {

	public static void main(String[] args) {

		// declaring array size
		int numbers[] = new int[100];

		// assigning it values from 1 to 100
		for (int i = 1; i <= 100; i++) {
			numbers[i - 1] = i;
		}

		// enhanced for loop
		for (int num : numbers) {
			if (num % 2 == 0) {
				System.out.print(num + " ");
			}
		}
	}

}
