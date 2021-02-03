package com.cg.healthify.daos;

import com.cg.healthify.pojo.DietPlan;

import com.cg.healthify.pojo.Login;

public interface DietDAO {

	public DietPlan saveDietPlan(DietPlan diet);

	public DietPlan updateDietPlan(DietPlan diet);

	public DietPlan removeDietPlan(DietPlan diet);

	public DietPlan getCustomerDietPlan(int id);

}
