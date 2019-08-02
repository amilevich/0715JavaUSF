package q4;
import java.util.*;

public class factorial {
	static int factor(int num) {
		
		if(num==1) {
			return 1;
		}else {
			return(num*(factor(num-1)));
			
		}
	}
public static void main(String[] args) {
	System.out.print("Enter a number to find it's factorial number :- ");
	Scanner sc=new Scanner(System.in);
	int num1=sc.nextInt();
	System.out.println(factor(num1));
}
}
