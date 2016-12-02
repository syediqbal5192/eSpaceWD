package com.espace.dao;

import java.util.HashMap;
import java.util.List;

import com.espace.model.Warehouse;

public interface WarehouseDao 
{

	public String addWarehouse(String warehouseName,Integer floorBuiltupArea,Integer floorCarpetArea,Integer rackBuiltupArea,Integer palette_positions,Integer totalNumberOfDocks);
	
	public String updateWarehouse(Integer warehouseId,String warehouseName,Integer floorBuiltupArea,Integer floorCarpetArea,Integer rackBuiltupArea,Integer palette_positions,Integer totalNumberOfDocks);

	public String deleteWarehouse(Integer warehouseId);
	
	public List<Warehouse> listWarehouse();
	

	public List<Warehouse> listWarehouseByActive();
	
	public List<Warehouse> listWarehouseById(Integer warehouseId);

	public List<Warehouse> listWarehouseDrillDown(String warehouseName);
	
	public List<Warehouse> getWarehouseAreaById(Integer warehouseId);
		
	public HashMap<String, String> getWarehousrDetailsByWHId(Integer warehouseId);
	
	public String updateSpaceAvialabilityWarehouse(Integer warehouseId,Integer avialableFloor, Integer availableRack);
	
	public HashMap<String, String> getDashboardIconInfo();
	
	public String getWarehouseName(Integer warehouseId);

}
