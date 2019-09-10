package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FOOD")
public class Food {

	@Id
	@Column(name = "food_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodId;

	@Column(name = "dish_name", unique = true, nullable = false)
	private String dishName;

	@Column(name = "is_tasty", nullable = false)
	private Boolean isTasty;

	public Food() {
		// TODO Auto-generated constructor stub
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public Boolean getIsTasty() {
		return isTasty;
	}

	public void setIsTasty(Boolean isTasty) {
		this.isTasty = isTasty;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", dishName=" + dishName + ", isTasty=" + isTasty + "]";
	}

	public Food(int foodId, String dishName, Boolean isTasty) {
		super();
		this.foodId = foodId;
		this.dishName = dishName;
		this.isTasty = isTasty;
	}

	public Food(String dishName, Boolean isTasty) {
		super();
		this.dishName = dishName;
		this.isTasty = isTasty;
	}

}
