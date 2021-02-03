package com.cg.healthify.pojo;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity

public class WeightLog {
@Id

	private int id;
private double Weight;
private LocalDate created_At;
private LocalDate Updated_At;
private LocalTime createTime;
private LocalTime updateTime;
public WeightLog(int id, double weight, LocalDate created_At, LocalDate updated_At, LocalTime createTime,
		LocalTime updateTime) {
	super();
	this.id = id;
	this.Weight = weight;
	this.created_At = created_At;
	this.Updated_At = updated_At;
	this.createTime = createTime;
	this.updateTime = updateTime;
}
public WeightLog() {
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public double getWeight() {
	return Weight;
}
public void setWeight(double weight) {
	this.Weight = weight;
}
public LocalDate getCreated_At() {
	return created_At;
}
public void setCreated_At(LocalDate created_At) {
	this.created_At = created_At;
}
public LocalDate getUpdated_At() {
	return Updated_At;
}
public void setUpdated_At(LocalDate updated_At) {
	this.Updated_At = updated_At;
}
public LocalTime getCreateTime() {
	return createTime;
}
public void setCreateTime(LocalTime createTime) {
	this.createTime = createTime;
}
public LocalTime getUpdateTime() {
	return updateTime;
}
public void setUpdateTime(LocalTime updateTime) {
	this.updateTime = updateTime;
}




	
}
