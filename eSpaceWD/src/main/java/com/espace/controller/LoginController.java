package com.espace.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.espace.service.LoginManager;
import com.espace.service.ProfileManager;

@Controller
public class LoginController {


	@Autowired
	LoginManager loginManager;
	
	@Autowired
	ProfileManager profileManager; 
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public @ResponseBody ModelAndView loginLogic(HttpServletRequest request,HttpServletResponse response){
		
				
		ModelAndView modelView=new ModelAndView();
		
		String userName=request.getParameter("emailId");
		String Password=request.getParameter("password");
		//String image=request.getParameter("image");
		
		
		String loginStatus=loginManager.loginLogin(userName, Password);
		
		
		
		if(loginStatus.equals("successful"))
		{
			List<String> file=profileManager.getProfileByEmail(userName);			
			String FullName=(String) file.get(0); 
			String Designation=(String) file.get(1);
			
	    	request.setAttribute("FullName", FullName);
			request.setAttribute("Designation", Designation); 	
			
			modelView.setViewName("dashboard.jsp");
				
				
		}
		else
		{
			
			     modelView.setViewName("index.jsp");
			
		}
		
		
		return modelView;
		
	} 
	
	
	@RequestMapping(value="signup",method=RequestMethod.POST)
	public ModelAndView signupLogic(HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView modelView=new ModelAndView();
		

		String firstName=request.getParameter("firstName");
		String designation=request.getParameter("designation");
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		
		String signupStatus = loginManager.signupLogicManager(firstName, designation, emailId, password);
		
		if(signupStatus.equals("successful"))
		{
			
			modelView.setViewName("dashboard.jsp");
		}
		else
		{
		 modelView.setViewName("index.jsp");
		}
		
		
		
		
		
		return modelView;
		
	} 
	
	
	
	
}
