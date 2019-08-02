package homework.question.q02;

public class Fibonacci {
	public int count = 0;
	public int[] sequence;
	
	Fibonacci(int count, int start) {
		this.count = count; //fixed count
		sequence = new int[count]; // creates an empty array
		sequence[0] = 0;
		createFibonacciSequence(count, start, 1); // create fibonacci sequence
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci fibonacci = new Fibonacci(25, 0); // create new fibonacci object
		for (int i=0; i < fibonacci.sequence.length;i++) {
			System.out.println(fibonacci.sequence[i]); //display the sequence
		}
	}
	
	public void createFibonacciSequence(int count, int start, int next) {
		int sum = start + next;   // add previous and next value
		if (this.count - count + 1 < this.count) {   // if fixed count minus changing count is less than the fixed count minus one
			this.sequence[ this.count - count + 1 ] = sum;
			createFibonacciSequence(--count, next, sum); // call createFibonacciSequence again and pass the decremented count
														 // start with the next value and the next will be the
														 // sum of the previous and next value
		}
	}

}
