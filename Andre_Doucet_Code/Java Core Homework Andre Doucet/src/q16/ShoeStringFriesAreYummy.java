//when wanting to run from command prompt you have to delete (package q16;) from the top of the class
package q16;


public class ShoeStringFriesAreYummy {
	
	
	public static void main(String[] args) {
//		if(args.length > 0) {
//	String words = new String();
//	words = "THUNDERCATS HOOOOOOOO!";
//	System.out.println(words);
//		}
		int count = 0;
		for(int i=0; i<args.length; i++ ){
		    count = 0;
		    for (int j = 0; j<args[i].length();j++){
		        if (args[i].charAt(j) == 'e'){
		        count++;

		        }
		    }
		    System.out.println(count+" ");
		}
}
}