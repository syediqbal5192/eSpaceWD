package com.espace.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espace.dao.SalesPipeLineDao;
import com.espace.dao.SalesPipeLineDaoImpl;
import com.espace.model.SalesPipeLine;

@Service ("salesPipeLineManager")
public class SalesPipeLineManagerImpl implements SalesPipeLineManager {

	@Autowired
	SalesPipeLineDao salesPipeLineDao;
	
	public String addSalesPipeLine(String customerName, String customerType,Integer estimatedFloorBuiltupArea,
			Integer estimatedFloorCarpetArea, Integer estimatedRackBuiltupArea, Integer estimatedRackCarpetArea,
			Date estimatedStartDate,Double estimatedRevenue, String allocatedWarehouse, String statusWork,String remarks) {
		
	//	String salesEntryStatus = salesPipeLineDao.addSalesPipeLine(customerName, estimatedFloorBuiltupArea, estimatedFloorCarpetArea, estimatedRackBuiltupArea, estimatedRackCarpetArea, estimatedStartDate, allocatedWarehouse, statusWork, actualFloorBuiltupArea, actualFloorCarpetArea, actualRackBuiltupArea, actualRackCarpetArea, actualStartDate, remark);
	
		String salesEntryStatus = salesPipeLineDao.addSalesPipeLine(customerName, customerType,estimatedFloorBuiltupArea, estimatedFloorCarpetArea, estimatedRackBuiltupArea, estimatedRackCarpetArea, estimatedStartDate, estimatedRevenue, allocatedWarehouse, statusWork,remarks);
		return salesEntryStatus;
		
	}

	public String updateSalesPipeLine(Integer salesPipeLineId, String customerName, String customerType,Integer availableFloor,Integer availableRack,Integer estimatedFloorBuiltupArea,
			Integer estimatedFloorCarpetArea, Integer estimatedRackBuiltupArea, Integer estimated_palette_positions,
			Date estimatedStartDate, Double estimatedRevenue,String allocatedWarehouse, String statusWork, Integer actualFloorBuiltupArea,
			Integer actualFloorCarpetArea, Integer actualFloorCarpetAreaRef,Integer actualRackBuiltupAreaRef,Integer actualRackBuiltupArea, Integer actual_palette_positions,
			Date actualStartDate,Double actualRevenue, String remark) {
		
		String salesEntryUpdateStatus = salesPipeLineDao.updateSalesPipeLine(salesPipeLineId, customerName, customerType, availableFloor, availableRack, estimatedFloorBuiltupArea, estimatedFloorCarpetArea, estimatedRackBuiltupArea, estimated_palette_positions, estimatedStartDate, estimatedRevenue, allocatedWarehouse, statusWork, actualFloorBuiltupArea, actualFloorCarpetArea, actualFloorCarpetAreaRef, actualRackBuiltupAreaRef, actualRackBuiltupArea, actual_palette_positions, actualStartDate, actualRevenue, remark);
				return salesEntryUpdateStatus;
	}


	public List<SalesPipeLine> listSalesPipeLine() {
		
		List<SalesPipeLine> salesArrayList = salesPipeLineDao.listSalesPipeLine();
		
		return salesArrayList;
		
		
	}


	public HashMap<String, String> getSalesPipeLineDetailsById(Integer salesPipeLineId) {
		
		

		HashMap<String, String> salesPipeLineDetails = salesPipeLineDao.getSalesPipeLineDetailsById(salesPipeLineId);
		
		return salesPipeLineDetails;
		
		
	}


	public String getCustomerNameById(Integer salesPipeLineId) {
		
        String customerName = salesPipeLineDao.getCustomerNameById(salesPipeLineId);
		
		return customerName;
		
		
	}

	public String deleteSalesPipeLine(Integer salesPipeLineId,Integer warehouseId,Integer estimatedFloorCarpetArea, Integer estimatedRackBuiltupArea) {
		
		String warehouseStatus = salesPipeLineDao.deleteSalesPipeLine(salesPipeLineId, warehouseId, estimatedFloorCarpetArea,estimatedRackBuiltupArea);
		return warehouseStatus;
		
	}


	public List<SalesPipeLine> ageReportController(String statusWorkCondition) {
		
        List<SalesPipeLine> salesArrayList = salesPipeLineDao.ageReportController(statusWorkCondition);
		
		return salesArrayList;
		
	}
	
public List<SalesPipeLine> areaReportController(String clientStatusFilter) {
		
        List<SalesPipeLine> salesArrayList = salesPipeLineDao.areaReportController(clientStatusFilter);
		
		return salesArrayList;
		
	}
	
public List<String> chartSalesPipeLine() {
		
        List<String> warehouseNameList = salesPipeLineDao.chartSalesPipeLine();
		
		return warehouseNameList;
		
	}


public List<SalesPipeLine> clientReportController(Integer clientWarehouseFilter) {
	
    List<SalesPipeLine> salesArrayList = salesPipeLineDao.clientReportController(clientWarehouseFilter);
	
		return salesArrayList;
	
}

public List<SalesPipeLine> listSalesPipeLineByStatus(String customerName) {
	
	  List<SalesPipeLine> salesArrayList = salesPipeLineDao.listSalesPipeLineByStatus(customerName);
		
			return salesArrayList;
}
	
	
	
}
