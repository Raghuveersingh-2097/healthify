package com.cg.healthify.pojo;

import javax.persistence.*;


@Entity
public class Login {
public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
private String password;
@Id	
 private int id;
}
