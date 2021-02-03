package com.cg.healthify.daos;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.Query;


import com.cg.healthify.pojo.Exercise;
import com.cg.healthify.util.DBUtil;


public class ExerciseDAOImpl implements ExerciseDAO {


	@Override
	public Exercise saveExercise(Exercise exercise) {
		EntityManager entityManager = DBUtil.emf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(exercise);
		entityManager.getTransaction().commit();
		entityManager.close();
		return exercise;
	}

	@Override
	public Exercise updateExercise(Exercise exercise) {
		EntityManager entityManager = DBUtil.emf.createEntityManager();
		String newType = exercise.getExerciseType();
		String newPlan = exercise.getExercisePlan();
		entityManager.getTransaction().begin();
		exercise = entityManager.find(Exercise.class, exercise.getId());
		exercise.setExerciseType(newType);
		exercise.setExercisePlan(newPlan);
		entityManager.persist(exercise);
		entityManager.getTransaction().commit();
		entityManager.close();
		return exercise;
	}

	@Override
	public Exercise deleteExercise(Exercise exercise) {
		EntityManager entityManager = DBUtil.emf.createEntityManager();
		entityManager.getTransaction().begin();
		exercise = entityManager.find(Exercise.class, exercise.getId());
		entityManager.remove(exercise);
		entityManager.getTransaction().commit();
		entityManager.close();
		return exercise;
	}

	@Override
	public List<Exercise> findAllExercises() {
		EntityManager entityManager =DBUtil.emf.createEntityManager();
		Query query=entityManager.createQuery("from Exercise");
		@SuppressWarnings("unchecked")
		List<Exercise> list=(List<Exercise>)query.getResultList();
		for(Exercise ex:list) {
			System.out.print("Exercise ID: "+ex.getId()+"\n");
			System.out.print("Exercise Type: "+ex.getExerciseType()+"\n");
			System.out.print("Exercise Plan: "+ex.getExercisePlan()+"\n");
			System.out.println("\n");
			
		}
		return list;
	}


	@Override
	public Exercise findByExerciseId(int id) {
		EntityManager entityManager = DBUtil.emf.createEntityManager();
		entityManager.getTransaction().begin();
		Exercise ex = entityManager.find(Exercise.class, id);
			if(ex!=null) {
				System.out.print("Exercise ID: "+ex.getId()+"\n");
				System.out.print("Exercise Type "+ex.getExerciseType()+"\n");
				System.out.print("Exercise Plan "+ex.getExercisePlan()+"\n");
				entityManager.getTransaction().commit();
				entityManager.close();
				return ex;
			}
			else 
				throw new NullPointerException();
		}

	}



