package com.cg.healthify.main;




import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.healthify.daos.ExerciseDAO;
import com.cg.healthify.daos.ExerciseDAOImpl;
import com.cg.healthify.exceptions.NegativeIdException;
import com.cg.healthify.exceptions.ExerciseNotFoundException;
import com.cg.healthify.pojo.Exercise;

import com.cg.healthify.services.ExerciseService;
import com.cg.healthify.services.ExerciseServiceImpl;


public class ExerciseTest {
	private static ExerciseService exerciseService;
	private static ExerciseDAO exerciseDAO;
	private Exercise exercise1,exercise2;

	@BeforeClass
	public static void setupTestEnv() {
		exerciseDAO = new ExerciseDAOImpl();
		exerciseService = new ExerciseServiceImpl();
	}

	@Before
	public void setUpTestMockData() {
		exercise1 = new Exercise(121,"Cardio","Burpees");
		exercise2 = new Exercise(101,"Strength","BenchPress");
	}
	
	


	@Test
	public void addExercisesTest() {
		Exercise exercise = exerciseService.addExercise(exercise1);
		assertEquals(exercise,exercise1);
	}
	
	/*@Test
	public void updateExerciseTest() throws ExerciseNotFoundException,NegativeIdException{
		Exercise exercise = exerciseService.updateExercise(exercise2);
		assertEquals(exercise,exercise2);
	}
	*/
	
	
	
	@After 
	public void tearDownTestMockData() {
		exerciseDAO.deleteExercise(exercise1);
	}
	
	@AfterClass
	public static  void tearDownTestEnv() {
		exerciseService = null;
		exerciseDAO= null;
	}

}
