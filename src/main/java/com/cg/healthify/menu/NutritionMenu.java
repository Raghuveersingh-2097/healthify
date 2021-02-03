package com.cg.healthify.menu;

import java.time.LocalDate;
import java.util.Scanner;

import com.cg.healthify.exceptions.NegativeIdException;
import com.cg.healthify.exceptions.NutritionPlanDetailsNotFoundException;
import com.cg.healthify.pojo.Nutrition;
import com.cg.healthify.services.NutritionServiceImpl;


public class NutritionMenu {

	public void nutritionMenu() {
		NutritionServiceImpl nutriSerImpl=new NutritionServiceImpl();
		Nutrition nutritionPlan = new Nutrition();
		int choice;
		String continueChoice;
		Scanner sc = new Scanner(System.in);
		do {
			showMenu();
			System.out.println("Enter Your Choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("-------Please Provide below details---------");

				System.out.println("Enter Nutrition Plan Id : ");
				nutritionPlan.setId(sc.nextInt());
				sc.nextLine();
				System.out.println("Enter Nutrition Plan name : ");
				nutritionPlan.setName(sc.nextLine());
				sc.nextLine();
				System.out.println("Enter Nutrition Plan Description : ");
				nutritionPlan.setPlanDescription(sc.nextLine());
				sc.nextLine();
				nutritionPlan.setCreatedAt(LocalDate.now());
				nutritionPlan.setUpdatedAt(LocalDate.now());
				System.out.println("Enter Nutrition Plan Price : ");
				nutritionPlan.setPrice(sc.nextInt());
				
				nutriSerImpl.save(nutritionPlan);
				System.out.println("------------Nutrition Plan Added Successfully ------------");
				break;
			case 2:
				System.out.println("-------Please Provide below details to Update---------");
				System.out.println("Enter Nutrition Plan Id : ");
				nutritionPlan.setId(sc.nextInt());
				sc.nextLine();
				System.out.println("Enter Nutrition Plan Description to Update: ");
				nutritionPlan.setPlanDescription(sc.nextLine());
				sc.nextLine();
				nutritionPlan.setUpdatedAt(LocalDate.now());
				System.out.println("Enter Nutrition Plan Price to Update: ");
				nutritionPlan.setPrice(sc.nextInt());
				try {
					nutriSerImpl.update(nutritionPlan);
				} catch (NegativeIdException e1) {					
					e1.printStackTrace();
				} catch (NutritionPlanDetailsNotFoundException e1) {
					e1.printStackTrace();
				}

				System.out.println("-----------Nutrition Plan Updated Successfully-----------");

				break;
			case 3:
				System.out.println("-------Provide Nutrition Plan Id to Delete---------");
				System.out.println("Enter Nutrition Plan Id : ");
				nutritionPlan.setId(sc.nextInt());
				nutriSerImpl.delete(nutritionPlan);
				System.out.println("-------------Plan deleted Successfully------------");
				break;
			case 4:
				System.out.println("-------------All Nutrition Plans------------");
				nutriSerImpl.findAll();
				System.out.println("------------------------------------------------------------");
				break;
			case 5:
				System.out.println("-------------All Nutrition Plans------------");
				System.out.println("Enter Nutrition Plan Id : ");
				int id=sc.nextInt();
				try {
					nutriSerImpl.getNutritionPlanDetailsById(id);
				} catch (NutritionPlanDetailsNotFoundException e) {
					
					e.printStackTrace();
				} catch (NegativeIdException e) {
					
					e.printStackTrace();
				}
				
				System.out.println("------------------------------------------------------------");
				break;	
			case 0:
				System.out.println("---------------Thanks For Utilisig Nutrition App Services---------------");
				System.exit(0);
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
			System.out.println("Do you want to continue : [yes/no]");
			continueChoice = sc.next();
		} while (continueChoice.equalsIgnoreCase("yes"));
		System.out.println("---------------Thanks For Utilisig Nutrition App Services---------------");

		}
	private static void showMenu() {
		System.out.println("---------HealthyFy App Menu-----------");
		System.out.println("1. Add Nutrition Plan");
		System.out.println("2. Update Nutrition Plan");
		System.out.println("3. Delete Nutrition Plan");
		System.out.println("4. Display All Plans");
		System.out.println("5. Display Plan By Id");
		System.out.println("0. Exit");
	}
	}

