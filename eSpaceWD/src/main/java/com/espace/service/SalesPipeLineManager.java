package com.espace.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.espace.model.SalesPipeLine;



public interface SalesPipeLineManager {
	
	//public String addSalesPipeLine(String customerName,Double estimatedFloorBuiltupArea,Double estimatedFloorCarpetArea,Double estimatedRackBuiltupArea,Double estimatedRackCarpetArea,String estimatedStartDate,String allocatedWarehouse,String statusWork,Double actualFloorBuiltupArea,Double actualFloorCarpetArea,Double actualRackBuiltupArea,Double actualRackCarpetArea,String actualStartDate,String remark);

	public String addSalesPipeLine(String customerName,String customerType,Integer estimatedFloorBuiltupArea,Integer estimatedFloorCarpetArea,Integer estimatedRackBuiltupArea,Integer estimated_palette_positions,Date estimatedStartDate,Double estimatedRevenue,String allocatedWarehouse,String statusWork,String remarks);

	public String updateSalesPipeLine(Integer salesPipeLineId,String customerName,String customerType,Integer availableFloor,Integer availableRack,Integer estimatedFloorBuiltupArea,Integer estimatedFloorCarpetArea,Integer estimatedRackBuiltupArea,Integer estimated_palette_positions,Date estimatedStartDate,Double estimatedRevenue,String allocatedWarehouse,String statusWork,Integer actualFloorBuiltupArea,Integer actualFloorCarpetArea,Integer actualFloorCarpetAreaRef,Integer actualRackBuiltupAreaRef,Integer actualRackBuiltupArea,Integer actual_palette_positions,Date actualStartDate,Double actualRevenue,String remark);

	public String deleteSalesPipeLine(Integer salesPipeLineId,Integer warehouseId,Integer estimatedFloorCarpetArea, Integer estimatedRackBuiltupArea);

	public List<SalesPipeLine> listSalesPipeLine();

	public List<SalesPipeLine> listSalesPipeLineByStatus(String customerName);
	
	public List<String> chartSalesPipeLine();
	
	public List<SalesPipeLine> ageReportController(String statusWorkCondition);

	public List<SalesPipeLine> areaReportController(String clientStatusFilter);
	
	public List<SalesPipeLine> clientReportController(Integer clientWarehouseFilter);
	
	public HashMap<String, String> getSalesPipeLineDetailsById(Integer salesPipeLineId);
	
	public String getCustomerNameById(Integer salesPipeLineId);
}
