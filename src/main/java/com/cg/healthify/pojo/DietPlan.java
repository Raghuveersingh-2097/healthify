package com.cg.healthify.pojo;

import javax.persistence.Entity;


import javax.persistence.Id;

//import lombok.*;

@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class DietPlan {
	@Id
	private int id;
	private String slots;
	private String typeOfFood;
	private double proteinRatio;
	private double ratioOfFat;
	private double ratioOfcarbs;
	private double total;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSlots() {
		return slots;
	}
	public void setSlots(String slots) {
		this.slots = slots;
	}
	public String getTypeOfFood() {
		return typeOfFood;
	}
	public void setTypeOfFood(String typeOfFood) {
		this.typeOfFood = typeOfFood;
	}
	public double getProteinRatio() {
		return proteinRatio;
	}
	public void setProteinRatio(double proteinRatio) {
		this.proteinRatio = proteinRatio;
	}
	public double getRatioOfFat() {
		return ratioOfFat;
	}
	public void setRatioOfFat(double ratioOfFat) {
		this.ratioOfFat = ratioOfFat;
	}
	public double getRatioOfcarbs() {
		return ratioOfcarbs;
	}
	public void setRatioOfcarbs(double ratioOfcarbs) {
		this.ratioOfcarbs = ratioOfcarbs;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public DietPlan() {
		super();
	}
	public DietPlan(int id, String slots, String typeOfFood, double proteinRatio, double ratioOfFat,
			double ratioOfcarbs, double total) {
		super();
		this.id = id;
		this.slots = slots;
		this.typeOfFood = typeOfFood;
		this.proteinRatio = proteinRatio;
		this.ratioOfFat = ratioOfFat;
		this.ratioOfcarbs = ratioOfcarbs;
		this.total = total;
	}

}
