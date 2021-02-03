package com.cg.healthify.menu;

import java.util.Scanner;


import com.cg.healthify.pojo.DietPlan;
import com.cg.healthify.services.DietServiceImpl;

public class DietMenu {
	Scanner sc = new Scanner(System.in);
	String ContChoice;
	DietServiceImpl dietimpl = new DietServiceImpl();
	DietPlan diet = new DietPlan();

	void menu() {
		System.out.println("1. ADD DIET PLAN");
		System.out.println("2. UPDATE DIET PLAN");
		System.out.println("3. DELETE DIET PLAN");
		System.out.println("4. CHECK DIET PLAN");
		System.out.println("5. EXIT");
	}

	public void dietMenu() {

		do {
			System.out.println("Enter the Choice: ");
			menu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter DietID: ");
				diet.setId(sc.nextInt());
				System.out.println("Enter Slot: ");
				diet.setSlots(sc.next());
				System.out.println("Enter type of food you take: ");
				diet.setTypeOfFood(sc.next());
				dietimpl.addDiet(diet);
				break;
			case 2:
				System.out.println("Please Confirm your ID to update diet plan ");
				diet.setId(sc.nextInt());
				System.out.println("Enter New Slot");
				diet.setSlots(sc.next());
				dietimpl.updateDiet(diet);				
				break;
			case 3:
				System.out.println("Please Confirm your Id to remove your Diet plan: ");
				diet.setId(sc.nextInt());
				dietimpl.deleteDiet(diet);
				break;
			case 4:
				System.out.println("Please give your ID to get your diet details: ");
				diet.setId(sc.nextInt());
				int value = diet.getId();
				DietPlan dietPlanInfo = dietimpl.findDietData(value);
				if (dietPlanInfo != null && dietPlanInfo.getId() != 0) {
					System.out.println("DietID: " + dietPlanInfo.getId() + "\n" + "Slots: " + dietPlanInfo.getSlots()
							+ "\n" + "FOOD TYPE" + dietPlanInfo.getTypeOfFood() + "\n" + "PROTIEN RATIO"
							+ dietPlanInfo.getProteinRatio());
				} else {
					System.out.println("No Record Found");
				}
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("-------------------WRONG-CHOICE----------------------------");
				break;
			}
			System.out.println("Want to Continue with your Diet Plan Operation");
			ContChoice = sc.next();
		} while (ContChoice.equalsIgnoreCase("Y"));
	}
}