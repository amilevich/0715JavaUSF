package com.questionthirteen.triangle;

public class MyClass {
	public static void main(String[] args) {
        int tri = 0;
        //first print out the first element 0
        System.out.println(tri);
        
        //for for the second and third levels of triangle
        for (int i = 0; i <= 1; i+=1)
        {
            for (int j = 0; j <= i; j++)
            {
                System.out.print(tri+1);

                if(j%2==0){
                    System.out.print(tri);
                }
            }
            System.out.print("\n");
        }
        
        //last level of the triangle
        for(int i =0; i<3;i+=2){
            if(i%2==0)
            {
                System.out.print(tri);
            }
            System.out.print(tri+1);
        }
    }

}
