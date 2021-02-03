package com.cg.healthify.services;

import java.util.List;

import com.cg.healthify.exceptions.NegativeIdException;
import com.cg.healthify.exceptions.NutritionPlanDetailsNotFoundException;
import com.cg.healthify.pojo.Nutrition;

public interface NutritionService {

	public Nutrition save(Nutrition nutritionPlan);

	public List<Nutrition> findAll();
	
	public Nutrition update(Nutrition nutritionPlan) throws NegativeIdException,NutritionPlanDetailsNotFoundException ;

	public Nutrition delete(Nutrition nutritionPlan);

	public Nutrition getNutritionPlanDetailsById(int id) throws  NegativeIdException, NutritionPlanDetailsNotFoundException;

	

	

}
