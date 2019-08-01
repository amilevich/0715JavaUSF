package com.example.serialization;

import java.io.Serializable;

public class Cereal implements Serializable{

	/**
	 * @author Revature
	 * javadocs
	 */
	private static final long serialVersionUID = 3370997549081560346L;

	/*
	 * SerialVersionUID
	 * represents your class's version
	 * 
	 * The serialization runtime associates a version number with each
	 * Serializable class.
	 * It is used during deserialization to verify that the sender 
	 * and the receiver of the serialized object have loaded the class
	 * for that object which is compatible with respect to serialization.
	 * 
	 * If we have a different UID for sender/receiver,
	 * we get an InvalidClassException
	 */
	
	private String brand;
	private String color;
	private double gramsOfSugar;
	private boolean isCrunchy;
	
	public Cereal() {
	}
	
	

	public Cereal(String brand) {
		super();
		this.brand = brand;
	}



	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getGramsOfSugar() {
		return gramsOfSugar;
	}

	public void setGramsOfSugar(double gramsOfSugar) {
		this.gramsOfSugar = gramsOfSugar;
	}

	public boolean isCrunchy() {
		return isCrunchy;
	}

	public void setCrunchy(boolean isCrunchy) {
		this.isCrunchy = isCrunchy;
	}

	public Cereal(String brand, String color, double gramsOfSugar, boolean isCrunchy) {
		super();
		this.brand = brand;
		this.color = color;
		this.gramsOfSugar = gramsOfSugar;
		this.isCrunchy = isCrunchy;
	}

	@Override
	public String toString() {
		return "Cereal [brand=" + brand + ", color=" + color + ", gramsOfSugar=" + gramsOfSugar + ", isCrunchy="
				+ isCrunchy + "]";
	}
	
	
}
