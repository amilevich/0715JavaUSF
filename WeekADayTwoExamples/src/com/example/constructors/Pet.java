package com.example.constructors;

public class Pet {
	
	String petName;
	String petSpecies;
	int numberOfLegs;
	
	Pet(){
		System.out.println("in a no arg constructor");
	}
	
	//parameterized constructor with two parameters
	public Pet(String petName, int numberOfLegs) {
		super(); //refers to the parent's class constructor
		this.petName = petName;
		//"this" is a reference variable that refers to the current
		//object
		this.numberOfLegs = numberOfLegs;
		System.out.println("in a constructor with two arguments");
	}

	public Pet(String petName, String petSpecies, int numberOfLegs) {
		super();
		this.petName = petName;
		this.petSpecies = petSpecies;
		this.numberOfLegs = numberOfLegs;
		System.out.println("in a constructor with three arguments");
	}

	public Pet(String petName, String petSpecies) {
		super();
		this.petName = petName;
		this.petSpecies = petSpecies;
		System.out.println("in a constructor with two string arguments");
	}

	void info() {
		System.out.println("Pet's name is " + petName 
				+ ". It has " + numberOfLegs + " legs.");
	}
	

}
