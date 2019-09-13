package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.FoodDao;
import com.example.model.Food;

@Controller
public class FoodController {
	
	@Autowired
	private FoodDao foodDao;
	
	@GetMapping("/food.app")
	public @ResponseBody Food findFood() {
		return foodDao.findByDishNameIgnoreCase("broCColi");
	}

}
