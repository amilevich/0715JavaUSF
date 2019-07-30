/*
 *  Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.
    0
    1 0
    1 0 1
    0 1 0 1

 */
package q13;

public class MakeEgyptProud {

	public static void printStuff(int n) {
		//the needed variables are declared
		int i;
		int j;
		
		boolean flag = true;
		
		
		//this for loop builds the pyramid until the boolean flag is false
		for (i = 1; i < 5; i++) {
			for (j = 1; j <= i; j++) {
				if(flag) {
					System.out.print(0);
					flag = false;
				} else {
					System.out.print(1);
					flag = true;
				}
				
			}
			System.out.println(" ");
		}

	}
}
