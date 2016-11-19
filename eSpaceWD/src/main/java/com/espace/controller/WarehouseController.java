package com.espace.controller;

import java.util.ArrayList;
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

import com.espace.service.WarehouseManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.espace.model.Dashboard;
import com.espace.model.Warehouse;

@Controller
public class WarehouseController {

	@Autowired
	WarehouseManager warehouseManager;
	
	
	/*Adds New Warehouse to Datatbase*/
	
	@RequestMapping(value="/addWarehouse",method=RequestMethod.POST)
	public @ResponseBody String addWarehouse(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		
	    String warehouseName=nvl(request.getParameter("warehouseName"));
	    Integer floorBuiltupArea=Integer.parseInt(nvl(request.getParameter("floorBuiltupArea")));
	    Integer floorCarpetArea=Integer.parseInt(nvl(request.getParameter("floorCarpetArea")));
	    Integer rackBuiltupArea=Integer.parseInt(nvl(request.getParameter("rackBuiltupArea")));
	    Integer rackCarpetArea=Integer.parseInt(nvl(request.getParameter("rackCarpetArea")));
		Integer totalNumberOfDocks=Integer.parseInt(nvl(request.getParameter("totalNumberOfDocks")));
				
		String warehouseStatus= warehouseManager.addWarehouse(warehouseName, floorBuiltupArea, floorCarpetArea, rackBuiltupArea, rackCarpetArea,totalNumberOfDocks);
		
	/*	List file=profile.getProfileDataUsingUserId(userId);
		
		String nameMain=(String) file.get(0); 
		String bioDescpOP=(String) file.get(1);
		String gender=(String) file.get(2); 
		String seekingOP=(String) file.get(3);
    	request.setAttribute("MainName", nameMain);
		request.setAttribute("bioDescpOP", bioDescpOP); 
    	request.setAttribute("gender", gender);
		request.setAttribute("seeking", seekingOP);*/
	
       /* JSONObject profileDetailsJson =new JSONObject();
		profileDetailsJson.put("firstName",(String)file.get(0));
        profileDetailsJson.put("bioDescp", (String) file.get(1));
        profileDetailsJson.put("dateOfBirth",(String) file.get(2));
        profileDetailsJson.put("age",(String) file.get(3));
        profileDetailsJson.put("i_am",(String) file.get(4));
        profileDetailsJson.put("seeking",(String) file.get(5));
        profileDetailsJson.put("hobbies",(String) file.get(6));*/
		
		return warehouseStatus;
		
	}
	
	
	@RequestMapping(value="/updateWarehouse",method=RequestMethod.POST)
	public @ResponseBody String doPersonalityUpdateM(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		
		Integer warehouseId = Integer.parseInt(nvl(request.getParameter("warehouseId")));
		String warehouseName=nvl(request.getParameter("warehouseName"));
	    Integer floorBuiltupArea=Integer.parseInt(nvl(request.getParameter("floorBuiltupArea")));
	    Integer floorCarpetArea=Integer.parseInt(nvl(request.getParameter("floorCarpetArea")));
	    Integer rackBuiltupArea=Integer.parseInt(nvl(request.getParameter("rackBuiltupArea")));
	    Integer rackCarpetArea=Integer.parseInt(nvl(request.getParameter("rackCarpetArea")));
		Integer totalNumberOfDocks = Integer.parseInt(nvl(request.getParameter("totalNumberOfDocks")));
	
		
		String status=warehouseManager.updateWarehouse(warehouseId, warehouseName, floorBuiltupArea, floorCarpetArea, rackBuiltupArea, rackCarpetArea, totalNumberOfDocks);
		
		
		
		return status;
		
	}
	
	
	
	@RequestMapping(value="/deleteWarehouseById",method=RequestMethod.POST)
	public @ResponseBody String deleteWarehouseById(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		
		Integer warehouseId = Integer.parseInt(nvl(request.getParameter("warehouseId")));
			
		String status=warehouseManager.deleteWarehouse(warehouseId);
		
		
		
		return status;
		
	}
	
	
	
	
	@RequestMapping(value="/listWarehouse",method=RequestMethod.GET)
	public @ResponseBody String getWarehousesList(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		List<Warehouse> warehouseArrayList=new ArrayList<Warehouse>();
		warehouseArrayList = warehouseManager.listWarehouse(); 
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(warehouseArrayList);
		return json;
	}
	
	

	@RequestMapping(value="/listWarehouseByActive",method=RequestMethod.GET)
	public @ResponseBody String getListWarehouseByActive(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		List<Warehouse> warehouseArrayList=new ArrayList<Warehouse>();
		 warehouseArrayList= warehouseManager.listWarehouseByActive(); 
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(warehouseArrayList);
		return json;
	}
	
	@RequestMapping(value="/listWarehouseDrillDown",method=RequestMethod.GET)
	public @ResponseBody String getListWarehouseDrillDown(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		String warehouseName = nvl(request.getParameter("warehouseName"));
		List<Warehouse> warehouseArrayList=new ArrayList<Warehouse>();
		warehouseArrayList = warehouseManager.listWarehouseDrillDown(warehouseName);
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(warehouseArrayList);
		return json;
	}
	
	@RequestMapping(value="/listWarehouseById",method=RequestMethod.GET)
	public @ResponseBody String getWarehousesListById(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		Integer warehouseId = Integer.parseInt(nvl(request.getParameter("warehouseId")));
		List<Warehouse> warehouseArrayList=new ArrayList<Warehouse>();
		warehouseArrayList = warehouseManager.listWarehouseById(warehouseId);
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(warehouseArrayList);
		return json;
	}
	
	
	@RequestMapping(value="/getWarehouseAreaById",method=RequestMethod.GET)
	public @ResponseBody String getWarehouseAreaById(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		Integer warehouseId = Integer.parseInt(nvl(request.getParameter("selectedWarehouseId"))); 
		
		List<Warehouse> warehouseArrayList=new ArrayList<Warehouse>();
		warehouseArrayList = warehouseManager.getWarehouseAreaById(warehouseId);
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(warehouseArrayList);
		return json;
	}
	
	
	
	@RequestMapping(value="/getWarehouseDetailsById",method=RequestMethod.POST)
	public @ResponseBody String getWarehouseDetailsById(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		String json;
	
        Integer warehouseId= Integer.parseInt(nvl(request.getParameter("warehouseId")));
		
		HashMap<String, String> file=warehouseManager.getWarehousrDetailsByWHId(warehouseId);
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    json = gson.toJson(file);
		return json;
		
	}
	
	
	@RequestMapping(value="/dashboardIconInfo",method=RequestMethod.POST)
	public @ResponseBody String getDashboardIconInfo(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		HashMap<String, String> dashboardIconInfoList = warehouseManager.getDashboardIconInfo();
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(dashboardIconInfoList);
		return json;
	}
		
	public static String nvl(String str) {
        return (str == null) ? "" : str.trim();
    }
	
}