package com.cg.healthify.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.healthify.daos.ExerciseDAO;
import com.cg.healthify.daos.ExerciseDAOImpl;
import com.cg.healthify.exceptions.ExerciseNotFoundException;
import com.cg.healthify.exceptions.NegativeIdException;
import com.cg.healthify.pojo.Exercise;
import com.cg.healthify.util.DBUtil;

public class ExerciseServiceImpl implements ExerciseService {
	//private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nutritionapp");

	private ExerciseDAO exerciseDAO;

	public ExerciseServiceImpl() {
		exerciseDAO = new ExerciseDAOImpl();

	}
	@Override
	public Exercise addExercise(Exercise exercise) {
		exerciseDAO.saveExercise(exercise);
		return exercise;
	}

	@Override
	public Exercise updateExercise(Exercise exercise) throws NegativeIdException, ExerciseNotFoundException {
		EntityManager entityManager = DBUtil.emf.createEntityManager();
		entityManager.getTransaction().begin();
		Exercise ex=entityManager.find(Exercise.class, exercise.getId());
		if(exercise.getId()<0) {
			throw new NegativeIdException();
		}
		else if(ex!=null) {
			exerciseDAO.updateExercise(exercise);
			return exercise;
		}
		else {
			throw new ExerciseNotFoundException();
		}
	}

	@Override
	public Exercise deleteExercise(Exercise exercise) {
		exerciseDAO.deleteExercise(exercise);
		return exercise;
	}

	@Override
	public List<Exercise> findAllExercises() {
		exerciseDAO.findAllExercises();
		return null;
	}

	@Override
	public Exercise findExerciseById(int id) throws ExerciseNotFoundException, NegativeIdException {
		EntityManager entityManager = DBUtil.emf.createEntityManager();
		entityManager.getTransaction().begin();
		Exercise exercise = entityManager.find(Exercise.class, id);
		if(id<0) {
			throw new NegativeIdException();
		}
		else if(exercise!=null) {
			exercise=exerciseDAO.findByExerciseId(id);
			return exercise;
		}
		else {
			Exercise ex=exerciseDAO.findByExerciseId(id);
			return ex;
		}
	}


}


