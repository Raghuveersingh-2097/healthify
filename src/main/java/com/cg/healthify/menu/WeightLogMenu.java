package com.cg.healthify.menu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import com.cg.healthify.pojo.WeightLog;
import com.cg.healthify.exceptions.InvalidIdException;
//import com.cg.healthify.services.PaymentServiceImpl;
import com.cg.healthify.services.WeightLogServiceImpl;

public class WeightLogMenu {
	Scanner sc=new Scanner(System.in);	
	String ContChoice;
	WeightLog weight=new WeightLog();
	WeightLogServiceImpl weg=new WeightLogServiceImpl();
	void menu() {
		System.out.println("1. ***--ADD WEIGHT LOG--***");
		System.out.println("2. ***--UPDATE WEIGHT LOG--***");
		System.out.println("3. ***--DELETE WEIGHT LOG--***");
		System.out.println("4. ***--FIND WEIGHT LOG--***");
		System.out.println("5. ***--EXIT--***");	
	}

	public void weightLogMenu(){
		//menu();
		do {
			System.out.println("Enter the Choice: ");
			menu();
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				 System.out.println("Enter your FitnessID: ");
				    weight.setId(sc.nextInt());
				    System.out.println("Enter your CurrentWeight: ");
				    weight.setWeight(sc.nextDouble());
				    LocalDate sdate=LocalDate.now();
					LocalDate udate=LocalDate.now();
					 LocalTime stime=LocalTime.now();
					 LocalTime dtime=LocalTime.now();
					weight.setCreated_At(sdate);
					weight.setUpdated_At(udate);
					weight.setCreateTime(dtime);
					weight.setUpdateTime(dtime);
				weg.addWeightLog(weight);
				break;
			case 2:
				System.out.println("Confirm your FitnessID to Update: ");
				weight.setId(sc.nextInt());
				System.out.println("Enter New Weight: ");
				weight.setWeight(sc.nextDouble());
				LocalDate udate1=LocalDate.now();
				LocalTime dtime1=LocalTime.now();
				weight.setUpdated_At(udate1);
				weight.setUpdateTime(dtime1);
				try {
					weg.updateWeightLog(weight);
				} catch (InvalidIdException e) {
					
					//e.printStackTrace();
					System.out.println("Invalid Id");
				}
				break;
			case 3:
				System.out.println("Confirm your FitnessID to delete your log: ");
				weight.setId(sc.nextInt());	
				try {
					weg.deleteWeightLog(weight);
				} catch (InvalidIdException e) {
					
					//e.printStackTrace();
					System.out.println("Invalid Id");
				}
				break;
			case 4:
				System.out.println("Confirm your FitnessID to find your log: ");
				weight.setId(sc.nextInt());	
				try {
					weg.findWeightLog(weight);
				} catch (InvalidIdException e) {
					
					//e.printMessage();
					System.out.println("Invalid Id");
				}
				break;
			case 5:
				System.out.println("Thank You .Visit Again");
				System.exit(0);
			}
			System.out.println("Wants to continue weightLog operation.");
			ContChoice=sc.next();
		}while(ContChoice.equalsIgnoreCase("Y"));
	}
}
