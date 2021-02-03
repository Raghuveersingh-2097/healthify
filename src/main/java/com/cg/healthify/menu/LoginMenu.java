package com.cg.healthify.menu;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cg.healthify.exceptions.CaloriesLogNotFoundException;
import com.cg.healthify.exceptions.NegativeIdEntryException;
import com.cg.healthify.exceptions.NegativeIdException;
import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.exceptions.PaymentAmountException;
import com.cg.healthify.pojo.Login;
import com.cg.healthify.services.CustomerServiceImpl;
import com.cg.healthify.util.DBUtil;

public class LoginMenu {
	CustomerServiceImpl custimpl =new CustomerServiceImpl();
	CustomerMenu cMenu=new CustomerMenu();
	Scanner sc=new Scanner(System.in);	
	String ContChoice;
	void menu() {
		System.out.println("1. NEW USER");
		System.out.println("2. EXISTING USER");
	}
	public void loginMenu() throws NegativeIdEntryException, CaloriesLogNotFoundException, NegativeIdException, NoRecordFoundException, PaymentAmountException{
		do {
			menu();
			System.out.println("Enter the Choice: ");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				cMenu.add();
				break;
			case 2:
				//	custimpl.loginAuthentication();
				EntityManager em=DBUtil.emf.createEntityManager();
				System.out.println("Enter your ID:");
				int ini=sc.nextInt();
				System.out.println("Enter Password:");
				String password=sc.next();
				int io=0;

				Query query=em.createQuery("from Login");
				List<Login> loginm= query.getResultList();
				for(Login i:loginm) {
					if(i.getId()==ini && i.getPassword().equals(password)) {
						io++;
						break;
					}
				}
				if(io==0) {
					System.out.println("Invalid User!!");
				}
				else {
					MainMenu mains=new MainMenu();
					mains.mainMenu();		  
				}
				break;
			default:
				System.exit(0);
				break;
			}System.out.println("Wants to Continue with login menu.");
			ContChoice=sc.next();
		}while(ContChoice.equalsIgnoreCase("Y"));
	}
}