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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.espace.model.Readiness;
import com.espace.model.ReadinessTemplate;
import com.espace.model.ReadinessTemplateModel;
import com.espace.service.ReadinessManager;
import com.espace.service.ReadinessTemplateManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Controller
public class ReadinessTemplateController {


	@Autowired
	ReadinessTemplateManager readinessTemplateManager;

	@RequestMapping(value="/addReadinessTemplate",method=RequestMethod.POST)
	public @ResponseBody String addWarehouse(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ParseException{
		
	    String valueOfReadinessCompanyName=nvl(request.getParameter("valueOfReadinessCompanyName"));
	    Integer valueOfReadinessSalesPipeLineId=Integer.parseInt(nvl(request.getParameter("valueOfReadinessSalesPipeLineId")));
	    Integer valueOfReadinessId=Integer.parseInt(nvl(request.getParameter("valueOfReadinessId")));
	    Double valueOfReadinessQuantity=Double.parseDouble(nvl(request.getParameter("valueOfReadinessQuantity")));
	    String valueOfReadinessOwnerName=nvl(request.getParameter("valueOfReadinessOwnerName"));
	    String valueOfReadinessElementStatus=nvl(request.getParameter("valueOfReadinessElementStatus"));
	    String stringValueOfStartDate = nvl(request.getParameter("valueOfReadinessStartDate"));
	    DateFormat formatterStart = new SimpleDateFormat("dd-MM-yyyy");
	    Date startDate = formatterStart.parse(stringValueOfStartDate);
	    
	    String stringValueOfEndDate = nvl(request.getParameter("valueOfReadinessEndDate"));
	    DateFormat formatterEnd = new SimpleDateFormat("dd-MM-yyyy");
	    Date endDate = formatterEnd.parse(stringValueOfEndDate);
	    
	   
	    		String readinessElementStatus= readinessTemplateManager.addReadinessTemplate(valueOfReadinessCompanyName, valueOfReadinessSalesPipeLineId, valueOfReadinessId, valueOfReadinessQuantity, valueOfReadinessOwnerName, valueOfReadinessElementStatus, startDate, endDate);
			
		return readinessElementStatus;
		
	}
	
	
	@RequestMapping(value="/addReadinessTemplateBulk",method=RequestMethod.POST)
	public @ResponseBody String addReadinessTemplateBulk(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ParseException{
		
	    String valueOfReadinessCompanyName=nvl(request.getParameter("valueOfReadinessCompanyName"));
	    Integer valueOfReadinessSalesPipeLineId=Integer.parseInt(nvl(request.getParameter("valueOfReadinessSalesPipeLineId")));
	    String readinessArrayValue = request.getParameter("readinessArrayValue");
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    List<ReadinessTemplate> readinessList = gson.fromJson(readinessArrayValue, new TypeToken<List<ReadinessTemplate>>(){}.getType());
	    /*Integer valueOfReadinessId=Integer.parseInt(nvl(request.getParameter("valueOfReadinessId")));
	    Double valueOfReadinessQuantity=Double.parseDouble(nvl(request.getParameter("valueOfReadinessQuantity")));
	    String valueOfReadinessOwnerName=nvl(request.getParameter("valueOfReadinessOwnerName"));
	    String valueOfReadinessElementStatus=nvl(request.getParameter("valueOfReadinessElementStatus"));
	    String stringValueOfStartDate = nvl(request.getParameter("valueOfReadinessStartDate"));
	    DateFormat formatterStart = new SimpleDateFormat("dd-MM-yyyy");
	    Date startDate = formatterStart.parse(stringValueOfStartDate);
	    
	    String stringValueOfEndDate = nvl(request.getParameter("valueOfReadinessEndDate"));
	    DateFormat formatterEnd = new SimpleDateFormat("dd-MM-yyyy");
	    Date endDate = formatterEnd.parse(stringValueOfEndDate);*/
	    
	    		String readinessElementStatus= readinessTemplateManager.addReadinessTemplateBulk(valueOfReadinessCompanyName, valueOfReadinessSalesPipeLineId, readinessList);
		return readinessElementStatus;
		
	}
	
	
	@RequestMapping(value="/updateReadinessTemplateBulk",method=RequestMethod.POST)
	public @ResponseBody String updateReadinessTemplateBulk(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ParseException{
		
	    String valueOfReadinessCompanyName=nvl(request.getParameter("valueOfReadinessCompanyName"));
	    Integer valueOfReadinessSalesPipeLineId=Integer.parseInt(nvl(request.getParameter("valueOfReadinessSalesPipeLineId")));
	    String readinessArrayValue = request.getParameter("readinessArrayValue");
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    List<ReadinessTemplate> readinessList = gson.fromJson(readinessArrayValue, new TypeToken<List<ReadinessTemplate>>(){}.getType());
	       
	    		String readinessElementStatus= readinessTemplateManager.updateReadinessTemplateBulk(valueOfReadinessCompanyName, valueOfReadinessSalesPipeLineId, readinessList);
		return readinessElementStatus;
		
	}
	
	
	@RequestMapping(value="/updateReadinessTemplate",method=RequestMethod.POST)
	public @ResponseBody String doPersonalityUpdateM(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ParseException{
		
		  String readinessTemplateEditCustomerName=nvl(request.getParameter("readinessTemplateEditCustomerName"));
		    Integer readinessTemplateId=Integer.parseInt(nvl(request.getParameter("readinessTemplateEditId")));
		    Double readinessTemplateEditQuantity=Double.parseDouble(nvl(request.getParameter("readinessTemplateEditQuantity")));
		    String readinessTemplateEditOwnerName=nvl(request.getParameter("readinessTemplateEditOwnerName"));
		    String readinessTemplateEditElementStatus=nvl(request.getParameter("readinessTemplateEditElementStatus"));
		    String stringValueOfStartDate = nvl(request.getParameter("readinessTemplateEditStartDate"));
		    DateFormat formatterStart = new SimpleDateFormat("dd-MM-yyyy");
		    Date startDate = formatterStart.parse(stringValueOfStartDate);
		    
		    String stringValueOfEndDate = nvl(request.getParameter("readinessTemplateEditEndDate"));
		    DateFormat formatterEnd = new SimpleDateFormat("dd-MM-yyyy");
		    Date endDate = formatterEnd.parse(stringValueOfEndDate);
		    
		   
		    		String readinessElementStatus= readinessTemplateManager.updateReadinessTemplate(readinessTemplateEditCustomerName, readinessTemplateId, readinessTemplateEditQuantity, readinessTemplateEditOwnerName, readinessTemplateEditElementStatus, startDate, endDate);
				
			return readinessElementStatus;
		
	}
	
		
	@RequestMapping(value="/listReadinessTemplate",method=RequestMethod.GET)
	public @ResponseBody String getReadinessTemplateList(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		

	    Integer salesPipeLineId=Integer.parseInt(nvl(request.getParameter("salesPipeLineId")));
		
		response.setContentType("application/json");
		
		List<ReadinessTemplate> readinessArrayList=new ArrayList<ReadinessTemplate>();
		readinessArrayList = readinessTemplateManager.listReadinessTemplate(salesPipeLineId);
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(readinessArrayList);
		return json;
	}
	
	
	@RequestMapping(value="/listRTClientName",method=RequestMethod.GET)
	public @ResponseBody String listRTClientName(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		

		response.setContentType("application/json");
		
		List<ReadinessTemplate> readinessArrayList=new ArrayList<ReadinessTemplate>();
		readinessArrayList = readinessTemplateManager.listRTClientName();
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(readinessArrayList);
		return json;
	}
	
	
	@RequestMapping(value="/listReadinessElementName",method=RequestMethod.GET)
	public @ResponseBody String listReadinessElementName(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		

		response.setContentType("application/json");
		
		List<ReadinessTemplate> readinessArrayList=new ArrayList<ReadinessTemplate>();
		readinessArrayList = readinessTemplateManager.listReadinessElementName();
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(readinessArrayList);
		return json;
	}
	
	
	
@RequestMapping(value="/getReadinessTemplateDetailsById",method=RequestMethod.POST)
	public @ResponseBody String getReadinessTemplateDetailsById(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		String json;
	
        Integer readinessTemplateId= Integer.parseInt(nvl(request.getParameter("readinessTemplateId")));
		
		HashMap<String, String> file=readinessTemplateManager.getReadinessTemplateDetaisById(readinessTemplateId);
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    json = gson.toJson(file);
		return json;
		
	}
	
@RequestMapping(value="/deleteReadinessTemplateById",method=RequestMethod.POST)
public @ResponseBody String deleteWarehouseById(HttpSession session,HttpServletRequest request,HttpServletResponse response){
	
	Integer readinessElementId = Integer.parseInt(nvl(request.getParameter("readinessElementId")));
	Integer salesPipeLineId = Integer.parseInt(nvl(request.getParameter("salesPipeLineId")));
	
	
	String status=readinessTemplateManager.deleteReadinessTemplateById(readinessElementId, salesPipeLineId);	
	
	
	return status;
	
}


		
	public static String nvl(String str) {
        return (str == null) ? "" : str.trim();
    }
	
	
	
	
}
