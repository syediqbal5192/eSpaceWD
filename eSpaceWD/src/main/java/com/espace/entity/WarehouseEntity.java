package com.espace.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="warehouse_master")
public class WarehouseEntity {
	
	
	 
	 Integer warehouse_id;
	 
	 String warehouse_name;
	 
	 Integer floor_builtup_area;
	 
	 Integer floor_carpet_area;
	 
	 Integer rack_builtup_area; 
	 
	 Integer palette_positions;
	 
	 Integer available_floor_carpet_area;
	 
	 Integer available_rack_carpet_area;
	 
	 Integer total_docks;
	 
	 String isActive;
	 
	 String isDeleted;

	 
	 
	 
	public WarehouseEntity() {
		super();
	}

	public WarehouseEntity(String warehouse_name, Integer floor_builtup_area,
			Integer floor_carpet_area, Integer rack_builtup_area, Integer rack_carpet_area, Integer total_docks,String isActive,String isDeleted) {
		
		//this.warehouse_id = warehouse_id;
		this.warehouse_name = warehouse_name;
		this.floor_builtup_area = floor_builtup_area;
		this.floor_carpet_area = floor_carpet_area;
		this.rack_builtup_area = rack_builtup_area;
		this.palette_positions = palette_positions;
		this.total_docks = total_docks; 
		this.isActive = isActive;
		this.isDeleted = isDeleted;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "warehouse_id")
	public Integer getWarehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(Integer warehouse_id) {
		this.warehouse_id = warehouse_id;
	}
    
	@Column(name = "warehouse_name")
	public String getWarehouse_name() {
		return warehouse_name;
	}

	public void setWarehouse_name(String warehouse_name) {
		this.warehouse_name = warehouse_name;
	}

	@Column(name = "floor_builtup_area")
	public Integer getFloor_builtup_area() {
		return floor_builtup_area;
	}

	public void setFloor_builtup_area(Integer floor_builtup_area) {
		this.floor_builtup_area = floor_builtup_area;
	}

	@Column(name = "floor_carpet_area")
	public Integer getFloor_carpet_area() {
		return floor_carpet_area;
	}

	public void setFloor_carpet_area(Integer floor_carpet_area) {
		this.floor_carpet_area = floor_carpet_area;
	}

	@Column(name = "rack_builtup_area")
	public Integer getRack_builtup_area() {
		return rack_builtup_area;
	}

	public void setRack_builtup_area(Integer rack_builtup_area) {
		this.rack_builtup_area = rack_builtup_area;
	}

	@Column(name = "palette_positions")	
	public Integer getPalette_positions() {
		return palette_positions;
	}

	public void setPalette_positions(Integer palette_positions) {
		this.palette_positions = palette_positions;
	}

	@Column(name = "available_floor_carpet_area")
	public Integer getAvailable_floor_carpet_area() {
		return available_floor_carpet_area;
	}

	public void setAvailable_floor_carpet_area(Integer available_floor_carpet_area) {
		this.available_floor_carpet_area = available_floor_carpet_area;
	}

	@Column(name = "available_rack_carpet_area")
	public Integer getAvailable_rack_carpet_area() {
		return available_rack_carpet_area;
	}

	public void setAvailable_rack_carpet_area(Integer available_rack_carpet_area) {
		this.available_rack_carpet_area = available_rack_carpet_area;
	}

	@Column(name = "total_docks")
	public Integer getTotal_docks() {
		return total_docks;
	}

	public void setTotal_docks(Integer total_docks) {
		this.total_docks = total_docks;
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
