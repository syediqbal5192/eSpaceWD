package com.espace.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_module")
public class CustomerEntity {

	Integer customer_id;
	String customer_name;
	String contact_name_1;
	String contact_number_1;
	String contact_email_1;
	String contact_name_2;
	String contact_number_2;
	String contact_email_2;
	String isActive;
	String isDeleted;
	
	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerEntity(String customer_name, String contact_name_1, String contact_number_1, String contact_email_1,
			String contact_name_2, String contact_number_2, String contact_email_2,String isActive, String isDeleted) {
		super();
		this.customer_name = customer_name;
		this.contact_name_1 = contact_name_1;
		this.contact_number_1 = contact_number_1;
		this.contact_email_1 = contact_email_1;
		this.contact_name_2 = contact_name_2;
		this.contact_number_2 = contact_number_2;
		this.contact_email_2 = contact_email_2;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	@Column(name = "customer_name")
	public String getCustomer_name() {
		return customer_name;
	}

	
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	@Column(name = "contact_name_1")
	public String getContact_name_1() {
		return contact_name_1;
	}

	public void setContact_name_1(String contact_name_1) {
		this.contact_name_1 = contact_name_1;
	}

	@Column(name = "contact_number_1")
	public String getContact_number_1() {
		return contact_number_1;
	}

	public void setContact_number_1(String contact_number_1) {
		this.contact_number_1 = contact_number_1;
	}

	@Column(name = "contact_email_1")
	public String getContact_email_1() {
		return contact_email_1;
	}

	public void setContact_email_1(String contact_email_1) {
		this.contact_email_1 = contact_email_1;
	}

	@Column(name = "contact_name_2")
	public String getContact_name_2() {
		return contact_name_2;
	}

	public void setContact_name_2(String contact_name_2) {
		this.contact_name_2 = contact_name_2;
	}

	@Column(name = "contact_number_2")
	public String getContact_number_2() {
		return contact_number_2;
	}

	public void setContact_number_2(String contact_number_2) {
		this.contact_number_2 = contact_number_2;
	}

	@Column(name = "contact_email_2")
	public String getContact_email_2() {
		return contact_email_2;
	}

	public void setContact_email_2(String contact_email_2) {
		this.contact_email_2 = contact_email_2;
	}

	@Column(name = "isActive")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Column(name = "isDeleted")
	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
	
}
