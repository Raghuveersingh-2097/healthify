package com.cg.healthify.pojo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
	@Id
	/*
	 * This represents id of payment 
	 */
	private int id;
	/*
	 * This represents amount of payment 
	 */
	private double payment;
	/*
	 * This represents discount amount of payment 
	 */
	private double discount;
	/*
	 * This represents date of payment 
	 */
	private String created_At;
	
	private String planCategory;
	
	private double payableAmount;

	
	public Payment(int id, double payment, double discount, String created_At, String planCategory,
			double payableAmount) {
		super();
		this.id = id;
		this.payment = payment;
		this.discount = discount;
		this.created_At = created_At;
		this.planCategory = planCategory;
		this.payableAmount = payableAmount;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getCreated_At() {
		return created_At;
	}

	public void setCreated_At(String created_At) {
		this.created_At = created_At;
	}

	public String getPlanCategory() {
		return planCategory;
	}

	public void setPlanCategory(String planCategory) {
		this.planCategory = planCategory;
	}

	public double getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(double payableAmount) {
		this.payableAmount = payableAmount;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", payment=" + payment + ", discount=" + discount + ", created_At=" + created_At
				+ ", planCategory=" + planCategory + ", payableAmount=" + payableAmount + "]";
	}
	
	
	
	
}