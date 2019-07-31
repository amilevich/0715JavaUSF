package com.homework;

public class Problem13 {
	//Display the triangle on the console as follows using any type of loop.  
	//Do NOT use a simple group of print statements to accomplish this.
    //0
    //1 0
    //1 0 1
    //0 1 0 1

	public static void main(String[] args) {
		//keeps track of repeating pattern
		int flag = 0;
		
		//double nested for loop
		for(int i = 0; i<4 ; i++ ) {
			for (int j = 0; j < i +1 ; j++) {
				//System.out.print(j);
				if(flag == 0) {
					//Prints out flag at current state
					System.out.print(flag);
					flag = 1;
					continue;
				}
					
				if(flag == 1) {
					//Print out flag at current state
					System.out.print(flag);
					flag = 0;
					continue;
				}
			}
			System.out.println("\n");
		}
	}
	
}
