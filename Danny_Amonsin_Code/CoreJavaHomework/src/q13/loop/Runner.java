package q13.loop;

public class Runner {
	// Display the triangle on the console as follows using any type of loop. Do NOT
	// use a simple group of print statements to accomplish this.

	public static void main(String[] args) 
	{

		  for (int i = 1; i <= 4; i++) //for loop starts at i = 1, and runs up to 4, this basically gives us the number of rows based on the number of loops
	        {
	            for (int j = 1; j <= i; j++) //nested for loop starts at j = 1, until equals to i, which is limited to 4, so each increment adds another number as we move down more rows
	            {
	               if(i <= 3) //if statement will run the block below until "i" reaches 3, then we will run the else statement block for the last row of 0 and 1
	               {
	            	   System.out.print(j % 2 + " "); //prints out the 1st 3 rows of 1 and 0 based on the increment of j, so first row is 1 modulus 2 = 0.5, and rounds up to 1 for the first row, and so on with increment of "j"
	               }								  
	            else
	                {
	                	System.out.print( 9 % j + " "); //this block takes modulus of 9 by j = 1, which gives us the first 0, then 9 by j = 2, which gives us 1, and so on, until j is equivalent to "i"
	                }
	            }	         
	            System.out.println(); //creates the next row
	        }
		
		
}
}
