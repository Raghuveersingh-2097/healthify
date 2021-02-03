package com.cg.healthify.exceptions;

public class ExerciseNotFoundException extends RuntimeException{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExerciseNotFoundException(String errMsg){
			super(errMsg);
		}
	 public ExerciseNotFoundException(){
			super();
		}
}
