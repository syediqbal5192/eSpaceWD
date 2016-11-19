package com.espace.dao;

import java.util.HashMap;
import java.util.List;

import com.espace.model.Readiness;
import com.espace.model.ReadinessTemplateModel;

public interface ReadinessDao {

	
    public String addReadiness(String readinessElementName);
    
   
	public String updateReadiness(Integer readinessId,String readinessElement);
	

	public String deleteReadiness(Integer readinessId);
	
	
	public List<Readiness> listReadinessElements();

	public HashMap<String, String> getReadinessById(Integer readinessId);
	
	
}
