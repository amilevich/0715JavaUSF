package com.example.animal;

public class MainDriver {
	
	public static void main(String[] args) {
		
		Animal anim = new Animal();
		anim.setName("Bailey");
		anim.setColor("Brown");
		anim.setAge(2);
		
		System.out.println("The animal's name is " + anim.getName());
		System.out.println("The animal's color is " + anim.getColor());
		System.out.println("The animal's age is " + anim.getAge());
	}

}
