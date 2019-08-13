package model;

public abstract class Person {
	protected String firstname;
	protected String lastname;

	Person(String firstName, String lastName) {
		this.firstname = firstName;
		this.lastname = lastName;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstname + ", lastName=" + lastname + "]";
	}

}