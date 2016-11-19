package com.espace.model;

import java.util.Date;

public class SalesPipeLine {

	
	Integer salesPipeLineId;
	String customerName;
	Integer estimatedFloorBuiltupArea;
	Integer estimatedFloorCarpetArea;
	Integer estimatedRackBuiltupArea;
	Integer estimatedRackCarpetArea;
	Date estimatedStartDate ;
	String allocatedWarehouse ;
	String statusWork ;
	Integer actualFloorBuiltupArea;
	Integer actualFloorCarpetArea;
	Integer actualRackBuiltupArea;
	Integer actualRackCarpetArea;
	Date actualStartDate;
	String remark;
	Long age;
	String isActive;
	String isDeleted;
	Integer expectedRevenue;
	Integer actualRevenue;
	
	
	Integer warehouseId;
	
	public Integer getSalesPipeLineId() {
		return salesPipeLineId;
	}
	public void setSalesPipeLineId(Integer salesPipeLineId) {
		this.salesPipeLineId = salesPipeLineId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getEstimatedFloorBuiltupArea() {
		return estimatedFloorBuiltupArea;
	}
	public void setEstimatedFloorBuiltupArea(Integer estimatedFloorBuiltupArea) {
		this.estimatedFloorBuiltupArea = estimatedFloorBuiltupArea;
	}
	public Integer getEstimatedFloorCarpetArea() {
		return estimatedFloorCarpetArea;
	}
	public void setEstimatedFloorCarpetArea(Integer estimatedFloorCarpetArea) {
		this.estimatedFloorCarpetArea = estimatedFloorCarpetArea;
	}
	public Integer getEstimatedRackBuiltupArea() {
		return estimatedRackBuiltupArea;
	}
	public void setEstimatedRackBuiltupArea(Integer estimatedRackBuiltupArea) {
		this.estimatedRackBuiltupArea = estimatedRackBuiltupArea;
	}
	public Integer getEstimatedRackCarpetArea() {
		return estimatedRackCarpetArea;
	}
	public void setEstimatedRackCarpetArea(Integer estimatedRackCarpetArea) {
		this.estimatedRackCarpetArea = estimatedRackCarpetArea;
	}
	public Date getEstimatedStartDate() {
		return estimatedStartDate;
	}
	public void setEstimatedStartDate(Date estimatedStartDate) {
		this.estimatedStartDate = estimatedStartDate;
	}
	public String getAllocatedWarehouse() {
		return allocatedWarehouse;
	}
	public void setAllocatedWarehouse(String allocatedWarehouse) {
		this.allocatedWarehouse = allocatedWarehouse;
	}
	public String getStatusWork() {
		return statusWork;
	}
	public void setStatusWork(String statusWork) {
		this.statusWork = statusWork;
	}
	public Integer getActualFloorBuiltupArea() {
		return actualFloorBuiltupArea;
	}
	public void setActualFloorBuiltupArea(Integer actualFloorBuiltupArea) {
		this.actualFloorBuiltupArea = actualFloorBuiltupArea;
	}
	public Integer getActualFloorCarpetArea() {
		return actualFloorCarpetArea;
	}
	public void setActualFloorCarpetArea(Integer actualFloorCarpetArea) {
		this.actualFloorCarpetArea = actualFloorCarpetArea;
	}
	public Integer getActualRackBuiltupArea() {
		return actualRackBuiltupArea;
	}
	public void setActualRackBuiltupArea(Integer actualRackBuiltupArea) {
		this.actualRackBuiltupArea = actualRackBuiltupArea;
	}
	public Integer getActualRackCarpetArea() {
		return actualRackCarpetArea;
	}
	public void setActualRackCarpetArea(Integer actualRackCarpetArea) {
		this.actualRackCarpetArea = actualRackCarpetArea;
	}
	public Date getActualStartDate() {
		return actualStartDate;
	}
	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public Integer getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Integer getExpectedRevenue() {
		return expectedRevenue;
	}
	public void setExpectedRevenue(Integer expectedRevenue) {
		this.expectedRevenue = expectedRevenue;
	}
	public Integer getActualRevenue() {
		return actualRevenue;
	}
	public void setActualRevenue(Integer actualRevenue) {
		this.actualRevenue = actualRevenue;
	}
	
	
	
	
}
