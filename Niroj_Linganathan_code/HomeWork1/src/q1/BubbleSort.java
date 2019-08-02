package q1;

public class BubbleSort {

	public static void bubblesort(int arrg[]) {
		int n = arrg.length; // assigning the array's length to a variable called n.
		for (int i = 0; i < n - 1; i++) {
			for (int a = 0; a < n - i - 1; a++) {
				if (arrg[a] > arrg[a + 1]) { // Compare the first variable with the next one if that is it bigger than
												// second.
					int temp = arrg[a]; // if yes put the variable one in a temporary variable.
					arrg[a] = arrg[a + 1]; // put the second variable in the first one's index.
					arrg[a + 1] = temp; // put the temporary variable in the next index.

				}
			}
		}

	}

	static void print(int arrg[]) { // print method for print the sorted array.
		int n = arrg.length;
		for (int i = 0; i < arrg.length; i++) {
			System.out.println(arrg[i]);
		}
	}

	public static void main(String[] args) {
		int arrg[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };

		bubblesort(arrg);
		print(arrg);
	}
}
