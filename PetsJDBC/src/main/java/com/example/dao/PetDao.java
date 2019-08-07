package com.example.dao;

import java.util.List;

import com.example.model.Pet;

public interface PetDao {
	
	//The purpose of the DAO interface
	//is to provide us with the guideline for our
	//CRUD operations to be performed on objects of type Bean (Pet)
	
	//CREATE
	public int insertPet(Pet p);
	
	//READ
	public Pet selectPetByName(String name);
	public List<Pet> selectAllPets();
	
	//UPDATE
	public int updatePet(Pet p);
	
	//DELETE
	public int deletePet(Pet p);

}
