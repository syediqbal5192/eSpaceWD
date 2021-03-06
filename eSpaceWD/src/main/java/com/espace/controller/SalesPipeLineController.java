package com.espace.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.espace.model.SalesPipeLine;
import com.espace.model.Warehouse;
import com.espace.service.SalesPipeLineManager;
import com.espace.service.WarehouseManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class SalesPipeLineController {


	@Autowired
	SalesPipeLineManager salesPipeLineManager;
	
	/*Adds New SalesPipeLine to Datatbase*/
	
	@RequestMapping(value="/addSalesPipeLine",method=RequestMethod.POST)
	public @ResponseBody String addWarehouse(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ParseException{
		
		String customerName = nvl(request.getParameter("customerName"));
		String customerType = nvl(request.getParameter("customerType"));
		Integer estimatedFloorBuiltupArea=Integer.parseInt(nvl(request.getParameter("estimatedFloorBuiltupArea")));
		Integer estimatedFloorCarpetArea=Integer.parseInt(nvl(request.getParameter("estimatedFloorCarpetArea")));
		Integer estimatedRackBuiltupArea=Integer.parseInt(nvl(request.getParameter("estimatedRackBuiltupArea")));
		Integer estimated_palette_positions=Integer.parseInt(nvl(request.getParameter("estimated_palette_positions")));
		String estimatedStartDate = nvl(request.getParameter("estimatedStartDate"));
		    DateFormat formatterStart = new SimpleDateFormat("yyyy-MM-dd");
		    Date startDate = formatterStart.parse(estimatedStartDate);
		Double estimatedRevenue = Double.parseDouble(nvl(request.getParameter("estimatedRevenue")));
		String allocatedWarehouse = nvl(request.getParameter("allocatedWarehouse"));
		String statusWork = nvl(request.getParameter("statusWork"));
		String remark = nvl(request.getParameter("remark"));
		
	
		String salesEntryStatus= salesPipeLineManager.addSalesPipeLine(customerName, customerType,estimatedFloorBuiltupArea, estimatedFloorCarpetArea, estimatedRackBuiltupArea, estimated_palette_positions, startDate, estimatedRevenue, allocatedWarehouse, statusWork,remark);
		return salesEntryStatus;
		
	}
	
	@RequestMapping(value="/updateSalesPipeLine",method=RequestMethod.POST)
	public @ResponseBody String getUpdateSalesPipeLine(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ParseException{
		
		Integer salesPipeLineId = Integer.parseInt(nvl(request.getParameter("salesPipeLineId")));
		String customerName = nvl(request.getParameter("customerName"));
		String customerType = nvl(request.getParameter("customerType"));
		Integer availableFloor=Integer.parseInt(nvl(request.getParameter("availableFloor")));
		Integer availableRack=Integer.parseInt(nvl(request.getParameter("availableCarpet")));
		Integer estimatedFloorBuiltupArea=Integer.parseInt(nvl(request.getParameter("estimatedFloorBuiltupArea")));
		Integer estimatedFloorCarpetArea=Integer.parseInt(nvl(request.getParameter("estimatedFloorCarpetArea")));
		Integer estimatedRackBuiltupArea=Integer.parseInt(nvl(request.getParameter("estimatedRackBuiltupArea")));
		Integer estimated_palette_positions=Integer.parseInt(nvl(request.getParameter("estimated_palette_positions")));
		String estimatedStartDate = nvl(request.getParameter("estimatedStartDate"));
		 DateFormat formatterStart3 = new SimpleDateFormat("yyyy-MM-dd");
		    Date startDate = formatterStart3.parse(estimatedStartDate);
		Double estimatedRevenue = Double.parseDouble(nvl(request.getParameter("estimatedRevenue")));    
		String allocatedWarehouse = nvl(request.getParameter("allocatedWarehouse"));
		String statusWork = nvl(request.getParameter("statusWork"));
		Integer actualFloorBuiltupArea=Integer.parseInt(nvl(request.getParameter("actualFloorBuiltupArea")));
		Integer actualFloorCarpetArea=Integer.parseInt(nvl(request.getParameter("actualFloorCarpetArea")));
		Integer actualFloorCarpetAreaRef=Integer.parseInt(nvl(request.getParameter("actualFloorCarpetAreaRef")));
		Integer actualRackBuiltupAreaRef=Integer.parseInt(nvl(request.getParameter("actualRackBuiltupAreaRef")));
		Integer actualRackBuiltupArea=Integer.parseInt(nvl(request.getParameter("actualRackBuiltupArea")));
		Integer actual_palette_positions=Integer.parseInt(nvl(request.getParameter("actual_palette_positions")));
		Double actualRevenue = Double.parseDouble(nvl(request.getParameter("actualRevenue")));
		String actualStartDate = nvl(request.getParameter("actualStartDate"));
		Date finalStartDate;
		if(actualStartDate.equals(""))
		{
			DateFormat formatterStart2 = new SimpleDateFormat("yyyy-MM-dd");
			finalStartDate = formatterStart2.parse("2016-01-01");
			
		}
		else
		{
			DateFormat formatterStart2 = new SimpleDateFormat("yyyy-MM-dd");
			finalStartDate = formatterStart2.parse(actualStartDate);
		}
		String remark = nvl(request.getParameter("remark"));
		
		
		String salesEntryUpdateStatus=salesPipeLineManager.updateSalesPipeLine(salesPipeLineId, customerName, customerType, availableFloor, availableRack, estimatedFloorBuiltupArea, estimatedFloorCarpetArea, estimatedRackBuiltupArea, estimated_palette_positions, startDate, estimatedRevenue, allocatedWarehouse, statusWork, actualFloorBuiltupArea, actualFloorCarpetArea, actualFloorCarpetAreaRef, actualRackBuiltupAreaRef, actualRackBuiltupArea, actual_palette_positions, finalStartDate, actualRevenue, remark);
		return salesEntryUpdateStatus;
		
	}
	
	
	

	@RequestMapping(value="/deleteSalesPipeLineById",method=RequestMethod.POST)
	public @ResponseBody String deleteSalesPipeLineById(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		
		Integer salesPipeLineId = Integer.parseInt(nvl(request.getParameter("salesPipeLineId")));
		Integer warehouseId = Integer.parseInt(nvl(request.getParameter("warehouseId")));
		Integer estimatedFloorCarpetArea = Integer.parseInt(nvl(request.getParameter("estimatedFloorCarpetArea")));
		Integer estimatedRackBuiltupArea = Integer.parseInt(nvl(request.getParameter("alertRackArea")));
		
		String status=salesPipeLineManager.deleteSalesPipeLine(salesPipeLineId, warehouseId, estimatedFloorCarpetArea,estimatedRackBuiltupArea);
		
		
		
		return status;
		
	}
	
	
	@RequestMapping(value="/listSalesPipeLine",method=RequestMethod.GET)
	public @ResponseBody String getSalesPipeLineList(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		List<SalesPipeLine> salesArrayList=new ArrayList<SalesPipeLine>();
		salesArrayList = salesPipeLineManager.listSalesPipeLine();
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(salesArrayList);
		return json;
	}
	
	@RequestMapping(value="/listSalesPipeLineById",method=RequestMethod.GET)
	public @ResponseBody String getSalesPipeLineListById(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		String status = nvl(request.getParameter("status"));
		
		List<SalesPipeLine> salesArrayList=new ArrayList<SalesPipeLine>();
		salesArrayList = salesPipeLineManager.listSalesPipeLineByStatus(status);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(salesArrayList);
		return json;
	}
	
	@RequestMapping(value="/ageReportController",method=RequestMethod.GET)
	public @ResponseBody String ageReportController(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		List<SalesPipeLine> salesArrayList=new ArrayList<SalesPipeLine>();
		String statusWorkCondition = nvl(request.getParameter("statusWorkCondition"));
		salesArrayList = salesPipeLineManager.ageReportController(statusWorkCondition);
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(salesArrayList);
		return json;
	}
	
	@RequestMapping(value="/areaReportController",method=RequestMethod.GET)
	public @ResponseBody String areaReportController(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		

		String clientStatusFilter = nvl(request.getParameter("clientStatusFilter"));
		
		List<SalesPipeLine> salesArrayList=new ArrayList<SalesPipeLine>();
		salesArrayList = salesPipeLineManager.areaReportController(clientStatusFilter);
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(salesArrayList);
		return json;
	}
	
	@RequestMapping(value="/clientReportController",method=RequestMethod.GET)
	public @ResponseBody String clientReportController(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		

		Integer clientWarehouseFilter = Integer.parseInt(nvl(request.getParameter("clientWarehouseFilter")));

		List<SalesPipeLine> salesArrayList=new ArrayList<SalesPipeLine>();
		salesArrayList = salesPipeLineManager.clientReportController(clientWarehouseFilter);
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(salesArrayList);
		return json;
	}
	
	@RequestMapping(value="/chartSalesPipeLine",method=RequestMethod.GET)
	public @ResponseBody String chartSalesPipeLine(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		List<String> salesArrayList=new ArrayList<String>();
		salesArrayList = salesPipeLineManager.chartSalesPipeLine();
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(salesArrayList);
		return json;
	}
	
	@RequestMapping(value="/getSalesPipeLineDetailsById",method=RequestMethod.POST)
	public @ResponseBody String getSalesPipeLineDetailsById(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		String json;
	
        Integer salesPipeLineId= Integer.parseInt(nvl(request.getParameter("salesPipeLineId")));
		
		HashMap<String, String> file=salesPipeLineManager.getSalesPipeLineDetailsById(salesPipeLineId);
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    json = gson.toJson(file);
		return json;
		
	}
	

	
	@RequestMapping(value="/getCustomerNameById",method=RequestMethod.GET)
	public @ResponseBody String getCustomerNameById(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		String json;
	
        Integer salesPipeLineId= Integer.parseInt(nvl(request.getParameter("salesPipeLineId")));
		
		String customerName=salesPipeLineManager.getCustomerNameById(salesPipeLineId);
	   
		return customerName;
		
		
		
		
	}
	
	

	@RequestMapping(value="/reloadFunctionality",method=RequestMethod.GET)
	public @ResponseBody String reloadFunctionality(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		
		return "reload";
	}
	
	@RequestMapping(value="/listSalesPipeLineSummary",method=RequestMethod.GET)
	public @ResponseBody String listWarehouseSummary(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		List<SalesPipeLine> salesPipeLineArrayList=new ArrayList<SalesPipeLine>();
		salesPipeLineArrayList = salesPipeLineManager.listSalesPipeLineSummary(); 
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(salesPipeLineArrayList);
		return json;
	}
	
	
	
	
	public static String nvl(String str) {
        return (str == null) ? "" : str.trim();
    }
	
	
	
}
