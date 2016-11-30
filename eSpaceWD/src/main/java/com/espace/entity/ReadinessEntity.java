package com.espace.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="readiness_element_details")
public class ReadinessEntity {

	Integer re_id;
	String readiness_element_name;
	String isActive;
	String isDeleted;
	public ReadinessEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReadinessEntity(String readiness_element_name, String isActive, String isDeleted) {
		super();
		
		this.readiness_element_name = readiness_element_name;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "re_id")
	public Integer getRe_id() {
		return re_id;
	}
	public void setRe_id(Integer re_id) {
		this.re_id = re_id;
	}
	
	@Column(name = "readiness_element_name")
	public String getReadiness_element_name() {
		return readiness_element_name;
	}
	public void setReadiness_element_name(String readiness_element_name) {
		this.readiness_element_name = readiness_element_name;
	}
	
	@Column(name = "isActive")
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	
	@Column(name = "isDeleted")
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
	
}
