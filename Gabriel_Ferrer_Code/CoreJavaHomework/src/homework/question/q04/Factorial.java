package homework.question.q04;

public class Factorial {
	/* 
	 * Use of Recursion to compute for Factorial
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12; // number to compute factorial for
		int factorial = compute(n); // first call of compute(int n)
		
		System.out.println(factorial); // print out the result
	}

	
	public static int compute(int n) {
		if (n > 1) {   // if n is greater than 1, 
			return n * compute(n-1);  // succeeding calls of compute(int n)
		} else {
			return 1; // ends compute(int n) call
		}
	}
}
