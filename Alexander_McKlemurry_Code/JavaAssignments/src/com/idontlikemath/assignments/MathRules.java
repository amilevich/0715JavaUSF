package com.idontlikemath.assignments;


	class MathImplement implements MathSucks{
		
		
		public static void main(String[] args) {		//main method
			
			int a = 15;		//value of the given integers
			int b = 10;
			
			MathImplement obj = new MathImplement(); // object will now equal this object
			
			obj.addition(a, b);
			obj.subtraction(a, b);
			obj.division(a, b);
			obj.multiplication(a, b);
			}
		
		
		
		public void addition(int a, int b){ //public allows the console to print, void serves as the 
			//return value holder since we have given no return
				int c = a+b;			//creating a new integer and making it equal a value

	System.out.println("Sum of the numbers is: "+c);	// prints out the sum of integer c which was 
	//created previously

	}
						//All of the below code follow the same rules as the above
						//notes so I did not type anything for the rest

	public void subtraction(int a, int b){

	int c = a-b;

	System.out.println("Difference of the numbers is: "+c);

	}

	  

	public void multiplication(int a, int b){

	int c = a*b;

	System.out.println("Product of the numbers is: "+c);

	}

	  

	public void division(int a, int b){

	int c = a/b;

	System.out.println("Division of the numbers is: "+c);

	}
	}

	

	
	
