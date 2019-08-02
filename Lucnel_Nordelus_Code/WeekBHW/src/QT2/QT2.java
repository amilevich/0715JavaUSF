package QT2;

public class QT2 {

	// Write a program to display the first 25 Fibonacci numbers beginning at 0.
	public static void main(String[] args) {
		System.out.print(n1 + " " + n2);
		printFib(25);
	}
	
static int n1 = 0, n2 = 1;
	// creates method  which add  two ints to create the third
	static void printFib(int count) {
		if(count > 2) {
			int n3 = n1+n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" " + n3);
			printFib(count - 1);
		}
	}
}
