package com.espace.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.espace.model.SalesPipeLine;

public interface SalesPipeLineDao {

//	public String addSalesPipeLine(String customerName,Double estimatedFloorBuiltupArea,Double estimatedFloorCarpetArea,Double estimatedRackBuiltupArea,Double estimatedRackCarpetArea,String estimatedStartDate,String allocatedWarehouse,String statusWork,Double actualFloorBuiltupArea,Double actualFloorCarpetArea,Double actualRackBuiltupArea,Double actualRackCarpetArea,String actualStartDate,String remark);
	
	public String addSalesPipeLine(String customerName,Integer estimatedFloorBuiltupArea,Integer estimatedFloorCarpetArea,Integer estimatedRackBuiltupArea,Integer estimatedRackCarpetArea,Date estimatedStartDate,Double estimatedRevenue,String allocatedWarehouse,String statusWork);

	public String updateSalesPipeLine(Integer salesPipeLineId,String customerName,Integer availableFloor,Integer availableRack,Integer estimatedFloorBuiltupArea,Integer estimatedFloorCarpetArea,Integer estimatedRackBuiltupArea,Integer estimatedRackCarpetArea,Date estimatedStartDate,Double estimatedRevenue,String allocatedWarehouse,String statusWork,Integer actualFloorBuiltupArea,Integer actualFloorCarpetArea,Integer actualRackBuiltupArea,Integer actualRackCarpetArea,Date actualStartDate,Double actualRevenue,String remark);

	public String deleteSalesPipeLine(Integer salesPipeLineId,Integer warehouseId,Integer estimatedFloorCarpetArea);
	
	public List<SalesPipeLine> ageReportController();

	public List<SalesPipeLine> areaReportController();

	public List<SalesPipeLine> clientReportController();

	public List<SalesPipeLine> listSalesPipeLine();
	
	public List<String> chartSalesPipeLine();
	
	public HashMap<String, String> getSalesPipeLineDetailsById(Integer salesPipeLineId);

	public String getCustomerNameById(Integer salesPipeLineId);
}
