package homework.question.q13;

public class PrintTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {0,2,5,5};
		int idx = 0;
		
		for (int i : numbers) {
			if (idx == 3) System.out.print("0 "); // print zero before running for loop for number in index 3
			for(String str : Integer.toBinaryString(i).split("")) { //convert each int to binary string and add space
																	// between 0 or 1
				System.out.print(str + " ");
			}
			idx++;
			System.out.println();
		}
	}

}
