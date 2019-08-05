package model;

import java.io.Serializable;

public abstract class Person implements Serializable {
	
	private static final long serialVersionUID = -8593943474336272269L;
	/**
	 * 
	 */
	protected String firstName;
	protected String lastName;

	public Person() {
	}

	Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}