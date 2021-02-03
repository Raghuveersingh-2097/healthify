package com.cg.healthify.pojo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Nutrition {
	/**
	 * Id of the Nutrition Plan.
	 */
	@Id
	private int id;
	/**
	 *  Name of the Nutrition plan.
	 */
	private String  name;
	/**
	 * Description of the Nutrition plan.
	 */
	private String planDescription;
	/**
	 * Date of creation of Nutrition plan.
	 */
	private LocalDate createdAt;
	/**
	 * Date of updation of Nutrition plan.
	 */
	private LocalDate updatedAt;
	/**
	 * Price of Nutrition plan.
	 */
	private int price;
	
	
	public Nutrition() {
		super();
	}
	public Nutrition(int id, String name, String planDescription, LocalDate createdAt, LocalDate updatedAt, int price) {
		super();
		this.id = id;
		this.name = name;
		this.planDescription = planDescription;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlanDescription() {
		return planDescription;
	}
	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDate getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((planDescription == null) ? 0 : planDescription.hashCode());
		result = prime * result + price;
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nutrition other = (Nutrition) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (planDescription == null) {
			if (other.planDescription != null)
				return false;
		} else if (!planDescription.equals(other.planDescription))
			return false;
		if (price != other.price)
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NutritionPlan [id=" + id + ", name=" + name + ", plandescription=" + planDescription + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", price=" + price + "]";
	}
	
	

	
	
	

}
