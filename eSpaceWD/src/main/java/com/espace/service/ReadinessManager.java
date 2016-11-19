package com.espace.service;

import java.util.HashMap;
import java.util.List;

import com.espace.model.Readiness;
import com.espace.model.Warehouse;

public interface ReadinessManager {

	
    public String addReadiness(String readinessElementName);
	
	public String updateWarehouse(Integer readinessId,String readinessElement);
	

	public String deleteReadiness(Integer readinessId);

	
	public List<Readiness> listReadinessElements();

	
	public HashMap<String, String> getReadinessById(Integer readinessId);
	
}
