package q19.array.list;

import java.util.ArrayList;
import java.util.ListIterator;

public class Runner 
{

	static int even;
	static int odd;

	public static void main(String[] args) 
	{
		ArrayList<Integer> arr = new ArrayList<Integer>();

		// adding values 1-10 to ArrayList "arr"
		for (int i = 1; i <= 10; i++) 
		{
			arr.add(i);
		}
		System.out.println(arr);

		// adding up even values of the ArrayList "arr" and displaying the sum to
		// console
		for (int i = 0; i <= 10 - 1; i++) 
		{
			if (arr.get(i) % 2 == 0) 
			{
				even += arr.get(i);
			}

		}
		System.out.println(even);

		// adding up odd values of the ArrayList "arr" and displaying the sum to console
		for (int i = 0; i <= 10 - 1; i++) 
		{
			if (arr.get(i) % 2 == 1) 
			{
				odd += arr.get(i);
			}

		}
		System.out.println(odd);

		ListIterator<Integer> list = arr.listIterator(); //creates an instance of the ListIterator that takes in a Integer objects, and iterating through ArrayList "arr"

		while (list.hasNext())  //continues to iterate through the ArrayList as long as this method returns true, hasNext method checks to see if there is something ahead in the index
		{
			int x = list.next(); //returns the next element in the list and advances the cursor position
			boolean check = false; //check variable of boolean type, starts out as being false

			for (int j = 2; j < x; j++)  //for loop checks if it is a prime number 
			{
				if ((x % j) == 0)
				{
					check = true;
					break;
				}
			}
			
			if (!check) //if check is not true, then we remove an element from the ArrayList "arr"  
			{
				list.remove();
			}
		}

		System.out.println(arr); //after all prime numbers have been removed from the ArrayList "arr", we print what is left in the ArrayList "arr"
	}

}
