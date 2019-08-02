package QT1;

public class MyClass {

	// Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4

	public static void main(String[] args) {
		int arr[] = { 1,0,5,6,3,2,3,7,9,8,4 };
		bubbleSort(arr);
		System.out.println("Sorted array: ");
		printArray(arr);

	}
//performed a bubble sort on integer array , and put the values in a temp arry
	
	public static void bubbleSort(int arr[]) {
		for(int x = 0; x < arr.length - 1; x++) {
			for(int y = x + 1; y < arr.length; y++) {
				if(arr[x] > arr[y]) {
					int temp = arr[x];
					arr[x]=arr[y];
					arr[y]=temp;
				}
			}
		}
}
	//created a method to print numbers in arr
	static void printArray(int arr[]) {
		int n = arr.length;
		for(int i = 0; i< n; i++) {
			System.out.print(arr[i]);
		}
	}
	

}

