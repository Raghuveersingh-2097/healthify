package com.cg.healthify.daos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.cg.healthify.pojo.Nutrition;
import com.cg.healthify.util.DBUtil;

public class NutritionDAOImpl implements NutritionDAO {

	@Override
	public Nutrition save(Nutrition nutritionPlan) {
		EntityManager em = DBUtil.emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(nutritionPlan);
		em.getTransaction().commit();
		em.close();
		return nutritionPlan;
	}

	@Override
	public List<Nutrition> findAll() {
		EntityManager em = DBUtil.emf.createEntityManager();
		Query query = em.createQuery("from Nutrition");
		@SuppressWarnings("unchecked")
		List<Nutrition> list = (List<Nutrition>) query.getResultList();
		for (Nutrition plan : list) {
			System.out.print("Nutrition Plan Id: " + plan.getId());
			System.out.print("---Nutrition Plan Name: " + plan.getName());
			System.out.print("---Nutrition Plan Description: " + plan.getPlanDescription());
			System.out.print("---Created date: " + plan.getCreatedAt());
			System.out.print("---Updated date: " + plan.getUpdatedAt());
			System.out.print("---Nutrition Plan Price: " + plan.getPrice());
			System.out.println("\n");

		}
		return list;
	}

	@Override
	public Nutrition update(Nutrition nutritionPlan) {
		EntityManager em = DBUtil.emf.createEntityManager();
		em.getTransaction().begin();
		String description = nutritionPlan.getPlanDescription();
		LocalDate update_date = nutritionPlan.getUpdatedAt();
		int price = nutritionPlan.getPrice();
		nutritionPlan = em.find(Nutrition.class, nutritionPlan.getId());
		nutritionPlan.setPlanDescription(description);
		nutritionPlan.setUpdatedAt(update_date);
		nutritionPlan.setPrice(price);
		em.persist(nutritionPlan);
		em.getTransaction().commit();
		em.close();
		return nutritionPlan;
	}

	@Override
	public Nutrition delete(Nutrition nutritionPlan) {
		EntityManager em = DBUtil.emf.createEntityManager();
		em.getTransaction().begin();
		nutritionPlan = em.find(Nutrition.class, nutritionPlan.getId());
		em.remove(nutritionPlan);
		em.getTransaction().commit();
		em.close();
		return nutritionPlan;
	}

	@Override
	public Nutrition findById(int id) {
		EntityManager em = DBUtil.emf.createEntityManager();
		em.getTransaction().begin();
		Nutrition plan = em.find(Nutrition.class, id);
		System.out.print("Nutrition Plan Id: " + plan.getId());
		System.out.print("---Nutrition Plan Name: " + plan.getName());
		System.out.print("---Nutrition Plan Description: " + plan.getPlanDescription());
		System.out.print("---Created date: " + plan.getCreatedAt());
		System.out.print("---Updated date: " + plan.getUpdatedAt());
		System.out.print("---Nutrition Plan Price: " + plan.getPrice());
		em.getTransaction().commit();
		em.close();
		return plan;

	}

}
