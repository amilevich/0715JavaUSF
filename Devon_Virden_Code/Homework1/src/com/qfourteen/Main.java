package com.qfourteen;

import java.sql.Date;
import java.util.Random;

//cases

public class Main {

	public static void main(String[] args) {
		// God may not play dice, but I do
		Random az = new Random();
		int num = az.nextInt(537);
		switch (num % 3) {
		// case 1
		case 0:
			// printing out the square root of a number
			System.out.println(Math.sqrt(num));
			break;
		// case 2
		case 1:
			// using the Date class.
			Date day = new Date(System.currentTimeMillis());
			System.out.println(day);
			break;
		// case 3
		case 2:
			// splitting around the spaces
			String str = "I am learning core Java";
			String split[] = str.split(" ");
			for (String i : split) {
				System.out.println(i);
			}
		}
	}

}
