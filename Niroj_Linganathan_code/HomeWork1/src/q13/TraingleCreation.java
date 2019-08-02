package q13;

public class TraingleCreation {
	
	public static void main(String[] args) {
		
		int row;
		int col;
		for(row=0;row<6;row++) {
			for(col=0;col<=row;col++) {
				if(((row+col) % 2== 0)) { 
					System.out.print("0");
					
				}else {
					System.out.print("1");					
				}
			
				
			}
			System.out.println();
		}
		
		}
	
	}


