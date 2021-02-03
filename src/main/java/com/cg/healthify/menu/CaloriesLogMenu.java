package com.cg.healthify.menu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import com.cg.healthify.exceptions.CaloriesLogNotFoundException;
import com.cg.healthify.exceptions.NegativeIdEntryException;
import com.cg.healthify.pojo.CaloriesLog;
import com.cg.healthify.services.CaloriesLogServiceImpl;


public class CaloriesLogMenu {
public void caloriesMenu() throws NegativeIdEntryException, CaloriesLogNotFoundException{
		
		CaloriesLogServiceImpl calserviceImpl=new CaloriesLogServiceImpl();
		CaloriesLog calories = new CaloriesLog();
		int choice;
		String continueChoice;
		Scanner sc = new Scanner(System.in);
		do {
			showMenu();
			System.out.println("Enter Your Choice :");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("----Enter details----");

				System.out.println("Enter your user Id : ");
				calories.setId(sc.nextInt());
				sc.nextLine();
				System.out.println("Enter your Calories : ");
				calories.setCalories(sc.nextDouble());
				sc.nextLine();
				calories.setCreatedAt(LocalDate.now());
				calories.setUpdatedAt(LocalDate.now());
				calories.setUpdateTime(LocalTime.now());
				calories.setCreateTime(LocalTime.now());	
				calserviceImpl.addCaloriesLog(calories);
				System.out.println("---Calories Added Successfully ---");
				break;
			case 2:
				System.out.println("---Enter details to Update---");
				System.out.println("Enter your user Id : ");
				calories.setId(sc.nextInt());
				sc.nextLine();
				calories.setCreatedAt(LocalDate.now());
				calories.setUpdatedAt(LocalDate.now());
				calories.setUpdateTime(LocalTime.now());
				calories.setCreateTime(LocalTime.now());	
				calserviceImpl.updateCaloriesLog(calories);
				System.out.println("----Calories Log Updated Successfully----");
				break;
			case 3:
				System.out.println("---Enter user Id to Delete---");
				System.out.println("Enter your user Id : ");
				calories.setId(sc.nextInt());
				sc.nextLine();
				calserviceImpl.deleteCaloriesLog(calories);
				System.out.println("----Calories Log deleted Successfully----");
				break;
			case 4:
				System.out.println("----All Calories Log---");
				calserviceImpl.findAll();
				System.out.println("-------------------------");
				break;
			case 0:
				System.out.println("-----Thanks! visit again-----");
				System.exit(0);

				
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
			System.out.println("Do you want to continue : [yes/no]");
			continueChoice = sc.next();
		} while (continueChoice.equalsIgnoreCase("yes"));
		System.out.println("----Thanks! visit again----");
	}

	static void showMenu() {
		System.out.println("---------Calories Log Menu-----------");
		System.out.println("1. Add Calories Log");
		System.out.println("2. Update Calories Log");
		System.out.println("3. Delete Calories Log");
		System.out.println("4. Show All Calories Log");
		System.out.println("0. Exit");
		System.out.println("---------------------------------------");
	}
}
