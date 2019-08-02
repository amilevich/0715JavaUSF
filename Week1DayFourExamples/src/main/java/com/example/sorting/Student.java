package com.example.sorting;

public class Student implements Comparable<Student>{

	private int studentId;
	private String name;
	private double gpa;
	private String personalityQuirk;
	private String major;
	private int numberOfLegs;
	
	public Student() {
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getPersonalityQuirk() {
		return personalityQuirk;
	}

	public void setPersonalityQuirk(String personalityQuirk) {
		this.personalityQuirk = personalityQuirk;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getNumberOfLegs() {
		return numberOfLegs;
	}

	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}

	public Student(int studentId, String name, double gpa, String personalityQuirk, String major, int numberOfLegs) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.gpa = gpa;
		this.personalityQuirk = personalityQuirk;
		this.major = major;
		this.numberOfLegs = numberOfLegs;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", gpa=" + gpa + ", personalityQuirk="
				+ personalityQuirk + ", major=" + major + ", numberOfLegs=" + numberOfLegs + "]";
	}

	@Override
	public int compareTo(Student o) {
		return this.getStudentId() - o.getStudentId();
	}
	
	
}
