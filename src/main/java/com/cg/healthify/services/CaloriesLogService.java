package com.cg.healthify.services;

import java.util.List;

import com.cg.healthify.exceptions.CaloriesLogNotFoundException;
import com.cg.healthify.exceptions.NegativeIdEntryException;
import com.cg.healthify.pojo.CaloriesLog;


public interface CaloriesLogService {

	public CaloriesLog addCaloriesLog(CaloriesLog calories);

	public CaloriesLog updateCaloriesLog(CaloriesLog calories) throws  NegativeIdEntryException,CaloriesLogNotFoundException;

	public CaloriesLog deleteCaloriesLog(CaloriesLog calories);

	public List<CaloriesLog> findAll();
	
	public CaloriesLog getCaloriesById(int id) throws  NegativeIdEntryException,CaloriesLogNotFoundException;

}
