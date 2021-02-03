package com.cg.healthify.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * The Exercises Table
 *
 */
@Entity
@Table(name = "exercises")
public class Exercise {
	/**
	 * Primary Key "Id" of Exercises Table
	 */
	@Id
	private int Id;
	/**
	 * exerciseType - a field of String data type
	 */
	private String exerciseType;
	/**
	 * exercisePlan - a field of String data type
	 */
	private String exercisePlan;
	
	/**
	 * Parameterized Constructor
	 * @param id
	 * @param exerciseType
	 * @param exercisePlan
	 */
	public Exercise(int id, String exerciseType, String exercisePlan) {
		super();
		this.Id = id;
		this.exerciseType = exerciseType;
		this.exercisePlan = exercisePlan;
	}
	
	/**
	 * No Argument Constructor
	 */
	public Exercise() {
		super();
		
	}

	/**
	 * Getters and Setters
	 */
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getExerciseType() {
		return exerciseType;
	}
	public void setExerciseType(String exerciseType) {
		this.exerciseType = exerciseType;
	}
	public String getExercisePlan() {
		return exercisePlan;
	}
	public void setExercisePlan(String exercisePlan) {
		this.exercisePlan = exercisePlan;
	}
	
	/**
	 * ToString Method
	 */
	@Override
	public String toString() {
		return "Exercise [Id=" + Id + ", exerciseType=" + exerciseType + ", exercisePlan=" + exercisePlan + "]";
	}
	
	
	
	
	
}
