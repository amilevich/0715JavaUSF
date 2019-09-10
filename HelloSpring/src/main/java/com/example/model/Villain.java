package com.example.model;

public class Villain {
	
	private String name;
	private String power;
	private Boolean isEvil;
	
	public Villain() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public Boolean getIsEvil() {
		return isEvil;
	}

	public void setIsEvil(Boolean isEvil) {
		this.isEvil = isEvil;
	}

	@Override
	public String toString() {
		return "Villain [name=" + name + ", power=" + power + ", isEvil=" + isEvil + "]";
	}

	public Villain(String name, String power, Boolean isEvil) {
		super();
		this.name = name;
		this.power = power;
		this.isEvil = isEvil;
	}
	
	

}
