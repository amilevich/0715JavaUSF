package com.example.inheritance;

public class SuperHero {
	
	String ability = "Flying";
	String name = "Flying Chungus";
	String alias = "Rodger Rodgerson";
	String weakness = "Lukewarm water";
	
	public SuperHero() {
		System.out.println("***In SuperHero constructor***");
	}

	public SuperHero(String ability, String name, String alias, String weakness) {
		super();
		this.ability = ability;
		this.name = name;
		this.alias = alias;
		this.weakness = weakness;
	}
	
	public SuperHero(String a) {
		System.out.println("***In SuperHero Constructor(String)");
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getWeakness() {
		return weakness;
	}

	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}
	
	public void alterWeakness() {
		weakness = "Bullet holes?";
	}

}
