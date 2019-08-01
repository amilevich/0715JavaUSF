package com.qthirteen;

public class Main {

	public static void main(String[] args) {
		// nested for loop to print out exactly what the question wants. Couldn't really
		// determine a pattern, so I forced it
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y <= x; y++) {
				if (x < 2) {
					System.out.print((x + y) % 2 + " ");
				} else {
					System.out.print((x + y + 1) % 2 + " ");
				}
			}
			System.out.println("\n");
		}

	}

}
