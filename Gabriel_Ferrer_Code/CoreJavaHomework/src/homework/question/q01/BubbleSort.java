package homework.question.q01;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4}; // assigns an int array to sort
		
		// loop through all int starting from 0 index to size minus one
		for (int i = 0; i < arr.length - 1; i++) {
			// loop through all int from from 0 index to size minus one minus every increase in i
			for (int j = 0; j < arr.length - i - 1; j++) {
				int temp; //stores the temporary variable
				if(arr[j] > arr[j+1]) {  // if previous int is greater than the next int
					temp = arr[j];  // store previous int to the temporary variable
					arr[j] = arr[j+1]; // store the next int to the variable of the previous int
					arr[j+1] = temp; // store temp to the variable of the next int
				}
			}
		}
		
		System.out.print("[ ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("]");
	}

}
