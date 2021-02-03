package com.cg.healthify.daos;

import java.util.List;

import com.cg.healthify.exceptions.NegativeIdException;
import com.cg.healthify.pojo.Exercise;


public interface ExerciseDAO {
	/**
	 * A method for creating Exercises
	 * @param exercise
	 * @return
	 */
	public Exercise saveExercise(Exercise exercise);
	
	/**
	 * A method for updating Exercises
	 * @param exercise
	 * @return
	 */
	public Exercise updateExercise(Exercise exercise);
	
	/**
	 * A method for deleting Exercises
	 * @param exercise
	 * @return
	 */
	public Exercise deleteExercise(Exercise exercise);
	
	/**
	 * A method for Viewing all Exercises
	 * @return
	 */
	public List<Exercise> findAllExercises();

	/**
	 * A method for finding Exercise details by Exercise ID
	 * @param id
	 * @return
	 * @throws NullPointerException
	 * @throws NegativeIdException
	 */
	public Exercise findByExerciseId(int id);



}
