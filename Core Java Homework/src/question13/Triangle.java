package question13;

import java.util.Scanner;

class Triangle
	{
		public static void main(String args[])
		{
			Scanner s=new Scanner(System.in);
			System.out.print("Enter the number of rows: ");
			int rows=s.nextInt();
			s.close();
//			for(int i=1; i<=rows; i++)
//			{
//				for(int j=1; j<=i; j++)
//				{
//					if(j%2==1)
//					{
//						System.out.print("1");
//					}
//					else{
//						System.out.print("0");
//						}
//  
//					}
//				System.out.println();
//			}
			for(int i=1; i<=rows; i++)
			{
				  for(int j=1; j<=i; j++)
				  {
					  if((i+j)%2==1)
					  {
						  System.out.print("0");
					  }
					  	else{
					  		System.out.print("1");
					  	}
				  
				  }
				  System.out.println();
}
}
}
	