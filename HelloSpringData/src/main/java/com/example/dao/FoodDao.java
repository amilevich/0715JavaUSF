package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Food;

public interface FoodDao extends CrudRepository<Food, Integer>{
	
	public Food findByDishName(String dishName);
	
	public Food findByDishNameIgnoreCase(String dishName);

}
