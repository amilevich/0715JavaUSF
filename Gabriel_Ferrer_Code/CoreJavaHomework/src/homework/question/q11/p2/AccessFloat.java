package homework.question.q11.p2;

import homework.question.q11.p1.Floats;


public class AccessFloat extends Floats {
	
	public static void main(String[] args) {
		//Access through inheritance
		AccessFloat accessFloat = new AccessFloat();
		System.out.println("Access through inheritance");
		System.out.println(accessFloat.a);
		System.out.println(accessFloat.b);
		
		System.out.println("===============");
		
		//Access by calling static variables of Floats
		System.out.println("Access by calling static variables of Floats");
		System.out.println(Floats.a);
		System.out.println(Floats.b);
	}
}
