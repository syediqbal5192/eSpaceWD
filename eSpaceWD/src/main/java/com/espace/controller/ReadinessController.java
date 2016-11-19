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

import com.espace.model.Readiness;
import com.espace.model.Warehouse;
import com.espace.service.ReadinessManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class ReadinessController {

	@Autowired
	ReadinessManager readinessManager;
	
	
	@RequestMapping(value="/addReadinessElement",method=RequestMethod.POST)
	public @ResponseBody String addWarehouse(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		
	    String readinessElementName=nvl(request.getParameter("readinessElementName"));
		
		
		String readinessElementStatus= readinessManager.addReadiness(readinessElementName);
			
		return readinessElementStatus;
		
	}
	
	@RequestMapping(value="/deleteReadinessById",method=RequestMethod.POST)
	public @ResponseBody String deleteWarehouseById(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		
		Integer readinessId = Integer.parseInt(nvl(request.getParameter("re_id")));
			
		String status=readinessManager.deleteReadiness(readinessId);
		
		
		
		return status;
		
	}
	
	
	
	@RequestMapping(value="/updateReadiness",method=RequestMethod.POST)
	public @ResponseBody String doPersonalityUpdateM(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		
		Integer readinessId = Integer.parseInt(nvl(request.getParameter("readinessId")));
		String readinessElementName=nvl(request.getParameter("readinessElementName"));
		
		String status= readinessManager.updateWarehouse(readinessId, readinessElementName);
		
		
		
		return status;
		
	}
	
	
	
	@RequestMapping(value="/listReadinessElements",method=RequestMethod.GET)
	public @ResponseBody String getWarehousesList(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		List<Readiness> readinessArrayList=new ArrayList<Readiness>();
		readinessArrayList = readinessManager.listReadinessElements(); 
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(readinessArrayList);
		return json;
	}
	
	
	
@RequestMapping(value="/getReadinessDetailsById",method=RequestMethod.POST)
	public @ResponseBody String getWarehouseDetailsById(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		String json;
	
        Integer readinessId= Integer.parseInt(nvl(request.getParameter("readinessId")));
		
		HashMap<String, String> file=readinessManager.getReadinessById(readinessId);
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    json = gson.toJson(file);
		return json;
		
	}
	
		
	public static String nvl(String str) {
        return (str == null) ? "" : str.trim();
    }
	
	
}
