package com.espace.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_master")
public class UserMasterEntity {

	
	Integer user_id;
	String full_name;
	String email_id;
	String password;
	String designation_name;
	public UserMasterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserMasterEntity(String full_name, String email_id, String password, String designation_name) {
		super();
		this.full_name = full_name;
		this.email_id = email_id;
		this.password = password;
		this.designation_name = designation_name;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	@Column(name = "full_name")
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	
	@Column(name = "email_id")
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "designation_name")
	public String getDesignation_name() {
		return designation_name;
	}
	public void setDesignation_name(String designation_name) {
		this.designation_name = designation_name;
	}
	
	
	
	
}
