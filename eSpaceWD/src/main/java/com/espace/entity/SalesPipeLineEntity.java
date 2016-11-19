package com.espace.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salespipeline_master")
public class SalesPipeLineEntity {

	Integer salesPipeLineId;
	String customerName;
	Double estimatedFloorBuiltupArea;
	Double estimatedFloorCarpetArea;
	Double estimatedRackBuiltupArea;
	Double estimatedRackCarpetArea;
	Date estimatedStartDate ;
	Integer allocatedWarehouse ;
	String statusWork ;
	Double actualFloorBuiltupArea;
	Double actualFloorCarpetArea;
	Double actualRackBuiltupArea;
	Double actualRackCarpetArea;
	Date actualStartDate;
	String remark;
	Long age;
	String isActive;
	String isDeleted;
	Double expectedRevenue;
	Double actualRevenue;
	
	
	public SalesPipeLineEntity(String customerName, Double estimatedFloorBuiltupArea, Double estimatedFloorCarpetArea,
			Double estimatedRackBuiltupArea, Double estimatedRackCarpetArea, Date estimatedStartDate,
			Integer allocatedWarehouse, String statusWork, Double actualFloorBuiltupArea, Double actualFloorCarpetArea,
			Double actualRackBuiltupArea, Double actualRackCarpetArea, Date actualStartDate, String remark, Long age,
			String isActive, String isDeleted, Double expectedRevenue, Double actualRevenue) {
		super();
		this.customerName = customerName;
		this.estimatedFloorBuiltupArea = estimatedFloorBuiltupArea;
		this.estimatedFloorCarpetArea = estimatedFloorCarpetArea;
		this.estimatedRackBuiltupArea = estimatedRackBuiltupArea;
		this.estimatedRackCarpetArea = estimatedRackCarpetArea;
		this.estimatedStartDate = estimatedStartDate;
		this.allocatedWarehouse = allocatedWarehouse;
		this.statusWork = statusWork;
		this.actualFloorBuiltupArea = actualFloorBuiltupArea;
		this.actualFloorCarpetArea = actualFloorCarpetArea;
		this.actualRackBuiltupArea = actualRackBuiltupArea;
		this.actualRackCarpetArea = actualRackCarpetArea;
		this.actualStartDate = actualStartDate;
		this.remark = remark;
		this.age = age;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
		this.expectedRevenue = expectedRevenue;
		this.actualRevenue = actualRevenue;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sp_id")
	public Integer getSalesPipeLineId() {
		return salesPipeLineId;
	}
	public void setSalesPipeLineId(Integer salesPipeLineId) {
		this.salesPipeLineId = salesPipeLineId;
	}
	
	@Column(name = "customer_name")
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	@Column(name = "estimated_floor_builtup")
	public Double getEstimatedFloorBuiltupArea() {
		return estimatedFloorBuiltupArea;
	}
	public void setEstimatedFloorBuiltupArea(Double estimatedFloorBuiltupArea) {
		this.estimatedFloorBuiltupArea = estimatedFloorBuiltupArea;
	}
	
	@Column(name = "estimated_floor_carpet")
	public Double getEstimatedFloorCarpetArea() {
		return estimatedFloorCarpetArea;
	}
	public void setEstimatedFloorCarpetArea(Double estimatedFloorCarpetArea) {
		this.estimatedFloorCarpetArea = estimatedFloorCarpetArea;
	}
	
	@Column(name = "estimated_rack_builtup")
	public Double getEstimatedRackBuiltupArea() {
		return estimatedRackBuiltupArea;
	}
	public void setEstimatedRackBuiltupArea(Double estimatedRackBuiltupArea) {
		this.estimatedRackBuiltupArea = estimatedRackBuiltupArea;
	}
	
	@Column(name = "estimated_rack_carpet")
	public Double getEstimatedRackCarpetArea() {
		return estimatedRackCarpetArea;
	}
	public void setEstimatedRackCarpetArea(Double estimatedRackCarpetArea) {
		this.estimatedRackCarpetArea = estimatedRackCarpetArea;
	}
	
	@Column(name = "estimated_start_date")
	public Date getEstimatedStartDate() {
		return estimatedStartDate;
	}
	public void setEstimatedStartDate(Date estimatedStartDate) {
		this.estimatedStartDate = estimatedStartDate;
	}
	
	@Column(name = "warehouse_id")
	public Integer getAllocatedWarehouse() {
		return allocatedWarehouse;
	}
	public void setAllocatedWarehouse(Integer allocatedWarehouse) {
		this.allocatedWarehouse = allocatedWarehouse;
	}
	
	@Column(name = "status_id")
	public String getStatusWork() {
		return statusWork;
	}
	public void setStatusWork(String statusWork) {
		this.statusWork = statusWork;
	}
	
	@Column(name = "actual_floor_builtup")
	public Double getActualFloorBuiltupArea() {
		return actualFloorBuiltupArea;
	}
	public void setActualFloorBuiltupArea(Double actualFloorBuiltupArea) {
		this.actualFloorBuiltupArea = actualFloorBuiltupArea;
	}
	
	@Column(name = "actual_floor_carpet")
	public Double getActualFloorCarpetArea() {
		return actualFloorCarpetArea;
	}
	public void setActualFloorCarpetArea(Double actualFloorCarpetArea) {
		this.actualFloorCarpetArea = actualFloorCarpetArea;
	}
	
	@Column(name = "actual_rack_builtup")
	public Double getActualRackBuiltupArea() {
		return actualRackBuiltupArea;
	}
	public void setActualRackBuiltupArea(Double actualRackBuiltupArea) {
		this.actualRackBuiltupArea = actualRackBuiltupArea;
	}
	
	@Column(name = "actual_rack_carpet")
	public Double getActualRackCarpetArea() {
		return actualRackCarpetArea;
	}
	public void setActualRackCarpetArea(Double actualRackCarpetArea) {
		this.actualRackCarpetArea = actualRackCarpetArea;
	}
	
	@Column(name = "actual_start_date")
	public Date getActualStartDate() {
		return actualStartDate;
	}
	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}
	
	@Column(name = "remarks")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	
	
	@Column(name = "expectedRevenue")
	public Double getExpectedRevenue() {
		return expectedRevenue;
	}
	public void setExpectedRevenue(Double expectedRevenue) {
		this.expectedRevenue = expectedRevenue;
	}
	
	@Column(name = "actualRevenue")
	public Double getActualRevenue() {
		return actualRevenue;
	}
	public void setActualRevenue(Double actualRevenue) {
		this.actualRevenue = actualRevenue;
	}
	
	
	
	
	
}
