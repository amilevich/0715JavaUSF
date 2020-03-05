package com.example.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Food;

public interface FoodDao extends CrudRepository<Food, Integer>{
	
	public Food findByFoodId(Integer foodId);
	
	public List<Food> findAll();

}
