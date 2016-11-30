package com.espace.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.espace.entity.CustomerEntity;
import com.espace.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	

	/*Adds New Warehouse to Datatbase*/
	
	@RequestMapping(value="/addCustomer",method=RequestMethod.POST)
	public @ResponseBody String addProductCategory(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ParseException{
		
		String customer_name=nvl(request.getParameter("customer_name"));
		String contact_name_1=nvl(request.getParameter("contact_name_1"));   
		String contact_number_1=nvl(request.getParameter("contact_number_1"));   
		String contact_email_1=nvl(request.getParameter("contact_email_id_1"));   
		String contact_name_2=nvl(request.getParameter("contact_name_2"));   
		String contact_number_2=nvl(request.getParameter("contact_number_2"));   
		String contact_email_2=nvl(request.getParameter("contact_email_id_2"));  
			
	    
				
		String customerStatus= customerService.addCustomer(customer_name, contact_name_1, contact_number_1, contact_email_1, contact_name_2, contact_number_2, contact_email_2);
		return customerStatus;
		
	}
	
	
	@RequestMapping(value="/updateCustomer",method=RequestMethod.POST)
	public @ResponseBody String updateProductCategory(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ParseException
	{
		Integer customer_id = Integer.parseInt(nvl(request.getParameter("customer_id")));
		String customer_name=nvl(request.getParameter("customer_name"));
		String contact_name_1=nvl(request.getParameter("contact_name_1"));   
		String contact_number_1=nvl(request.getParameter("contact_number_1"));   
		String contact_email_1=nvl(request.getParameter("contact_email_id_1"));   
		String contact_name_2=nvl(request.getParameter("contact_name_2"));   
		String contact_number_2=nvl(request.getParameter("contact_number_2"));   
		String contact_email_2=nvl(request.getParameter("contact_email_id_2"));  
		
		String status=customerService.updateCustomer(customer_id, customer_name, contact_name_1, contact_number_1, contact_email_1, contact_name_2, contact_number_2, contact_email_2);
		
		return status;
		
	}
	
	
	
	@RequestMapping(value="/deleteCustomer",method=RequestMethod.POST)
	public @ResponseBody String deleteWarehouseById(HttpSession session,HttpServletRequest request,HttpServletResponse response)
	{
		
		Integer customer_id = Integer.parseInt(nvl(request.getParameter("customer_id")));
			
		String status=customerService.deleteCustomer(customer_id);
			
		return status;
		
	}
	
	
	
	
	@RequestMapping(value="/listCustomer",method=RequestMethod.GET)
	public @ResponseBody String getWarehousesList(HttpSession session,HttpServletRequest request,HttpServletResponse response)
	{
		response.setContentType("application/json");
		
		List<CustomerEntity> customerArrayList=new ArrayList<CustomerEntity>();
		customerArrayList = customerService.listCustomer();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(customerArrayList);
		return json;
	}
	
	
	@RequestMapping(value="/getCustomerById",method=RequestMethod.POST)
	public @ResponseBody String getProductById(HttpSession session,HttpServletRequest request,HttpServletResponse response)
	{
		response.setContentType("application/json");
		
		Integer customer_id = Integer.parseInt(nvl(request.getParameter("customer_id")));
		
		
		List<CustomerEntity> customerArrayList=new ArrayList<CustomerEntity>();
		customerArrayList = customerService.getCustomerById(customer_id);
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(customerArrayList);
	    
		return json;
	}
	
	
	public static String nvl(String str) {
        return (str == null) ? "" : str.trim();
    }
	

}
