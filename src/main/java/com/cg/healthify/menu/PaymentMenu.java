package com.cg.healthify.menu;

import java.util.Scanner;

import com.cg.healthify.constants.PaymentConstants;
import com.cg.healthify.exceptions.NegativeIdException;
import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.exceptions.PaymentAmountException;
import com.cg.healthify.pojo.Login;
import com.cg.healthify.pojo.Payment;
import com.cg.healthify.services.PaymentServiceImpl;

public class PaymentMenu {
	Scanner sc = new Scanner(System.in);
	String ContChoice;
	Payment payment = new Payment();
	Login login = new Login();
	PaymentServiceImpl pay = new PaymentServiceImpl();

	void menu() {
		System.out.println("1. MAKE PAYMENT ");
		System.out.println("2. UPDATE PAYMENT DETAILS");
		System.out.println("3. DELETE PAYMENT DETAILS");
		System.out.println("4. FIND PAYMENT DETAILS");
		System.out.println("5. EXIT");
	}

	public void payment_menu() throws NoRecordFoundException, NegativeIdException, PaymentAmountException {
		// menu();
		do {
			System.out.println("Enter the Choice: ");
			menu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter your PAYID: ");
				payment.setId(sc.nextInt());
				login.setId(payment.getId());
				System.out.println("Enter your Payment");
				payment.setPayment(sc.nextDouble());
				System.out.println("Enter your payment Gateway: ");
				payment.setPlanCategory(sc.next());
				System.out.println("Enter Date of payment: ");
				payment.setCreated_At(sc.next());
				if (payment.getPlanCategory().equalsIgnoreCase("UPI")) {
					payment.setDiscount(PaymentConstants.gold);
				} else if (payment.getPlanCategory().equalsIgnoreCase("CARD")) {
					payment.setDiscount(PaymentConstants.platinum);
				} else {
					payment.setDiscount(PaymentConstants.silver);
				}
				double netPay = payment.getPayment() - ((payment.getPayment() * payment.getDiscount()) / 100);
				pay.addPayment(payment);
				break;
			case 2:
				System.out.println("Enter the PAYID to Update payment details: ");
				payment.setId(sc.nextInt());
				System.out.println("Enter your new payment gateway");
				payment.setPlanCategory(sc.next());
				System.out.println("Enter your new payment");
				payment.setPayment(sc.nextDouble());

				if (payment.getPlanCategory().equalsIgnoreCase("UPI")) {
					payment.setDiscount(PaymentConstants.gold);
				} else if (payment.getPlanCategory().equalsIgnoreCase("CARD")) {
					payment.setDiscount(PaymentConstants.platinum);
				} else {
					payment.setDiscount(PaymentConstants.silver);
				}
				double netPay1 = payment.getPayment() - ((payment.getPayment() * payment.getDiscount()) / 100);
				payment.setPayableAmount(netPay1);
				pay.updatePayment(payment);
				break;
			case 3:
				System.out.println("Please confirm your PAYID to delete your payment details.");
				payment.setId(sc.nextInt());
				System.out.println(payment.getPlanCategory());
				String n = payment.getPlanCategory();
				pay.deletePayment(payment.getId());
				break;
			case 4:
				System.out.println("Enter your PAYID to fetch your Details: ");
				payment.setId(sc.nextInt());
				int value = payment.getId();
				pay.FindPayment(value);
				break;
			case 5:
				System.exit(0);
				break;
			}
			System.out.println("Want to Continue as user.");
			ContChoice = sc.next();
		} while (ContChoice.equalsIgnoreCase("Y"));
	}

}
