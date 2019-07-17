package com.example.polymorphism;

public class Sum {

	public int sum(int x, int y) {
		return(x+y);
	}
	
	public int sum(int x, int y, int z) {
		return(x+y+z);
	}
	
	public static void main(String[] args) {
		
		Sum s = new Sum();
		System.out.println(s.sum(500, 200));
		System.out.println(s.sum(4, 68, 5));
		System.out.println(s.sum(2.0, 3.74));
		
		main("Awesome sauce");
		main(1, "Sanity");
		
	}
	public static void main(String cool) {
		System.out.println("Hi, " + cool);
	}
	
	public static void main(int cool, String strong) {
		System.out.println("Goodbye, " + cool + " " + strong);
	}

	public double sum(double d, double e) {
		return (d+e);
	}
	
	//cannot overload methods by only return type
	
}
