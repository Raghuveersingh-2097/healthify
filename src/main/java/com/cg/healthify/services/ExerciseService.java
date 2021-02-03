package com.cg.healthify.services;

import java.util.List;

import com.cg.healthify.exceptions.ExerciseNotFoundException;
import com.cg.healthify.exceptions.NegativeIdException;
import com.cg.healthify.pojo.Exercise;

/**
 * Business logic Interface
 * @Joel Jacob
 *
 */
public interface ExerciseService {
	
	public Exercise addExercise(Exercise exercise);

	public Exercise updateExercise(Exercise exercise) throws NegativeIdException,ExerciseNotFoundException;

	public Exercise deleteExercise(Exercise exercise);

	public List<Exercise> findAllExercises();
	
	public Exercise findExerciseById(int id) throws ExerciseNotFoundException, NegativeIdException;
	
	

}
