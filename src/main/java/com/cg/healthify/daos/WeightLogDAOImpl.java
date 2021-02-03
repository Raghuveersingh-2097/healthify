package com.cg.healthify.daos;

import java.time.*;

import javax.persistence.EntityManager;

import com.cg.healthify.util.DBUtil;
//import com.cg.healthify.domain.CaloriesLogInfo;
import com.cg.healthify.pojo.WeightLog;



public class WeightLogDAOImpl extends DBUtil implements WeightLogDAO{

	@Override
	public WeightLog addUserWeight(WeightLog weg) {
		EntityManager em=DBUtil.emf.createEntityManager();
	//	 weg=new WeightLogInfo(weg.getWeight(),weg.getCreated_At(),weg.getUpdated_At(),weg.getCreateTime(),weg.getUpdateTime());
   weg=new WeightLog(weg.getId(),weg.getWeight(),weg.getCreated_At(),weg.getUpdated_At(),weg.getCreateTime(),weg.getUpdateTime());
    em.getTransaction().begin();
    System.out.println(weg.getId());
    em.persist(weg);
    System.out.println("Weight Log Added");
    em.getTransaction().commit();
	em.close();
	return weg;
		
	}

	@Override
	public WeightLog updateUserWeight(WeightLog weg) {
		EntityManager em=DBUtil.emf.createEntityManager();
		LocalDate newDate=weg.getUpdated_At();
		LocalTime newTime=weg.getUpdateTime();
		double newWeight=weg.getWeight();
		em.getTransaction().begin();
		weg=em.find(WeightLog.class, weg.getId());
		weg.setWeight(newWeight);
		weg.setUpdated_At(newDate);
		weg.setUpdateTime(newTime);
		System.out.println("Weight Log Updated At: "+weg.getUpdateTime());
		em.getTransaction().commit();
		em.close();
		return weg;
		
	}

	@Override
	public WeightLog deleteUserWeight(WeightLog weg) {
		EntityManager em=DBUtil.emf.createEntityManager();
		System.out.print(weg.getId());
		weg=em.find(WeightLog.class, weg.getId());
		em.getTransaction().begin();
		em.remove(weg);
		System.out.print(weg);
		System.out.println("Your Log is deleted");
		em.getTransaction().commit();
		em.close();
		return weg;
	}

	@Override
	public WeightLog findUserWeight(WeightLog weg) {
		EntityManager em=DBUtil.emf.createEntityManager();
		weg=em.find(WeightLog.class, weg.getId());
		em.getTransaction().begin();
		System.out.println("ID: "+weg.getId()+"\nWeight Log: "+weg.getWeight()+"\nCreate Date: "+weg.getCreated_At()+"\nCreate Time"+weg.getCreateTime());
		System.out.println("Update Date: "+weg.getUpdated_At()+"\nUpdate Time: "+weg.getUpdateTime());
		em.getTransaction().commit();
em.close();
return weg;
	}

}
