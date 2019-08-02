package QT4;

public class QT4 {
	// Write a program to compute N factorial
	public static void main(String[] args) {
		
		//System.out.println("Factorial of 10 is: " + printfactor(10));
		System.out.println(printfactor(10));
	}

	 static int printfactor(int n) {
		if (n == 1) {
			return 1;
		}
		else {
			return n * printfactor(n-1);
					
			
		}
	}
	}
	
		

	


