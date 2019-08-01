package com.example.inheritance;

public class SuperVillain extends SuperHero {

	String alias = "The Running Nestle";
	//shadowing
	/*
	 * refers to the practice of using two variables with the same name
	 * in overlapping scopes
	 * when you do this, the variable with the higher scope is hidden,
	 * because the variable with the lower scope "shadows" it
	 * 
	 * if you want to access the parent variable's value
	 * from within the child class super.variablename
	 * (and cast it to the parent class)
	 */
	
	public SuperVillain() {
		System.out.println("***In SuperVillain Constructor***");
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	@Override
	public void alterWeakness() {
		weakness = "sadness );";
	}
	
}
