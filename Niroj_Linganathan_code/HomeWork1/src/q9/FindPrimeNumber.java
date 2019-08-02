package q9;

import java.util.ArrayList;

public class FindPrimeNumber {

	static void prime() {
		ArrayList<Integer> primeArray = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			primeArray.add(i);
		}
		System.out.println(primeArray);
		
		for(int a=0;a<primeArray.get(a);a++)
			if(isprime(primeArray.get(a))) {
				System.out.print(primeArray.get(a)+"  ");
	        	
	        }else if (a == primeArray.size() - 1){
	        	break;
	        }
		}
		
		
	
	static boolean isprime(int n) {
		
		if(n<=1) {
			return false;
		}else {
			for(int a=2;a<n;a++) {
				if(n%a==0) {
					return false;
					
				}
				
			}
		}
		return true;
		
	}

	public static void main(String[] args) {
		prime();
		
        
	}

}
