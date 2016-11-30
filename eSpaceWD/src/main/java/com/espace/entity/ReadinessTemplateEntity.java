package com.espace.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="readiness_templateR")
public class ReadinessTemplateEntity {

	Integer rt_r;
	Integer sp_id;
	String company_name;
	Date start_end;
	Date end_date;
	String owner_name;
	String quantity;
	String readiness_element_status;
	String re_name;
	String isDeleted;
	public ReadinessTemplateEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReadinessTemplateEntity(Integer sp_id, String company_name, Date start_end, Date end_date, String owner_name,
			String quantity, String readiness_element_status, String re_name, String isDeleted) {
		super();
		this.sp_id = sp_id;
		this.company_name = company_name;
		this.start_end = start_end;
		this.end_date = end_date;
		this.owner_name = owner_name;
		this.quantity = quantity;
		this.readiness_element_status = readiness_element_status;
		this.re_name = re_name;
		this.isDeleted = isDeleted;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "re_id")
	public Integer getRt_r() {
		return rt_r;
	}
	public void setRt_r(Integer rt_r) {
		this.rt_r = rt_r;
	}
	
	@Column(name = "sp_id")
	public Integer getSp_id() {
		return sp_id;
	}
	public void setSp_id(Integer sp_id) {
		this.sp_id = sp_id;
	}
	
	@Column(name = "company_name")
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	
	@Column(name = "start_end")
	public Date getStart_end() {
		return start_end;
	}
	public void setStart_end(Date start_end) {
		this.start_end = start_end;
	}
	
	@Column(name = "end_date")
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	@Column(name = "owner_name")
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	
	@Column(name = "quantity")
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	@Column(name = "readiness_element_status")
	public String getReadiness_element_status() {
		return readiness_element_status;
	}
	public void setReadiness_element_status(String readiness_element_status) {
		this.readiness_element_status = readiness_element_status;
	}
	
	@Column(name = "re_name")
	public String getRe_name() {
		return re_name;
	}
	public void setRe_name(String re_name) {
		this.re_name = re_name;
	}
	
	@Column(name = "isDeleted")
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
	
	
	
	
}
