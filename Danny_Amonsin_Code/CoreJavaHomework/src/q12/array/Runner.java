package q12.array;

public class Runner 
{
	//Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
	
	public static void main(String[] args) //main method, program execution starts here
	{
		int[] array = new int[100]; //new array instance called "array", this object has 100 indexes, starting from index 0 
	
		for(int i=0; i <=100-1;i++) //for loop that populates the array with integers from 1 to 100
		{
			array[i] = (i+1);
		}
		
		for(int x : array) //enhanced for loop through array "array", with integer "x" as the temporary variable that stores the integer value as we loop through the array
		{
			if((x-1) % 2 == 0) //checks the value in the array index to see if the remainder is equivalent to 0, if it is, then we print out the array value to the console, e.g index 3 has value 2, which has remainder of 0, so it prints to the console
			{
				System.out.println(array[x]);
			}
		}
		
	}
}
