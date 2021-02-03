package com.cg.healthify.daos;

import javax.persistence.EntityManager;

import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.pojo.Customer;
import com.cg.healthify.pojo.DietPlan;
import com.cg.healthify.pojo.Login;
import com.cg.healthify.util.DBUtil;

public class DietDAOImpl implements DietDAO {

	public DietPlan saveDietPlan(DietPlan diet) {
		EntityManager em = DBUtil.emf.createEntityManager();
		diet = new DietPlan(diet.getId(), diet.getSlots(), diet.getTypeOfFood(), diet.getProteinRatio(),
				diet.getRatioOfFat(), diet.getRatioOfcarbs(), diet.getTotal());
		em.getTransaction().begin();
		em.persist(diet);
		System.out.println("Diet Plan Saved.");
		em.getTransaction().commit();
		return diet;
	}

	public DietPlan updateDietPlan(DietPlan diet) {
		EntityManager em = DBUtil.emf.createEntityManager();
		String newSlot = diet.getSlots();
		em.getTransaction().begin();
		diet = em.find(DietPlan.class, diet.getId());
		diet.setSlots(newSlot);
		em.persist(diet);
		System.out.println("Your diet plan is Updated...");
		em.getTransaction().commit();
		return diet;
	}

	public DietPlan removeDietPlan(DietPlan diet) {
		EntityManager em = DBUtil.emf.createEntityManager();
		diet = em.find(DietPlan.class, diet.getId());
		em.getTransaction().begin();
		em.remove(diet);
		System.out.println("Your Current Diet Plan is Removed");
		em.getTransaction().commit();
		return diet;
	}

	public DietPlan getCustomerDietPlan(int id) {
		EntityManager em = DBUtil.emf.createEntityManager();
		DietPlan dietPlanInfo = new DietPlan();
		dietPlanInfo = em.find(DietPlan.class, id);
		em.getTransaction().begin();
		em.getTransaction().commit();
		return dietPlanInfo;
	}

}