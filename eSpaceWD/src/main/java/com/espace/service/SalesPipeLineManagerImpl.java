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
	
	
	public String addSalesPipeLine(String customerName, Integer estimatedFloorBuiltupArea,
			Integer estimatedFloorCarpetArea, Integer estimatedRackBuiltupArea, Integer estimatedRackCarpetArea,
			Date estimatedStartDate,Double estimatedRevenue, String allocatedWarehouse, String statusWork) {
		
	//	String salesEntryStatus = salesPipeLineDao.addSalesPipeLine(customerName, estimatedFloorBuiltupArea, estimatedFloorCarpetArea, estimatedRackBuiltupArea, estimatedRackCarpetArea, estimatedStartDate, allocatedWarehouse, statusWork, actualFloorBuiltupArea, actualFloorCarpetArea, actualRackBuiltupArea, actualRackCarpetArea, actualStartDate, remark);
	
		String salesEntryStatus = salesPipeLineDao.addSalesPipeLine(customerName, estimatedFloorBuiltupArea, estimatedFloorCarpetArea, estimatedRackBuiltupArea, estimatedRackCarpetArea, estimatedStartDate, estimatedRevenue, allocatedWarehouse, statusWork);
		return salesEntryStatus;
		
	}


	public String updateSalesPipeLine(Integer salesPipeLineId, String customerName, Integer availableFloor,Integer availableRack,Integer estimatedFloorBuiltupArea,
			Integer estimatedFloorCarpetArea, Integer estimatedRackBuiltupArea, Integer estimatedRackCarpetArea,
			Date estimatedStartDate, Double estimatedRevenue,String allocatedWarehouse, String statusWork, Integer actualFloorBuiltupArea,
			Integer actualFloorCarpetArea, Integer actualRackBuiltupArea, Integer actualRackCarpetArea,
			Date actualStartDate,Double actualRevenue, String remark) {
		
		String salesEntryUpdateStatus = salesPipeLineDao.updateSalesPipeLine(salesPipeLineId, customerName, availableFloor, availableRack, estimatedFloorBuiltupArea, estimatedFloorCarpetArea, estimatedRackBuiltupArea, estimatedRackCarpetArea, estimatedStartDate, estimatedRevenue, allocatedWarehouse, statusWork, actualFloorBuiltupArea, actualFloorCarpetArea, actualRackBuiltupArea, actualRackCarpetArea, actualStartDate, actualRevenue, remark);
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

	public String deleteSalesPipeLine(Integer salesPipeLineId,Integer warehouseId,Integer estimatedFloorCarpetArea) {
		
		String warehouseStatus = salesPipeLineDao.deleteSalesPipeLine(salesPipeLineId, warehouseId, estimatedFloorCarpetArea);
		return warehouseStatus;
		
	}


	public List<SalesPipeLine> ageReportController() {
		
        List<SalesPipeLine> salesArrayList = salesPipeLineDao.ageReportController();
		
		return salesArrayList;
		
	}
	
public List<SalesPipeLine> areaReportController() {
		
        List<SalesPipeLine> salesArrayList = salesPipeLineDao.areaReportController();
		
		return salesArrayList;
		
	}
	
public List<String> chartSalesPipeLine() {
		
        List<String> warehouseNameList = salesPipeLineDao.chartSalesPipeLine();
		
		return warehouseNameList;
		
	}


public List<SalesPipeLine> clientReportController() {
	
    List<SalesPipeLine> salesArrayList = salesPipeLineDao.clientReportController();
	
		return salesArrayList;
	
}
	
	
	
}
