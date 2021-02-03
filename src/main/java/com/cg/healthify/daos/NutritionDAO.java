package com.cg.healthify.daos;

import java.util.List;


import com.cg.healthify.pojo.Nutrition;


public interface NutritionDAO {

	/**
	 * Save method is used to insert the records in DB table.
	 * @param nutritionPlan
	 * @return
	 */
	public Nutrition save(Nutrition nutritionPlan);
	/**
	 * findall method used to fetch all the records of DB table. 
	 * @return
	 */
	public List<Nutrition> findAll();
	/**
	 * update method is used to update the records in the DB table. 
	 * @param nutritionPlan
	 * @return
	 */
	public Nutrition update(Nutrition nutritionPlan);
	/**
	 * delete method is used to delete the records in the DB table. 
	 * @param nutritionPlan
	 * @return
	 */
	public Nutrition delete(Nutrition nutritionPlan);
	/**
	 * Fetch the record from DB table based on the provided Id. 
	 * @return
	 */
	public Nutrition findById(int id);
}
