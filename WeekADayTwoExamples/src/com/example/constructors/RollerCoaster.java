package com.example.constructors;

public class RollerCoaster {

	String seatType;
	int length;
	int maxSpeed;
	int height;
	
	//constructor chaining
	//a constructor can invoke another constructor of the same class
	//by using this
	
	RollerCoaster(){
		this(7, 575, 500);
		System.out.println("inside no arg constructor");
	}

	public RollerCoaster(int length, int maxSpeed, int height) {
		this("not a good seat", 500, 5000, 10000);
		System.out.println("inside parameterized constructor with 3 arguments");
	}

	public RollerCoaster(String seatType, int length, int maxSpeed, int height) {
		super();
		/*
		 * the first line of any constructor is super();
		 * even if you don't explicitly state it
		 * it calls the constructors of the parent class to make sure
		 * the parent is full formed before the subclass is constructed
		 */
		this.seatType = seatType;
		this.length = length;
		this.maxSpeed = maxSpeed;
		this.height = height;
		System.out.println("inside parameterized constructor with 4 arguments");
	}
	
	public static void main(String[] args) {
		//RollerCoaster rc = new RollerCoaster();
		RollerCoaster rc2 = new RollerCoaster(100, 50, 500);
	}
	
}
