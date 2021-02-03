package com.cg.healthify.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cg.healthify.util.DBUtil;
import com.cg.healthify.daos.WeightLogDAOImpl;
import com.cg.healthify.pojo.WeightLog;
import com.cg.healthify.exceptions.InvalidIdException;


public class WeightLogServiceImpl extends DBUtil implements WeightLogService{



	WeightLogDAOImpl wdao=new WeightLogDAOImpl();


	@Override
	public WeightLog addWeightLog(WeightLog weightLog) {
		 EntityManager em=DBUtil.emf.createEntityManager();	
		wdao.addUserWeight(weightLog);
		return weightLog;

	}

	public WeightLog updateWeightLog(WeightLog weightLog) throws InvalidIdException {
		 EntityManager em=DBUtil.emf.createEntityManager();	

		int index=0;

		Query query =em.createQuery("from WeightLog");
		List<WeightLog> users =  query.getResultList();
		for (WeightLog user : users) 
		{

			if(user.getId()!=weightLog.getId())
			{
				index=1;

			}	
			else
			{
				index=2;
				break;
			}


		}

		if(index==1)
		{
			throw new InvalidIdException("Invalid Id");
		}
		else
		{
			wdao.updateUserWeight(weightLog);
		}

		return weightLog;

	}

	public WeightLog deleteWeightLog(WeightLog weightLog) throws InvalidIdException {
		int index=0;
		 EntityManager em=DBUtil.emf.createEntityManager();	
		Query query =em.createQuery("from WeightLog");
		List<WeightLog> users =  query.getResultList();
		for (WeightLog user : users) 
		{

			if(user.getId()!=weightLog.getId())
			{
				index=1;

			}	
			else
			{
				index=2;
				break;
			}


		}

		if(index==1)
		{
			throw new InvalidIdException("Invalid Id");
		}
		else
		{
			wdao.deleteUserWeight(weightLog);
		}

		return weightLog;	


	}

	@Override
	public WeightLog findWeightLog(WeightLog weightLog) throws InvalidIdException {

		 EntityManager em=DBUtil.emf.createEntityManager();	
		int index=0;

		Query query =em.createQuery("from WeightLog");
		List<WeightLog> users =  query.getResultList();
		for (WeightLog user : users) 
		{

			if(user.getId()!=weightLog.getId())
			{
				index=1;

			}	
			else
			{
				index=2;
				break;
			}


		}

		if(index==1)
		{
			throw new InvalidIdException("Invalid Id");
		}
		else
		{
			wdao.findUserWeight(weightLog);
		}

		return weightLog;

	}


}
