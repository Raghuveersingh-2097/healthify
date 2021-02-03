package com.cg.healthify.menu;

import java.util.Scanner;

import com.cg.healthify.exceptions.CaloriesLogNotFoundException;
import com.cg.healthify.exceptions.NegativeIdEntryException;
import com.cg.healthify.exceptions.NegativeIdException;
import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.exceptions.PaymentAmountException;

public class MainMenu {
	Scanner sc=new Scanner(System.in);	
	String ContChoice;
	void menu(){
		System.out.println("1. ***--CUSTOMER--***");
		System.out.println("2. ***--DIET-PLAN--***");
		System.out.println("3. ***--NUTRITION-PLAN--***");
		System.out.println("4. ***--PAYMENT--***");
		System.out.println("5. ***--EXCERCISE PLAN--***");
		System.out.println("6. ***--WEIGHT-LOG--***");
		System.out.println("7. ***--CALORIES-LOG--***");
	}
	public void mainMenu() throws NegativeIdEntryException, CaloriesLogNotFoundException, NegativeIdException, NoRecordFoundException, PaymentAmountException{
		do {
			menu();
			System.out.println("Enter the Choice: ");
			int choice=sc.nextInt();
			switch(choice) {

			case 1:
				CustomerMenu cMenu=new CustomerMenu();
				cMenu.CustMenu();
				break;
			case 2:
			    DietMenu dMenu=new DietMenu();
				dMenu.dietMenu();
				break;
			case 3:
				NutritionMenu nMenu=new NutritionMenu();
				nMenu.nutritionMenu();
			case 4:
			    PaymentMenu pay=new PaymentMenu();
				 pay.payment_menu();
				break;
			case 5:
			     ExerciseMenu exc=new ExerciseMenu();
				exc.exerciseMenu();
				break;
			case 6:
				WeightLogMenu weg=new WeightLogMenu();
			        weg.weightLogMenu();
				break;
			case 7:
			   CaloriesLogMenu cal=new CaloriesLogMenu();
		         cal.caloriesMenu();
			default:
				System.out.println("--------------------WRONG-CHOICE--------------------");
				break;
			}System.out.println("Wants to Continue with main menu.");
			ContChoice=sc.next();
		}while(ContChoice.equalsIgnoreCase("Y"));
	}
}
