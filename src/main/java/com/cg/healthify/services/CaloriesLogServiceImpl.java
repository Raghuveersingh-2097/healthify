package com.cg.healthify.services;

import java.util.List;

import javax.persistence.EntityManager;

import com.cg.healthify.daos.CaloriesLogDAO;
import com.cg.healthify.daos.CaloriesLogDAOImpl;
import com.cg.healthify.exceptions.CaloriesLogNotFoundException;
import com.cg.healthify.exceptions.NegativeIdEntryException;
import com.cg.healthify.pojo.CaloriesLog;

import com.cg.healthify.util.DBUtil;



public class CaloriesLogServiceImpl extends DBUtil implements CaloriesLogService {
public CaloriesLogDAO calorieslogDAO;
	
	public CaloriesLogServiceImpl() {
		calorieslogDAO=new CaloriesLogDAOImpl();
	}
	
	@Override
	public CaloriesLog addCaloriesLog(CaloriesLog calories) {
		return calorieslogDAO.save(calories);
		
	}

	@Override
	public CaloriesLog updateCaloriesLog(CaloriesLog calories) throws NegativeIdEntryException,CaloriesLogNotFoundException {
		EntityManager em=DBUtil.emf.createEntityManager();
		em.getTransaction().begin();
		CaloriesLog log=em.find(CaloriesLog.class, calories.getId());
		if(calories.getId()<0) {
			throw new NegativeIdEntryException();
		}
		else if(log!=null) {
			calorieslogDAO.update(calories);
			return calories;
		}
		else {
			throw new CaloriesLogNotFoundException();
		}
		
	}

	@Override
	public CaloriesLog deleteCaloriesLog(CaloriesLog calories) {
		return calorieslogDAO.delete(calories);
		
	}

	@Override
	public List<CaloriesLog> findAll() {
		return calorieslogDAO.findAll();
		
	}
	
	@Override
	public CaloriesLog getCaloriesById(int id) throws  NegativeIdEntryException,CaloriesLogNotFoundException {
		EntityManager em=DBUtil.emf.createEntityManager();
		em.getTransaction().begin();
		CaloriesLog  log=em.find(CaloriesLog .class, id);
		if(id<0) {
			throw new NegativeIdEntryException();
		}
		else if(log!=null) {
			log=calorieslogDAO.findById(id);
			return log;
		}
		else {
			throw new CaloriesLogNotFoundException();
		}
		
	}

	
}
