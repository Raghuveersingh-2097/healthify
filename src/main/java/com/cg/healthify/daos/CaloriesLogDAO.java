package com.cg.healthify.daos;

import java.util.List;


import com.cg.healthify.pojo.CaloriesLog;


public interface CaloriesLogDAO {

	/**
	 *  To save all the value to calories log.
	 */
	public CaloriesLog save(CaloriesLog calories);
	/**
	 * 	To update values for calories Log.
	 */ 
	public CaloriesLog update(CaloriesLog calories);
	/**
	   * 
	   * To delete your calories log.
	   */
	public CaloriesLog delete(CaloriesLog calories);
	/**
	*   To display the values in calories log.
	*/
	public List<CaloriesLog> findAll();
	
	/**
	 * Fetch the record from DB table based on the provided Id. 
	 * @return
	 * @throws NegativeIdException 
	 */
	public CaloriesLog findById(int id);
}
