package com.cg.healthify.services;

import com.cg.healthify.pojo.DietPlan;

public interface DietService {

	public DietPlan addDiet(DietPlan diet);

	public DietPlan updateDiet(DietPlan diet);

	public DietPlan deleteDiet(DietPlan diet);

	public DietPlan findDietData(int id);

}
