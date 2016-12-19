package com.espace.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espace.dao.WarehouseDao;
import com.espace.model.Dashboard;
import com.espace.model.Warehouse;

@Service ("warehouseManager")
public class WarehouseManagerImpl implements WarehouseManager {

	@Autowired 
	WarehouseDao warehouseDao;
	
	
	public String addWarehouse(String warehouseName, Integer floorBuiltupArea, Integer floorCarpetArea,Integer rackBuiltupArea, Integer palette_positions ,Integer totalNumberOfDocks) {
		String warehouseStatus = warehouseDao.addWarehouse(warehouseName, floorBuiltupArea, floorCarpetArea, rackBuiltupArea, palette_positions, totalNumberOfDocks);
		
		return warehouseStatus;
	}

	public String updateWarehouse(Integer warehouseId,String warehouseName, Integer floorBuiltupArea, Integer floorCarpetArea, Integer rackBuiltupArea, Integer palette_positions,Integer totalNumberOfDocks,Integer availableWarehouseFloor, Integer availableWarehouseRack) {
     
		String warehouseStatus = warehouseDao.updateWarehouse(warehouseId, warehouseName, floorBuiltupArea, floorCarpetArea, rackBuiltupArea, palette_positions, totalNumberOfDocks,availableWarehouseFloor,availableWarehouseRack);
		return warehouseStatus;
	}


	public List<Warehouse> listWarehouse() {
		
		List<Warehouse> warehouseArrayList = warehouseDao.listWarehouse();
		
		return warehouseArrayList;
		
	}


	public HashMap<String, String> getWarehousrDetailsByWHId(Integer warehouseId) {
		
		HashMap<String, String> warehouseDetails = warehouseDao.getWarehousrDetailsByWHId(warehouseId);
		
		return warehouseDetails;
		
	}

	public List<Warehouse> getWarehouseAreaById(Integer warehouseId) {
	
	List<Warehouse> warehouseArrayList = warehouseDao.getWarehouseAreaById(warehouseId);
		
		return warehouseArrayList;
		
		
	}

	public List<Warehouse> listWarehouseById(Integer warehouseId) {
        
		List<Warehouse> warehouseArrayList = warehouseDao.listWarehouseById(warehouseId);
		
		return warehouseArrayList;
	}


public HashMap<String, String> getDashboardIconInfo() {
		
	HashMap<String, String> dashboardIconInfoList = warehouseDao.getDashboardIconInfo();
		
		return dashboardIconInfoList;
		
	}

public String deleteWarehouse(Integer warehouseId) {
	
	String warehouseStatus = warehouseDao.deleteWarehouse(warehouseId);
	return warehouseStatus;
	
}

public List<Warehouse> listWarehouseByActive() {
	List<Warehouse> dashboardIconInfoList = warehouseDao.listWarehouseByActive();
	
	return dashboardIconInfoList;
}

public List<Warehouse> listWarehouseDrillDown(String warehouseName) {
	
List<Warehouse> dashboardIconInfoList = warehouseDao.listWarehouseDrillDown(warehouseName);
	
	return dashboardIconInfoList;
}

public List<Warehouse> listWarehouseSummary() {
	
	
	List<Warehouse> warehouseArrayList = warehouseDao.listWarehouseSummary();
	
	return warehouseArrayList;
	
	
}


}
