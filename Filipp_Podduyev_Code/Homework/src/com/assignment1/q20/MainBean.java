package com.assignment1.q20;

import java.io.Serializable;

public class MainBean implements Serializable {
	String name;
	int age;
	String placeOfBirth;

	public MainBean(String name, int age, String placeOfBirth) {
		super();
		this.name = name;
		this.age = age;
		this.placeOfBirth = placeOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	@Override
	public String toString() {
		return "MainBean [name=" + name + ", age=" + age + ", placeOfBirth=" + placeOfBirth + "]";
	}
	

}
