package com.example.MainDriver;

import com.example.dao.PetDaoImpl;
import com.example.model.Pet;

public class Main {

	public static void main(String[] args) {

		//populate some data
		Pet petOne = new Pet("Sparky", "The Dog");
		Pet petTwo = new Pet("Gracie", "The Snuggly");
		Pet petThree = new Pet("Scottie", "The Parrot");
		
		PetDaoImpl petDaoImpl = new PetDaoImpl();
//		petDaoImpl.insertPet(petOne);
//		petDaoImpl.insertPet(petTwo);
//		petDaoImpl.insertPet(petThree);
		
		//System.out.println(petDaoImpl.selectAllPets());
		//System.out.println(petDaoImpl.selectPetByName("Gracie"));
		
//		
//		petOne.setType("The Pupper");
//		petDaoImpl.updatePet(petOne);
//		System.out.println(petDaoImpl.selectPetByName("Sparky"));
		
		petDaoImpl.deletePet(petThree);
		System.out.println(petDaoImpl.selectAllPets());
		
		
	}

}
