package QT12;

/*
 * 
 * Write a program to store numbers from 1 to 100 
 * in an array. Print out all the even numbers 
 * from the array. 
 * Use the enhanced FOR loop for printing out 
 * the numbers.
 */

public class QT12 {

	public static void main(String[] args) {
		// created an array with a length of 100
		int[] arr = new int[100];
		
		// for loop 
		for(int i = 0; i < arr.length; i++)
		arr[i] = i + 1; //stores 1 - 100 in arr
		
		//enhanced for loop
		for(int numb: arr)
			if( numb % 2 == 0 ) // checks if numb is even
				System.out.println(numb);

	}

}
