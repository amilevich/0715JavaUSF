package q19;

import java.util.ArrayList;

public class Arraylist {

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>();
		ArrayList<Integer> nonPrime = new ArrayList<Integer>();

		for (int i = 1; i <= 10; i++) {
			array.add(i);
		}
		System.out.println(array);
		int EvenResult = 0;
		int Oddresult = 0;
		for (int a = 0; a < array.size(); a++) {
			int num = array.get(a);

			if (num % 2 == 0) {//Find even number.
				EvenResult = EvenResult + num;
			} else {
				Oddresult = Oddresult + num;
			}

		}
		System.out.println("Sum of the Even Numbers : " + EvenResult);
		System.out.println("Sum of the Odd Numbers : " + Oddresult);
		
				for (int a = 0; a < array.get(a); a++)
			if (isprime(array.get(a))) {
				//System.out.print(array.get(a) + " ");
			
			} else if (a == array.size() - 1) {

				break;
			}else{ 
				nonPrime.add(a+1);//Insert the non prime numbers in an array.arrayIndex+1 to save the exact number.
			}
				System.out.println("Non Prime Numbers : "+nonPrime);
	}
	
	static boolean isprime(int n) {
		

		if (n <= 1) { //Since a is not a prime number get that number from the search beforehand.
			return false;
		} else {
			for (int a = 2; a < n; a++) {
				if (n % a == 0) {

					return false;
											
			}
	
		}
		return true;
		}	
	}
}
