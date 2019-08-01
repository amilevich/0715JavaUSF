package q1.bubble.sort;

public class Bubble 
{
	static int[] arr = {1,0,5,6,3,2,3,7,9,8,4}; //array with random values
	
	public static int[] bubbleSorter(int[] array) //bubble sort method that takes in an array of integers and returns an array of integers
	{
		int i, j, temp = 0; //variable containers, for for loops, and temp is a temporary container to hold the value at j when we are implementing the value swap process between j and j+1 indexes
		
		for(i=0; i< array.length - 1; i++) //increments each time after inner loop so that we can cut off the end value for the inner loop in the number of loops due to the last value of the array being the sorted as the highest value in the array
		{
			for(j = 0; j < array.length - 1 - i; j++) //re-loops till end of array before jumping back out to outer loop, at some point j will be less than the right side and we will not enter the for loop block and jump back to the outer loop 
			{
				if(array[j] > array[j+1]) //check if value at index j is greater than value at j+1, if so, execute code below, code block "bubbles" bigger values to end of array
				{
					temp = array[j]; //temp assigned value at index j
					array[j] = array[j+1]; //assign value at j+1 to j
					array[j+1] = temp; //assign value in temp to index j+1
							
				}
			}
		}
		
		
		return array; //returns sorted array
	}
	
	public static void main(String[] args) 
	{
		System.out.print("unsorted array :");
		for(int x : arr)  //prints out each element in unsorted array
		{
		System.out.print(x);
		}
		System.out.print("\n" + "sorted array :");
		bubbleSorter(arr);
		for(int x : arr)  //prints out each element in sorted array
		{
		System.out.print(x);
		}
	}
}
