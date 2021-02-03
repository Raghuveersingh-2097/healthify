package com.cg.healthify.menu;

import java.util.Scanner;

import com.cg.healthify.exceptions.ExerciseNotFoundException;
import com.cg.healthify.exceptions.NegativeIdException;
import com.cg.healthify.pojo.Exercise;
import com.cg.healthify.services.ExerciseServiceImpl;

public class ExerciseMenu {
	public void exerciseMenu()throws NegativeIdException {
		ExerciseServiceImpl exerciseServiceImpl=new ExerciseServiceImpl();
		Exercise exercise = new Exercise();
		int choice;
		String continueChoice;
		Scanner sc = new Scanner(System.in);
		do {
			showMenu();
			System.out.println("Enter Your Choice");
			choice = sc.nextInt();
			switch (choice) {
			
			case 1:
				System.out.println("ADD EXERCISE");
				System.out.println("Enter Exercise ID: ");
				exercise.setId(sc.nextInt());
				System.out.println("Enter Exercise Type : ");
				exercise.setExerciseType(sc.next());
				System.out.println("Enter Exercise Plan : ");
				exercise.setExercisePlan(sc.next());
				exerciseServiceImpl.addExercise(exercise);
				System.out.println("EXERCISE ADDED SUCCESSFULLY");
				break;
				
			case 2:
				System.out.println("UPDATE EXERCISE");
				System.out.println("Enter Exercise Id: ");
				exercise.setId(sc.nextInt());
				System.out.println("Enter Exercise Plan to be Updated: ");
				exercise.setExercisePlan(sc.next());
				try {
					exerciseServiceImpl.updateExercise(exercise);
				}
				catch(ExerciseNotFoundException err) {
					err.printStackTrace();
				}
				catch(NegativeIdException err) {
					err.printStackTrace();
				}
				System.out.println("EXERCISE PLAN UPDATED");
				
				break;
				
			case 3:
				System.out.println("DELETING EXERCISE");
				System.out.println("Enter Exercise ID : ");
				exercise.setId(sc.nextInt());
				exerciseServiceImpl.deleteExercise(exercise);
				System.out.println("EXERCISE DELETED SUCCESSFULLY");
				break;
				
			case 4:
				System.out.println("DISPLAYING EXERCISES");
				exerciseServiceImpl.findAllExercises();
				break;
				
			case 5:
				System.out.println("EXERCISE DETAILS BY ID");
				System.out.println("Enter Exercise ID : ");
				int id=sc.nextInt();
				try {
					exerciseServiceImpl.findExerciseById(id);
				} catch (ExerciseNotFoundException err) {
					err.printStackTrace();
				} catch (NegativeIdException err) {
					err.printStackTrace();
				}
				break;	
				
			case 0:
				System.exit(0);
				break;
				
			default:
				System.out.println("Wrong Choice");
				break;
			}
			System.out.println("Do you want to continue : y/n");
			continueChoice = sc.next();
		} while (continueChoice.equalsIgnoreCase("y"));
		

		}
	private static void showMenu() {
		System.out.println("**EXERCISE MENU**");
		System.out.println("1. Add Exercise");
		System.out.println("2. Update Exercise");
		System.out.println("3. Delete Exercise");
		System.out.println("4. Display All Exercises");
		System.out.println("5. Display Ecercise By ID");
		System.out.println("0. Exit");
	}
}
